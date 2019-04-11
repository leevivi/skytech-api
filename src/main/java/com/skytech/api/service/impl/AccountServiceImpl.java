package com.skytech.api.service.impl;

import com.aliyun.oss.OSSClient;
import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.core.utils.CheckUtil;
import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountDeviceMapper;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.DeviceMapper;
import com.skytech.api.mapper.RunningRecordMapper;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseAccountExample;
import com.skytech.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service("accountService")
public class AccountServiceImpl extends GenericServiceImpl<Account, AccountExample, String> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private AccountDeviceMapper accountDeviceMapper;

    @Autowired
    private RunningRecordMapper runningRecordMapper;

    @Override
    protected AccountMapper getGenericMapper() {
        return this.accountMapper;
    }

    @Override
    public Pagination<Account> findForPage(int page, int limit) {
        AccountExample accountExample = new AccountExample();
        BaseAccountExample.Criteria criteria = accountExample.createCriteria();

        Pagination<Account> pagination = this.queryByPage(accountExample, (page - 1) * limit, limit, "register_datetime desc");

        return pagination;
    }

    @Override
    public Map<String, Object> register(String email, String password, String firstName, String lastName) {
        Map<String, Object> data = new HashMap<>();
        if(!CheckUtil.checkEmail(email)){
            return JsonMap.of(false, "邮箱不合法");
        }

        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andEmailEqualTo(email);

        int i = accountMapper.countByExample(accountExample);
        if (i > 0) { //该邮箱已经存在，直接登陆即可
            data.put("code", "5000");
            data.put("message", "ACCOUNT IS EXITED");

            return data;
        }

        Account account = new Account();
        account.setSid(UUIDUtil.getUUID());
        account.setEmail(email);
        account.setPassword(password);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        int num = accountMapper.insertSelective(account);

        if (num > 0) {
            data.put("code", "2000");
            data.put("message", "SUCCESS");
            data.put("accountSid", account.getSid());
            return data;
        } else {
            data.put("code", "5000");
            data.put("message", "FAILED");

            return data;
        }
    }

    @Override
    public Map<String, Object> login(String email, String password) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);

        List<Account> accounts = accountMapper.selectByExample(accountExample);

        Map<String, Object> data = new HashMap<>();
        if (!accounts.isEmpty()) {
            data.put("account", accounts.get(0));
            AccountDeviceExample accountDeviceExample = new AccountDeviceExample();
            accountDeviceExample.createCriteria().andAccountSidEqualTo(accounts.get(0).getSid()).andDelFlagEqualTo((byte) 0);
            List<AccountDevice> accountDevices = accountDeviceMapper.selectByExample(accountDeviceExample);
            List<String> macAddress = new ArrayList<>();
            List<Object> devicess = new ArrayList<>();

            for (AccountDevice accountDevice : accountDevices) {
                Map<String, Object> devices = new HashMap<>();
                String deviceSid = accountDevice.getDeviceSid();
                Device device = deviceMapper.selectByPrimaryKey(deviceSid);

                macAddress.add(device.getBatch());
                devices.put("deviceSid",deviceSid);
                devices.put("deviceModel",device.getModel());
                devicess.add(devices);
            }
            data.put("macAddress", macAddress);
            data.put("devices", devicess);

            RunningRecordExample runningRecordExample = new RunningRecordExample();
            runningRecordExample.createCriteria().andAccountSidEqualTo(accounts.get(0).getSid());

            BigDecimal distances = new BigDecimal(0);
            int durations = 0;
            List<RunningRecord> runningRecords = runningRecordMapper.selectByExample(runningRecordExample);
            for (RunningRecord record : runningRecords) {
                distances = distances.add(record.getDistance());
                durations += record.getDuration();
            }
            data.put("distances", distances);
            data.put("durations", durations);
            return data;
        } else {
            return null;
        }
    }

    @Override
    public JsonMap save(Account account) {

        AccountExample accountExample = new AccountExample();

        List<Account> accounts = accountMapper.selectByExample(accountExample);

        account.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        account.setRegisterDatetime(new Date());
        int i = accountMapper.insertSelective(account);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String accountSid, Account account) {
        account.setSid(accountSid);
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... accountSids) {

        try {
            for (int i = 0; i < accountSids.length; i++) {
                Account account = new Account();

                account.setSid(accountSids[i]);

                accountMapper.updateByPrimaryKeySelective(account);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public JsonMap saveProfile(String accountSid, Account account, MultipartFile picFile) {
        Account one = accountMapper.selectByPrimaryKey(accountSid);
        one.setStepTarget(account.getStepTarget());
        one.setAge(account.getAge());
        one.setGender(account.getGender());
        one.setHeight(account.getHeight());
        one.setWeight(account.getWeight());
        one.setFirstName(account.getFirstName());
        one.setLastName(account.getLastName());
        one.setUpdatedDatetime(new Date());

        int i = accountMapper.updateByPrimaryKeySelective(one);

        if (i > 0) {

            return JsonMap.of(true, "保存成功");
        }
        return JsonMap.of(false, "保存失败");
    }

    @Override
    public JsonMap saveAvatar(String accountSid, MultipartFile picFile) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-hongkong.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIeUiaiUxdYQYO";
        String accessKeySecret = "wCBWDdag1Rbb21mxk5B7rNQKbn5XCb";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

// 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        Random random = new Random();
        long seed = random.nextLong();
        try {
            ossClient.putObject("skytech-account", "avatar/" + accountSid + seed, picFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

// 关闭OSSClient。
        ossClient.shutdown();

        Account account = accountMapper.selectByPrimaryKey(accountSid);
        account.setAvarta("https://skytech-account.oss-cn-hongkong.aliyuncs.com/avatar/" + accountSid + seed);
        accountMapper.updateByPrimaryKeySelective(account);

        Map<String, Object> data = new HashMap<>();
        data.put("avatarUrl", "https://skytech-account.oss-cn-hongkong.aliyuncs.com/avatar/" + accountSid + seed);

        return JsonMap.of(true, "上传成功", data);
    }
}
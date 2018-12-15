package com.skytech.api.service.impl;

import com.aliyun.oss.OSSClient;
import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.impl.GenericServiceImpl;
import com.owthree.core.utils.Md5Util;
import com.owthree.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.AccountExample;
import com.skytech.api.model.base.BaseAccountExample;
import com.skytech.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service("accountService")
public class AccountServiceImpl extends GenericServiceImpl<Account, AccountExample, String> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

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
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andEmailEqualTo(email);

        int i = accountMapper.countByExample(accountExample);
        if (i > 0) { //该邮箱已经存在，直接登陆即可
            data.put("code", "5000");
            data.put("message", "该邮箱已经存在，直接登陆即可");

            return data;
        }

        Account account = new Account();
        account.setSid(UUIDUtil.getUUID());
        account.setEmail(email);
        account.setPassword(Md5Util.encodeHex(password));
        account.setFirstName(firstName);
        account.setLastName(lastName);
        int num = accountMapper.insertSelective(account);

        if (num > 0) {
            data.put("code", "2000");
            data.put("message", "注册成功");
            data.put("accountSid", account.getSid());
            return data;
        } else {
            data.put("code", "5000");
            data.put("message", "注册失败");

            return data;
        }
    }

    @Override
    public Account login(String email, String password) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(Md5Util.encodeHex(password));

        List<Account> accounts = accountMapper.selectByExample(accountExample);

        if (!accounts.isEmpty()) {
            return accounts.get(0);
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
        try {
            ossClient.putObject("skytech-account", "avatar/" + accountSid, picFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

// 关闭OSSClient。
        ossClient.shutdown();

        Account account = accountMapper.selectByPrimaryKey(accountSid);
        account.setAvarta("https://skytech-account.oss-cn-hongkong.aliyuncs.com/avatar/" + accountSid);
        accountMapper.updateByPrimaryKeySelective(account);

        Map<String, Object> data = new HashMap<>();
        data.put("avatarUrl", "https://skytech-account.oss-cn-hongkong.aliyuncs.com/avatar/" + accountSid);

        return JsonMap.of(true, "上传成功", data);
    }
}
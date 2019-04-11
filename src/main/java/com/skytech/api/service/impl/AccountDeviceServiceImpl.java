package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountDeviceMapper;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.DeviceMapper;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseAccountDeviceExample;
import com.skytech.api.service.AccountDeviceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("accountDeviceService")
public class AccountDeviceServiceImpl extends GenericServiceImpl<AccountDevice, AccountDeviceExample, String> implements AccountDeviceService {

    @Autowired
    private AccountDeviceMapper accountDeviceMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected AccountDeviceMapper getGenericMapper() {
        return this.accountDeviceMapper;
    }

    @Override
    public Pagination<AccountDevice> findForPage(int page, int limit) {
        AccountDeviceExample accountDeviceExample = new AccountDeviceExample();
        BaseAccountDeviceExample.Criteria criteria = accountDeviceExample.createCriteria();

        Pagination<AccountDevice> pagination = this.queryByPage(accountDeviceExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(AccountDevice accountDevice) {

        AccountDeviceExample accountDeviceExample = new AccountDeviceExample();

        List<AccountDevice> accountDevices = accountDeviceMapper.selectByExample(accountDeviceExample);

        accountDevice.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        accountDevice.setCreatedDatetime(new Date());
        int i = accountDeviceMapper.insertSelective(accountDevice);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String accountDeviceSid, AccountDevice accountDevice) {
        accountDevice.setSid(accountDeviceSid);
        int i = accountDeviceMapper.updateByPrimaryKeySelective(accountDevice);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... accountDeviceSids) {

        try {
            for (int i = 0; i < accountDeviceSids.length; i++) {
                AccountDevice accountDevice = new AccountDevice();

                accountDevice.setSid(accountDeviceSids[i]);

                accountDeviceMapper.updateByPrimaryKeySelective(accountDevice);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public JsonMap connect(String accountSid, Device device) {
        DeviceExample deviceExample = new DeviceExample();
        deviceExample.createCriteria().andBatchEqualTo(device.getDeviceId());

        List<Device> devices = deviceMapper.selectByExample(deviceExample);
        Date now = new Date();
        int i = 0;
        String deviceSid = "";
        if (devices.isEmpty()) {
            deviceSid = UUIDUtil.getUUID();

            device.setSid(deviceSid);
            device.setCreatedDatetime(now);
            device.setBatch(device.getDeviceId());
            i = deviceMapper.insertSelective(device);

        } else {

            Device one = devices.get(0);
            deviceSid = one.getSid();
            one.setDeviceId(device.getDeviceId());
            one.setCreatedDatetime(now);
            i = deviceMapper.updateByPrimaryKeySelective(one);
        }

        if (i > 0) {

            Account account = accountMapper.selectByPrimaryKey(accountSid);
            //查询账号是否绑定设备
//            if (StringUtils.endsWithIgnoreCase(account.getEmail(), "skytech.com.hk")) {
                AccountDeviceExample accountDeviceExample = new AccountDeviceExample();
                accountDeviceExample.createCriteria().andAccountSidEqualTo(accountSid);
                List<AccountDevice> accountDevices = this.selectByExample(accountDeviceExample);

                if (!accountDevices.isEmpty()) { //已经绑定过设备的
                    for (AccountDevice ad : accountDevices) {
                        if (StringUtils.equals(ad.getDeviceSid(), deviceSid)) {
                            ad.setDelFlag((byte) 0);
                            accountDeviceMapper.updateByPrimaryKeySelective(ad);
                            device = deviceMapper.selectByPrimaryKey(deviceSid);
                            return JsonMap.of(true, "", device);
                        }
                        //如果账号连接新设备是否需要重新绑定新设备（是否允许一对多）
                    }
                }
//            }

            //查询设备是否被绑定
            AccountDeviceExample accountDeviceExample1 = new AccountDeviceExample();
            accountDeviceExample1.createCriteria().andDeviceSidEqualTo(devices.get(0).getSid());
            List<AccountDevice> accountDevices1 = this.selectByExample(accountDeviceExample1);

            int j = 0;
            if (accountDevices1.isEmpty()) { //设备未被绑定
                AccountDevice accountDevice = new AccountDevice();
                accountDevice.setSid(UUIDUtil.getUUID());
                accountDevice.setAccountSid(accountSid);
                accountDevice.setDeviceSid(deviceSid);
                accountDevice.setDeviceStatus((byte) 1);
                accountDevice.setCreatedDatetime(now);
                accountDevice.setDelFlag((byte) 0);
                j = accountDeviceMapper.insertSelective(accountDevice);
            } else {//设备已被其他账号绑定

                boolean flag = false;
                for (AccountDevice accountDevice : accountDevices1) {
                    String accountSid1 = accountDevice.getAccountSid();
                    if (StringUtils.equals(accountSid, accountSid1)) {
                        flag = true;
                    }
                }

                if (!flag) {
                    return JsonMap.of(false, "The device has been bound to other accounts");
                } else {
                    device = deviceMapper.selectByPrimaryKey(deviceSid);
                    return JsonMap.of(true, "", device);
                }

            }


            if (j > 0) {
                device = deviceMapper.selectByPrimaryKey(deviceSid);
                return JsonMap.of(true, "", device);
            }
        }
        return JsonMap.of(false, "");
    }

    @Override
    public JsonMap disConnect(String accountSid, Device device) {
        Account account = accountMapper.selectByPrimaryKey(accountSid);

        if (StringUtils.endsWithIgnoreCase(account.getEmail(), "skytech.com.hk")) { //香港机场客户
            AccountDeviceExample accountDeviceExample = new AccountDeviceExample();
            accountDeviceExample.createCriteria().andAccountSidEqualTo(accountSid).andDeviceSidEqualTo(device.getSid());
            List<AccountDevice> accountDevices = accountDeviceMapper.selectByExample(accountDeviceExample);
            if (!accountDevices.isEmpty()) {
                AccountDevice accountDevice = accountDevices.get(0);
                accountDevice.setDelFlag((byte) 2); // 暂时解绑
                int i = accountDeviceMapper.updateByPrimaryKeySelective(accountDevice);
                if (i > 0) {
                    return JsonMap.of(true, "SUCCESS");
                }
                return JsonMap.of(false, "FAILED");
            }

        } else {
            AccountDeviceExample accountDeviceExample = new AccountDeviceExample();
            accountDeviceExample.createCriteria().andAccountSidEqualTo(accountSid).andDeviceSidEqualTo(device.getSid());
//            int i = accountDeviceMapper.deleteByExample(accountDeviceExample);
            List<AccountDevice> accountDevices = accountDeviceMapper.selectByExample(accountDeviceExample);

            if (!accountDevices.isEmpty()) {
                AccountDevice accountDevice = accountDevices.get(0);
                accountDevice.setDelFlag((byte) 1); // 真正解绑
                int i = accountDeviceMapper.updateByPrimaryKeySelective(accountDevice);
                if (i > 0) {
                    return JsonMap.of(true, "SUCCESS");
                }
                return JsonMap.of(false, "FAILED");
            }
        }
        return JsonMap.of(false, "FAILED");
    }
}
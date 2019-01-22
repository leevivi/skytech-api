package com.skytech.api;

import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountDeviceMapper;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.DeviceMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.Device;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkytechApiApplicationTests {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private AccountDeviceMapper accountDeviceMapper;

    @Test
    public void contextLoads() {
        System.out.println(0xF000);
        System.out.println(0xF000 + 1);
        System.out.println(0xFFFF);

        System.out.println(Integer.toHexString(61441).toUpperCase());

        String macAddressPre = "34-D0-B8-92";
        for (int i = 61440; i < 61440 + 3500; i++) {
            String macAddress = macAddressPre + Integer.toHexString(i).toUpperCase();
            String email = RandomStringUtils.randomAlphanumeric(6).toLowerCase() + "@skytech.com.hk";
            String password = RandomStringUtils.randomAlphanumeric(8);

            System.out.println(macAddress + "----" + email + "----" + password);

            Account account = new Account();
            String accountSid = UUIDUtil.getUUID();
            account.setSid(accountSid);
            account.setEmail(email);
            account.setPassword(password);

            account.setRegisterDatetime(new Date());
            accountMapper.insertSelective(account);

            Device device = new Device();
            String deviceSid = UUIDUtil.getUUID();
            device.setSid(deviceSid);
            device.setDeviceId("");
            device.setModel("");
            device.setBatch(macAddress);

            deviceMapper.insertSelective(device);

            AccountDevice accountDevice = new AccountDevice();
            accountDevice.setSid(UUIDUtil.getUUID());
            accountDevice.setAccountSid(accountSid);
            accountDevice.setDeviceSid(deviceSid);
            accountDevice.setDeviceStatus((byte) 1);
            accountDevice.setCreatedDatetime(new Date());

            accountDeviceMapper.insertSelective(accountDevice);
        }
    }


}

package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.impl.GenericServiceImpl;
import com.owthree.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountDeviceMapper;
import com.skytech.api.mapper.DeviceMapper;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.AccountDeviceExample;
import com.skytech.api.model.Device;
import com.skytech.api.model.DeviceExample;
import com.skytech.api.model.base.BaseAccountDeviceExample;
import com.skytech.api.service.AccountDeviceService;
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
        deviceExample.createCriteria().andDeviceIdEqualTo(device.getDeviceId());

        List<Device> devices = deviceMapper.selectByExample(deviceExample);
        Date now = new Date();
        int i = 0;

        if (devices.isEmpty()) {
            String deviceSid = UUIDUtil.getUUID();

            device.setSid(deviceSid);
            device.setCreatedDatetime(now);

            i = deviceMapper.insertSelective(device);

        } else {
            Device one = devices.get(0);

            one.setCreatedDatetime(now);
            i = deviceMapper.updateByPrimaryKeySelective(one);
        }

        if (i > 0) {
            AccountDevice accountDevice = new AccountDevice();
            accountDevice.setSid(UUIDUtil.getUUID());
            accountDevice.setAccountSid(accountSid);
            accountDevice.setDeviceSid(device.getDeviceId());
            accountDevice.setDeviceStatus((byte) 1);
            accountDevice.setCreatedDatetime(now);
            int j = accountDeviceMapper.insertSelective(accountDevice);

            if (j > 0) {
                return JsonMap.of(true, "");
            }
        }
        return JsonMap.of(false, "");
    }

    @Override
    public JsonMap disConnect(String accountSid, Device device) {
        AccountDeviceExample accountDeviceExample = new AccountDeviceExample();
        accountDeviceExample.createCriteria().andAccountSidEqualTo(accountSid).andDeviceSidEqualTo(device.getDeviceId());
        int i = accountDeviceMapper.deleteByExample(accountDeviceExample);
        if (i > 0) {
            return JsonMap.of(true, "SUCCESS");
        }
        return JsonMap.of(false, "FAILED");
    }
}
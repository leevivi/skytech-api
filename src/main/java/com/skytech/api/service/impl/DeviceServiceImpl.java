package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.mapper.DeviceMapper;
import com.skytech.api.model.Device;
import com.skytech.api.model.DeviceExample;
import com.skytech.api.model.base.BaseDeviceExample;
import com.skytech.api.service.DeviceService;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("deviceService")
public class DeviceServiceImpl extends GenericServiceImpl<Device, DeviceExample, String> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    protected DeviceMapper getGenericMapper() {
        return this.deviceMapper;
    }

    @Override
    public Pagination<Device> findForPage(int page, int limit) {
        DeviceExample deviceExample = new DeviceExample();
        BaseDeviceExample.Criteria criteria = deviceExample.createCriteria();

        Pagination<Device> pagination = this.queryByPage(deviceExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Device device) {

        DeviceExample deviceExample = new DeviceExample();

        List<Device> devices = deviceMapper.selectByExample(deviceExample);

        device.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        device.setCreatedDatetime(new Date());
        int i = deviceMapper.insertSelective(device);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String deviceSid, Device device) {
        device.setSid(deviceSid);
        int i = deviceMapper.updateByPrimaryKeySelective(device);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... deviceSids) {

        try {
            for (int i = 0; i < deviceSids.length; i++) {
                Device device = new Device();

                device.setSid(deviceSids[i]);

                deviceMapper.updateByPrimaryKeySelective(device);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}
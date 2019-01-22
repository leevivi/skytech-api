package com.skytech.api.mapper;

import com.skytech.api.model.Device;
import com.skytech.api.model.DeviceExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface DeviceMapper extends GenericMapper<Device, DeviceExample, String> {
}
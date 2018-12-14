package com.skytech.api.mapper;

import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.AccountDeviceExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface AccountDeviceMapper extends GenericMapper<AccountDevice, AccountDeviceExample, String> {
}
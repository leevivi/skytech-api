package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.Device;

public interface AccountDeviceService extends GenericService<AccountDevice, String> {

    Pagination<AccountDevice> findForPage(int page, int limit);

    JsonMap save(AccountDevice accountDevice);

    JsonMap update(String accountDeviceSid, AccountDevice accountDevice);

    JsonMap delete(String... accountDeviceSids);

    JsonMap connect(String accountSid, Device device);

    JsonMap disConnect(String accountSid, Device device);
}



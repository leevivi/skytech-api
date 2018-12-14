package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.GenericService;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.Device;

public interface AccountDeviceService extends GenericService<AccountDevice, String> {

    Pagination<AccountDevice> findForPage(int page, int limit);

    JsonMap save(AccountDevice accountDevice);

    JsonMap update(String accountDeviceSid, AccountDevice accountDevice);

    JsonMap delete(String... accountDeviceSids);

    JsonMap connect(String accountSid, Device device);
}



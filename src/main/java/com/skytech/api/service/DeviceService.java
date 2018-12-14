package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.Device;
import com.skytech.api.model.DeviceExample;
import com.owthree.core.service.GenericService;

public interface DeviceService extends GenericService<Device, String> {

    Pagination<Device> findForPage(int page, int limit);

    JsonMap save(Device device);

    JsonMap update(String deviceSid, Device device);

    JsonMap delete(String... deviceSids);
}



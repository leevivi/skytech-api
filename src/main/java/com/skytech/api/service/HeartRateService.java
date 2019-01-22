package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.HeartRate;

import java.util.Date;
import java.util.List;

public interface HeartRateService extends GenericService<HeartRate, String> {

    Pagination<HeartRate> findForPage(int page, int limit);

    JsonMap save(HeartRate heartRate);

    JsonMap update(String heartRateSid, HeartRate heartRate);

    JsonMap delete(String... heartRateSids);

    List<HeartRate> report(String accountSid, String deviceSid, Date startDate, Date endDate);
}



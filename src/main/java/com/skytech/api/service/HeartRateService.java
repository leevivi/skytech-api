package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.HeartRate;
import com.skytech.api.model.HeartRateExample;
import com.owthree.core.service.GenericService;

public interface HeartRateService extends GenericService<HeartRate, String> {

    Pagination<HeartRate> findForPage(int page, int limit);

    JsonMap save(HeartRate heartRate);

    JsonMap update(String heartRateSid, HeartRate heartRate);

    JsonMap delete(String... heartRateSids);
}



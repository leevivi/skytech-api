package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.HeartRate;
import com.skytech.api.model.Steps;
import com.skytech.api.model.StepsExample;
import com.owthree.core.service.GenericService;

import java.util.Date;
import java.util.List;

public interface StepsService extends GenericService<Steps, String> {

    Pagination<Steps> findForPage(int page, int limit);

    JsonMap save(Steps steps);

    JsonMap update(String stepsSid, Steps steps);

    JsonMap delete(String... stepsSids);

    List<Steps> report(String accountSid, String deviceSid, Date startDate, Date endDate);
}



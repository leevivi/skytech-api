package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.Sleep;

import java.util.Date;
import java.util.List;

public interface SleepService extends GenericService<Sleep, String> {

    Pagination<Sleep> findForPage(int page, int limit);

    JsonMap save(Sleep sleep);

    JsonMap update(String sleepSid, Sleep sleep);

    JsonMap delete(String... sleepSids);

    List<Sleep> report(String accountSid, String deviceSid, Date startDate, Date endDate);
}



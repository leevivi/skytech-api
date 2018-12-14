package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.Sleep;
import com.skytech.api.model.SleepExample;
import com.owthree.core.service.GenericService;

public interface SleepService extends GenericService<Sleep, String> {

    Pagination<Sleep> findForPage(int page, int limit);

    JsonMap save(Sleep sleep);

    JsonMap update(String sleepSid, Sleep sleep);

    JsonMap delete(String... sleepSids);
}



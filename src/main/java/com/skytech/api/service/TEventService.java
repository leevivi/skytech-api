package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.Event;
import com.skytech.api.model.TEvent;
import com.skytech.api.model.TEventExample;

import java.util.Map;

/**
 * Created by LiWei on 2019/3/31.
 */
public interface TEventService extends GenericOneService<TEvent, Integer> {
    Pagination<TEvent> findForPage(int companyId,int storesId,int page, int limit);

    JsonMap save(TEvent tEvent);

    JsonMap update(String eventSid, TEvent tEvent);

    JsonMap delete(String... eventSids);

    Map<String,Object> myActivity(int membersId, int eventStatus);
}

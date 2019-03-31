package com.skytech.api.service;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.TEvent;

/**
 * Created by LiWei on 2019/3/31.
 */
public interface MyEventService extends GenericOneService<TEvent,Integer>{
    Pagination<TEvent> findForOnComing(String accountSid,int page, int limit);
    Pagination<TEvent> findForOnGoing(String accountSid,int page, int limit);
    Pagination<TEvent> findForFinished(String accountSid,int page, int limit);
}

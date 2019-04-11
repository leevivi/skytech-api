package com.skytech.api.service;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.TMessage;

import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
public interface MessageService extends GenericOneService<TMessage,Integer> {
    Pagination<TMessage> findForPage(int page, int limit);

    Map<String,Object> myMessage(int memberId, int messageType);
}

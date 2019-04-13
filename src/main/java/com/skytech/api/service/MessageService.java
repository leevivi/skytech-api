package com.skytech.api.service;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.TMemberMessage;
import com.skytech.api.model.TMessage;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
public interface MessageService extends GenericOneService<TMemberMessage,Integer> {
    Pagination<TMemberMessage> findForPage(int memberId,int messageType,int page, int limit);

    Map<String,Object> myMessage(int memberId, int messageType);
}

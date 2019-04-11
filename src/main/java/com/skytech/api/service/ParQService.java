package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.ParQ;

import javax.servlet.http.HttpSession;

/**
 * Created by 1 on 2019/4/10.
 */
public interface ParQService extends GenericOneService<ParQ,Integer>{
    JsonMap save(HttpSession session,ParQ parQ) throws Exception;
    JsonMap update(int dataId,ParQ parQ);
}

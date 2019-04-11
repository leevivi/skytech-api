package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.PhysiologicalIndex;
import com.skytech.api.model.UserData;

import javax.servlet.http.HttpSession;

/**
 * Created by 1 on 2019/4/10.
 */
public interface UserDataService extends GenericOneService<UserData,Integer>{
//    Pagination<PhysiologicalIndex> findForPage(int page, int limit);
    JsonMap save(HttpSession session,UserData userData);
    JsonMap delete(Integer... dataIds);
    JsonMap update(int dataId,UserData userData);
}

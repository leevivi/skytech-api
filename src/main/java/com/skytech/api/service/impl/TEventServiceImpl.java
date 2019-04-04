package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.TEventMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.TEvent;
import com.skytech.api.model.TEventExample;
import com.skytech.api.model.base.BaseTEventExample;
import com.skytech.api.service.TEventService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiWei on 2019/3/31.
 */
@Service("tEventService")
public class TEventServiceImpl extends GenericOneServiceImpl<TEvent,TEventExample,Integer> implements TEventService{

    @Autowired
    private TEventMapper tEventMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected GenericOneMapper<TEvent, TEventExample, Integer> getGenericOneMapper() {
        return this.tEventMapper;
    }
    @Override
    public Pagination<TEvent> findForPage(int companyId, int storesId, int page, int limit) {


        TEventExample eventExample = new TEventExample();
        BaseTEventExample.Criteria criteria = eventExample.createCriteria();
        criteria.andComanyIdEqualTo(companyId).andStoresIdEqualTo(storesId);
        Pagination<TEvent> pagination = this.queryByPage(eventExample, (page - 1) * limit, limit, "created_time desc");

        return pagination;
    }

    @Override
    public JsonMap save(TEvent tEvent) {
        return null;
    }

    @Override
    public JsonMap update(String eventSid, TEvent tEvent) {
        return null;
    }

    @Override
    public JsonMap delete(String... eventSids) {
        return null;
    }


}

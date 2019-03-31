package com.skytech.api.service.impl;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.TEventMapper;
import com.skytech.api.mapper.TEventMembersMapper;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseEventMembersExample;
import com.skytech.api.model.base.BaseTEventExample;
import com.skytech.api.service.MyEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by LiWei on 2019/4/1.
 */
@Service("myEventService")
public class MyEventServiceImpl extends GenericOneServiceImpl<TEvent,TEventExample,Integer> implements MyEventService{
    @Autowired
    private TEventMapper tEventMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TEventMembersMapper tEventMembersMapper;

    @Override
    protected GenericOneMapper<TEvent, TEventExample, Integer> getGenericOneMapper() {
        return this.tEventMapper;
    }

    @Override
    public Pagination<TEvent> findForOnComing(String accountSid, int page, int limit) {

        TEventMembersExample tEventMembersExample = new TEventMembersExample();
        tEventMembersExample.createCriteria().andAccountSidEqualTo(accountSid);
        List<TEventMembers> tEventMemberss = tEventMembersMapper.selectByExample(tEventMembersExample);
        Pagination<TEvent> pagination = null;
        for (TEventMembers tEventMembers:tEventMemberss) {
            TEventExample tEventExample = new TEventExample();
            tEventExample.createCriteria().andIdEqualTo(tEventMembers.getEventId()).andStartDateGreaterThan(new Date());
            pagination = this.queryByPage(tEventExample, (page - 1) * limit, limit, "created_datetime desc");

        }
        return pagination;
    }

    @Override
    public Pagination<TEvent> findForOnGoing(String accountSid, int page, int limit) {
        TEventMembersExample tEventMembersExample = new TEventMembersExample();
        tEventMembersExample.createCriteria().andAccountSidEqualTo(accountSid);
        List<TEventMembers> tEventMemberss = tEventMembersMapper.selectByExample(tEventMembersExample);
        Pagination<TEvent> pagination = null;
        for (TEventMembers tEventMembers:tEventMemberss) {
            TEventExample tEventExample = new TEventExample();
            tEventExample.createCriteria().andIdEqualTo(tEventMembers.getEventId()).andStartDateLessThan(new Date()).andEndDateGreaterThan(new Date());
            pagination = this.queryByPage(tEventExample, (page - 1) * limit, limit, "created_datetime desc");

        }
        return pagination;
    }

    @Override
    public Pagination<TEvent> findForFinished(String accountSid, int page, int limit) {
        TEventMembersExample tEventMembersExample = new TEventMembersExample();
        tEventMembersExample.createCriteria().andAccountSidEqualTo(accountSid);
        List<TEventMembers> tEventMemberss = tEventMembersMapper.selectByExample(tEventMembersExample);
        Pagination<TEvent> pagination = null;
        for (TEventMembers tEventMembers:tEventMemberss) {
            TEventExample tEventExample = new TEventExample();
            tEventExample.createCriteria().andIdEqualTo(tEventMembers.getEventId()).andEndDateLessThan(new Date());
            pagination = this.queryByPage(tEventExample, (page - 1) * limit, limit, "created_datetime desc");

        }
        return pagination;
    }
}

package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.TEventMapper;
import com.skytech.api.mapper.TEventMembersMapper;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseTEventExample;
import com.skytech.api.service.TEventService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/31.
 */
@Service("tEventService")
public class TEventServiceImpl extends GenericOneServiceImpl<TEvent,TEventExample,Integer> implements TEventService{

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
    public Pagination<TEvent> findForPage(int companyId, int storesId, int page, int limit) {
        List<Integer> statusList = new ArrayList<>();
        statusList.add(0);
        statusList.add(1);
        TEventExample eventExample = new TEventExample();
        BaseTEventExample.Criteria criteria = eventExample.createCriteria();
        criteria.andComanyIdEqualTo(companyId).andStoresIdEqualTo(storesId).andEventStatusIn(statusList);
        Pagination<TEvent> pagination = this.queryByPage(eventExample, (page - 1) * limit, limit, "created_time desc");

        return pagination;
    }


    @Override
    public Map<String,Object> myActivity(int membersId, int eventStatus) {
        HashMap<String,Object> data = new HashMap<>();
        List<MyActivity> list = new ArrayList<>();
        TEventMembersExample tEventMembersExample = new TEventMembersExample();
        tEventMembersExample.createCriteria().andMemberIdEqualTo(membersId);
        List<TEventMembers> tEventMemberss = tEventMembersMapper.selectByExample(tEventMembersExample);
        for (TEventMembers tm : tEventMemberss) {
            TEventExample tEventExample = new TEventExample();
            tEventExample.createCriteria().andIdEqualTo(tm.getEventId()).andEventStatusEqualTo(eventStatus);
            List<TEvent> tEvents = tEventMapper.selectByExample(tEventExample);
            for (TEvent tEvent :tEvents) {
                //返回前端所需数据实体对象--MyActivity
                MyActivity myActivity = new MyActivity();
                myActivity.setActivityId(tEvent.getId());
                myActivity.setActivityName(tEvent.getEventName());
                if(tEvent.getEventPic()!=null){
                    myActivity.setActivityPic("http://47.244.99.59:8080/statics"+tEvent.getEventPic());
                }
                else {
                    myActivity.setActivityPic(tEvent.getEventPic());
                }
                TEventMembersExample tEventMembersExample1 = new TEventMembersExample();
                tEventMembersExample1.createCriteria().andEventIdEqualTo(tEvent.getId());
                int joinedNum = tEventMembersMapper.countByExample(tEventMembersExample1);
                myActivity.setActivityJoinedNum(String.valueOf(joinedNum));
                myActivity.setActivityTime(DateUtil.formatStandardDate(tEvent.getStartDate())+"-"+DateUtil.formatStandardDate(tEvent.getEndDate()));
                list.add(myActivity);
            }

        }
        data.put("TEvents",list);
        return data;
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

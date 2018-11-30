package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.impl.GenericServiceImpl;
import com.owthree.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.EventMapper;
import com.skytech.api.mapper.EventMembersMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.Event;
import com.skytech.api.model.EventMembers;
import com.skytech.api.model.EventMembersExample;
import com.skytech.api.model.base.BaseEventMembersExample;
import com.skytech.api.service.EventMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("eventMembersService")
public class EventMembersServiceImpl extends GenericServiceImpl<EventMembers, EventMembersExample, String> implements EventMembersService {

    @Autowired
    private EventMembersMapper eventMembersMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected EventMembersMapper getGenericMapper() {
        return this.eventMembersMapper;
    }

    @Override
    public Pagination<EventMembers> findForPage(int page, int limit) {
        EventMembersExample eventMembersExample = new EventMembersExample();
        BaseEventMembersExample.Criteria criteria = eventMembersExample.createCriteria();

        Pagination<EventMembers> pagination = this.queryByPage(eventMembersExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(EventMembers eventMembers) {

        EventMembersExample eventMembersExample = new EventMembersExample();

        List<EventMembers> eventMemberss = eventMembersMapper.selectByExample(eventMembersExample);

        eventMembers.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
//        eventMembers.setCreatedDatetime(new Date());
        int i = eventMembersMapper.insertSelective(eventMembers);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String eventMembersSid, EventMembers eventMembers) {
        eventMembers.setSid(eventMembersSid);
        int i = eventMembersMapper.updateByPrimaryKeySelective(eventMembers);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... eventMembersSids) {

        try {
            for (int i = 0; i < eventMembersSids.length; i++) {
                EventMembers eventMembers = new EventMembers();

                eventMembers.setSid(eventMembersSids[i]);

                eventMembersMapper.updateByPrimaryKeySelective(eventMembers);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public List<Account> findForEvent(String eventSid) {
        EventMembersExample eventMembersExample = new EventMembersExample();
        eventMembersExample.createCriteria().andEventSidEqualTo(eventSid);

        List<EventMembers> eventMembers = eventMembersMapper.selectByExample(eventMembersExample);
        List<Account> members = new ArrayList<>();
        for (EventMembers eventMember : eventMembers) {
            String accountSid = eventMember.getAccountSid();
            Account account = accountMapper.selectByPrimaryKey(accountSid);
            account.setSteps(10000);

            members.add(account);
        }
        return members;
    }

    @Override
    public JsonMap save(String accountSid, String eventSid) {
        Account account = accountMapper.selectByPrimaryKey(accountSid);

        Event event = eventMapper.selectByPrimaryKey(eventSid);

        EventMembers one = new EventMembers();
        one.setSid(UUIDUtil.getUUID());
        one.setAccountSid(accountSid);
        one.setAccountName(account.getFirstName() + "" + account.getLastName());
        one.setEventSid(eventSid);
        one.setEventName(event.getEventName());

        int i = eventMembersMapper.insertSelective(one);

        if (i > 0) {
            return JsonMap.of(true, "加入成功");
        } else {
            return JsonMap.of(false, "加入失败");
        }

    }
}
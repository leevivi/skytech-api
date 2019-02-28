package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.EventMapper;
import com.skytech.api.mapper.EventMembersMapper;
import com.skytech.api.mapper.StepsMapper;
import com.skytech.api.model.Event;
import com.skytech.api.model.EventMembers;
import com.skytech.api.model.EventMembersExample;
import com.skytech.api.model.base.BaseEventMembersExample;
import com.skytech.api.service.EventMembersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("eventMembersService")
public class EventMembersServiceImpl extends GenericServiceImpl<EventMembers, EventMembersExample, String> implements EventMembersService {

    @Autowired
    private EventMembersMapper eventMembersMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private StepsMapper stepsMapper;

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
    public List<Map<String, Object>> findForEvent(String eventSid) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();

//        List<EventMembers> eventMembers = eventMembersMapper.selectByExample(eventMembersExample);
        List<Map<String, Object>> eventMembers = eventMembersMapper.selectJoinedNumByEventSid(eventSid);
//        List<Map<String, Object>> members = new ArrayList<>();
//        for (Map<String, Object> eventMember : eventMembers) {
//            Map<String, Object> m = new HashMap<>();
//            String accountSid = eventMember.get("accountSid").toString();
//            m.put("accountSid", accountSid);
//            m.put("accountName", eventMember.get("accountName").toString());
//            if (eventMember.get("avarta") != null) {
//                m.put("accountAvatar", eventMember.get("avarta").toString());
//            } else {
//                m.put("accountAvatar", null);
//            }
//
//
//
//
//            StepsExample stepsExample = new StepsExample();
//            stepsExample.createCriteria().andAccountSidEqualTo(accountSid).andRecordDateBetween(startDate, endDate).andDeviceSidIsNotNull();
//
//            Integer steps = 0;
//
//            List<Steps> stepsList = stepsMapper.selectByExample(stepsExample);
//
//            for (Steps record : stepsList) {
//                steps = steps + record.getStepNum();
//            }
//            m.put("steps", eventMember.get("stepNum"));
//
//            members.add(m);
//        }

//        Collections.sort(members, new Comparator<Map<String, Object>>() {
//            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
//                return new BigDecimal(o2.get("steps").toString()).compareTo(new BigDecimal(o1.get("steps").toString()));
//            }
//        });

        return eventMembers;
    }

    @Override
    public Map<String, Object> findForEventDetail(String accountSid, String eventSid) {
        Map<String, Object> data = new HashMap<>();


        Event event = eventMapper.selectByPrimaryKey(eventSid);

        EventMembersExample example = new EventMembersExample();
        example.createCriteria().andEventSidEqualTo(eventSid);
        example.setDistinct(true);
        int count = eventMembersMapper.countByExample(example);

//        List<Map<String, Object>> mapList = eventMembersMapper.selectJoinedNumByEventSid(eventSid);
        event.setMemberNums(count);
        data.put("event", event);


        example = new EventMembersExample();
        example.createCriteria().andEventSidEqualTo(eventSid).andAccountSidEqualTo(accountSid);
        List<EventMembers> isMemberList = eventMembersMapper.selectByExample(example);


        boolean isMember = false;
//
//        int i = 1;
//        Map<String, Object> mine = new HashMap<>();
//        for (Map<String, Object> m : mapList) {
//            String userSid = m.get("accountSid").toString();
//            if (StringUtils.equals(accountSid, userSid)) {
//                isMember = true;
//                if (i > 5) {
//                    mine.put("position", i);
//                    mine.put("accountSid", accountSid);
//                    mine.put("accountName", m.get("accountName"));
//                    mine.put("accountAvatar", m.get("avatar"));
//                    mine.put("steps", m.get("stepNum"));
//                }
//            }
//            i++;
//        }
        if (!isMemberList.isEmpty()) {
            isMember = true;
            data.put("isMember", true);
        } else {
            data.put("isMember", false);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();

        List<Map<String, Object>> eventMembers = eventMembersMapper.selectByEventSid(eventSid, DateUtil.formatStandardDatetime(startDate), DateUtil.formatStandardDatetime(endDate));
        List<Map<String, Object>> members = new ArrayList<>();

        Map<String, Object> mine = new HashMap<>();
        int i = 1;
        for (Map<String, Object> eventMember : eventMembers) {
            Map<String, Object> m = new HashMap<>();
            String userSid = eventMember.get("accountSid").toString();
            m.put("accountSid", userSid);
            m.put("accountName", eventMember.get("accountName").toString());
            if (eventMember.get("avarta") != null) {
                m.put("accountAvatar", eventMember.get("avarta").toString());
            } else {
                m.put("accountAvatar", null);
            }

            m.put("steps", eventMember.get("stepNum"));

            if (i <= 5) {
                members.add(m);
            } else {
//                if (isMember) {

                if (StringUtils.equals(userSid, accountSid)) {
                    mine.put("accountSid", accountSid);
                    mine.put("accountName", eventMember.get("accountName"));
                    mine.put("accountAvatar", eventMember.get("avarta"));
                    if (eventMember.get("staffId") == null) {
                        mine.put("position", "");
                        mine.put("steps", "call HR 87117");
                    } else {
                        mine.put("position", i);
                        mine.put("steps", eventMember.get("stepNum"));
                    }

                }
//                }
            }
            i++;
        }

        data.put("members", members);

        if (mine.get("accountSid") == null) {
            EventMembersExample e = new EventMembersExample();
            e.createCriteria().andEventSidEqualTo(eventSid).andAccountSidEqualTo(accountSid);

            List<EventMembers> eventMembers1 = eventMembersMapper.selectByExample(e);
            if (!eventMembers1.isEmpty()) {
                EventMembers eMember = eventMembers1.get(0);
                mine.put("accountSid", eMember.getAccountSid());
                mine.put("accountName", eMember.getAccountName());
                mine.put("position", "");
                if (StringUtils.isNotBlank(eMember.getStaffId())) {
                    mine.put("steps", 0);
                } else {
                    mine.put("steps", "call HR 87117");
                }
            }
        }

        data.put("mine", mine);

        Date eventStartDate = event.getStartDate();
        Date eventEndDate = event.getEndDate();

        calendar = Calendar.getInstance();
        calendar.setTime(eventEndDate);
        calendar.add(Calendar.DATE, 1);

        eventEndDate = calendar.getTime();
        //剩余天数+1
        int daysNum = DateUtil.getDaysNum(eventStartDate, eventEndDate)+1;

        Date now = new Date();

        if (now.getTime() <= eventStartDate.getTime()) {
            data.put("leftDays", daysNum);
        } else {
            daysNum = DateUtil.getDaysNum(now, eventEndDate);
            data.put("leftDays", daysNum >= 0 ? daysNum : 0);
        }

        return data;
    }

    @Override
    public JsonMap save(String accountSid, String eventSid, String accountName, String staffId) {

        EventMembersExample eventMembersExample = new EventMembersExample();
        eventMembersExample.createCriteria().andEventSidEqualTo(eventSid).andAccountSidEqualTo(accountSid);
        int count = eventMembersMapper.countByExample(eventMembersExample);

        if (count > 0) {
            return JsonMap.of(false, "You had joined this event!");
        }

        Event event = eventMapper.selectByPrimaryKey(eventSid);

        EventMembers one = new EventMembers();
        one.setSid(UUIDUtil.getUUID());
        one.setAccountSid(accountSid);
        one.setAccountName(accountName);
        one.setEventSid(eventSid);
        one.setEventName(event.getEventName());
        one.setStaffId(staffId);
        one.setJoinedDatetime(new Date());
        int i = eventMembersMapper.insertSelective(one);

        if (i > 0) {
            return JsonMap.of(true, "SUCCESS");
        } else {
            return JsonMap.of(false, "FAILED");
        }

    }
}
package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.TEventMapper;
import com.skytech.api.mapper.TEventMembersMapper;
import com.skytech.api.model.EventMembersExample;
import com.skytech.api.model.TEvent;
import com.skytech.api.model.TEventMembers;
import com.skytech.api.model.TEventMembersExample;
import com.skytech.api.model.base.BaseTEventMembersExample;
import com.skytech.api.service.TEventMembersService;
import com.skytech.api.service.TEventService;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by LiWei on 2019/3/31.
 */
@Service("tEventMembersService")
public class TEventMembersServiceImpl extends GenericOneServiceImpl<TEventMembers,TEventMembersExample,Integer> implements TEventMembersService {

    @Autowired
    private TEventMembersMapper tEventMembersMapper;
    @Autowired
    private TEventMapper tEventMapper;

    @Override
    protected GenericOneMapper<TEventMembers, TEventMembersExample, Integer> getGenericOneMapper() {
        return this.tEventMembersMapper;
    }


    @Override
    public Pagination<TEventMembers> findForPage(int page, int limit) {
        TEventMembersExample eventMembersExample = new TEventMembersExample();
        BaseTEventMembersExample.Criteria criteria = eventMembersExample.createCriteria();

        Pagination<TEventMembers> pagination = this.queryByPage(eventMembersExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public List<Map<String, Object>> findForEvent(int eventId) {

       /* List<Map<String, Object>> tEventMembers = tEventMembersMapper.selectJoinedNumByEventSid(eventId);

        return tEventMembers;*/
       return null;
    }

    @Override
    public Integer countNum(int eventId) {
        Integer tEventMembers = tEventMembersMapper.selectJoinedNumByEventId(eventId);

        return tEventMembers;
    }

    @Override
    public Map<String, Object> findForEventDetail(String accountSid, int tEventId) {
        Map<String, Object> data = new HashMap<>();
        TEvent event = tEventMapper.selectByPrimaryKey(tEventId);

        TEventMembersExample example = new TEventMembersExample();
        example.createCriteria().andEventIdEqualTo(tEventId);
        example.setDistinct(true);
        int count = tEventMembersMapper.countByExample(example);

//        List<Map<String, Object>> mapList = eventMembersMapper.selectJoinedNumByEventSid(eventSid);
        event.setMemberNums(count);
        data.put("event", event);


        example = new TEventMembersExample();
        example.createCriteria().andEventIdEqualTo(tEventId).andAccountSidEqualTo(accountSid);
        List<TEventMembers> isMemberList = tEventMembersMapper.selectByExample(example);


        boolean isMember = false;
        if (!isMemberList.isEmpty()) {
            isMember = true;
            data.put("isMember", isMember);
        } else {
            data.put("isMember", isMember);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();

        List<Map<String, Object>> tEventMembers = tEventMembersMapper.selectByEventSid(tEventId, DateUtil.formatStandardDatetime(startDate), DateUtil.formatStandardDatetime(endDate));
        List<Map<String, Object>> members = new ArrayList<>();

        Map<String, Object> mine = new HashMap<>();
        int i = 1;
        for (Map<String, Object> eventMember : tEventMembers) {
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
                if (StringUtils.equals(userSid, accountSid)) {
                    mine.put("accountSid", accountSid);
                    mine.put("accountName", eventMember.get("accountName"));
                    mine.put("accountAvatar", eventMember.get("avarta"));
                    mine.put("position", i);
                    mine.put("steps", eventMember.get("stepNum"));
                }
            }
            i++;
        }

        data.put("members", members);

        if (mine.get("accountSid") == null) {
            TEventMembersExample e = new TEventMembersExample();
            e.createCriteria().andEventIdEqualTo(tEventId).andAccountSidEqualTo(accountSid);

            List<TEventMembers> eventMembers1 = tEventMembersMapper.selectByExample(e);
            if (!eventMembers1.isEmpty()) {
                TEventMembers eMember = eventMembers1.get(0);
                mine.put("accountSid", eMember.getAccountSid());
                mine.put("accountName", eMember.getAccountName());
                mine.put("position", "");
            }
        }

        data.put("mine", mine);
        //剩余天数
        /*Date eventStartDate = event.getStartDate();
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
            daysNum = DateUtil.getDaysNum(now, eventEndDate)+1;
            data.put("leftDays", daysNum >= 0 ? daysNum : 0);
        }*/

        return data;
    }

    @Override
    public JsonMap save(TEventMembers tEventMembers) {
        TEventMembersExample tEventMembersExample = new TEventMembersExample();

        List<TEventMembers> tEventMemberss = tEventMembersMapper.selectByExample(tEventMembersExample);

//        tEventMembers.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
//        eventMembers.setCreatedDatetime(new Date());
        int i = tEventMembersMapper.insertSelective(tEventMembers);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap save(String accountSid, int tEventId, String accountName) {
        TEventMembersExample eventMembersExample = new TEventMembersExample();
        eventMembersExample.createCriteria().andEventIdEqualTo(tEventId).andAccountSidEqualTo(accountSid);
        int count = tEventMembersMapper.countByExample(eventMembersExample);

        if (count > 0) {
            return JsonMap.of(false, "You had joined this event!");
        }

        TEvent event = tEventMapper.selectByPrimaryKey(tEventId);
         Integer tEventMembers = tEventMembersMapper.selectJoinedNumByEventId(tEventId);
       //TODO 活动成员表的活动人数上限改为int型，更新相关映射文件
        if(tEventMembers >= event.getEventUpper()){
            return JsonMap.of(false, "活动人数已达上限");
        }
        TEventMembers one = new TEventMembers();
        one.setAccountSid(accountSid);
        one.setAccountName(accountName);
        one.setEventId(tEventId);
        one.setEventName(event.getEventName());
        one.setJoinedTime(new Date());
        int i = tEventMembersMapper.insertSelective(one);

        if (i > 0) {
            return JsonMap.of(true, "加入成功");
        } else {
            return JsonMap.of(false, "加入失败");
        }

    }

    @Override
    public JsonMap update(int eventMembersSid, TEventMembers tEventMembers) {
        tEventMembers.setId(eventMembersSid);
        int i = tEventMembersMapper.updateByPrimaryKeySelective(tEventMembers);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(int... tEventMembersSids) {
        try {
            for (int i = 0; i < tEventMembersSids.length; i++) {
                TEventMembers eventMembers = new TEventMembers();

                eventMembers.setId(tEventMembersSids[i]);

                tEventMembersMapper.updateByPrimaryKeySelective(eventMembers);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}

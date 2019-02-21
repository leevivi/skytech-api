package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericMapper;
import com.skytech.api.model.EventMembers;
import com.skytech.api.model.EventMembersExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface EventMembersMapper extends GenericMapper<EventMembers, EventMembersExample, String> {

    List<Map<String, Object>> selectByEventSid(@Param("eventSid") String eventSid, @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<Map<String, Object>> selectJoinedNumByEventSid(@Param("eventSid") String eventSid);
}
package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TEventMembers;
import com.skytech.api.model.TEventMembersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TEventMembersMapper extends GenericOneMapper<TEventMembers,TEventMembersExample,Integer>{
    List<Map<String, Object>> selectByEventSid(@Param("eventId") int eventId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    Integer selectJoinedNumByEventId(@Param("eventId") int eventId);

}
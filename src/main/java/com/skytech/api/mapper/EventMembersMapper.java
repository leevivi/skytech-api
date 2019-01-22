package com.skytech.api.mapper;

import com.skytech.api.model.EventMembers;
import com.skytech.api.model.EventMembersExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface EventMembersMapper extends GenericMapper<EventMembers, EventMembersExample, String> {
}
package com.skytech.api.mapper;

import com.skytech.api.model.TeamMembers;
import com.skytech.api.model.TeamMembersExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface TeamMembersMapper extends GenericMapper<TeamMembers, TeamMembersExample, String> {
}
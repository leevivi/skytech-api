package com.skytech.api.mapper;

import com.skytech.api.model.Team;
import com.skytech.api.model.TeamExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface TeamMapper extends GenericMapper<Team, TeamExample, String> {
}
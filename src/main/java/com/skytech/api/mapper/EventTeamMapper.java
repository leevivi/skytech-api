package com.skytech.api.mapper;

import com.skytech.api.model.EventTeam;
import com.skytech.api.model.EventTeamExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface EventTeamMapper extends GenericMapper<EventTeam, EventTeamExample, String> {
}
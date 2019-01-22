package com.skytech.api.mapper;

import com.skytech.api.model.Event;
import com.skytech.api.model.EventExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface EventMapper extends GenericMapper<Event, EventExample, String> {
}
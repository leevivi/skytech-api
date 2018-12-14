package com.skytech.api.mapper;

import com.skytech.api.model.Sleep;
import com.skytech.api.model.SleepExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface SleepMapper extends GenericMapper<Sleep, SleepExample, String> {
}
package com.skytech.api.mapper;

import com.skytech.api.model.Steps;
import com.skytech.api.model.StepsExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface StepsMapper extends GenericMapper<Steps, StepsExample, String> {
}
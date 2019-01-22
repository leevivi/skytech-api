package com.skytech.api.mapper;

import com.skytech.api.model.HeartRate;
import com.skytech.api.model.HeartRateExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface HeartRateMapper extends GenericMapper<HeartRate, HeartRateExample, String> {
}
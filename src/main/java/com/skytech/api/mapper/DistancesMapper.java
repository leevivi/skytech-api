package com.skytech.api.mapper;

import com.skytech.api.model.Distances;
import com.skytech.api.model.DistancesExample;
import com.skytech.api.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface DistancesMapper extends GenericMapper<Distances, DistancesExample, String> {
}
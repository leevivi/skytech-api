package com.skytech.api.mapper;

import com.skytech.api.model.RunningRecord;
import com.skytech.api.model.RunningRecordExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface RunningRecordMapper extends GenericMapper<RunningRecord, RunningRecordExample, String> {
}
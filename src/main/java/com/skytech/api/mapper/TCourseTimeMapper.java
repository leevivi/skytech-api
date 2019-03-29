package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TCourseTime;
import com.skytech.api.model.TCourseTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCourseTimeMapper extends GenericOneMapper<TCourseTime,TCourseTimeExample,Integer>{
}
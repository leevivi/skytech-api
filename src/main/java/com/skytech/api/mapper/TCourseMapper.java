package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TCourse;
import com.skytech.api.model.TCourseExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TCourseMapper extends GenericOneMapper<TCourse,TCourseExample,Integer>{
    List<Integer> selectCourseWeek(@Param("courseId") Map<String,Integer> courseId, @Param("month") Map<String,String> month);
}
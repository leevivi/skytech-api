package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TMemberMessage;
import com.skytech.api.model.TMemberMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMemberMessageMapper extends GenericOneMapper<TMemberMessage,TMemberMessageExample,Integer>{
}
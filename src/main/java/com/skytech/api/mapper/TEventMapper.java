package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TEvent;
import com.skytech.api.model.TEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEventMapper extends GenericOneMapper<TEvent,TEventExample,Integer>{
}
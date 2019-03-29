package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TMessage;
import com.skytech.api.model.TMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageMapper extends GenericOneMapper<TMessage,TMessageExample,Integer>{
}
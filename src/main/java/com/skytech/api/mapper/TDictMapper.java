package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TDict;
import com.skytech.api.model.TDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictMapper extends GenericOneMapper<TDict,TDictExample,Integer>{
}
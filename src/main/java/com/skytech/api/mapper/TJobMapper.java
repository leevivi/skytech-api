package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TJob;
import com.skytech.api.model.TJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TJobMapper extends GenericOneMapper<TJob,TJobExample,Integer>{
}
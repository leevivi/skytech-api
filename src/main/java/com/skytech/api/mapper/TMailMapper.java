package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TMail;
import com.skytech.api.model.TMailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMailMapper extends GenericOneMapper<TMail,TMailExample,Integer>{
}
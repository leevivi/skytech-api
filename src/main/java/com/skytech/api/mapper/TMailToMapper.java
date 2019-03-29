package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TMailTo;
import com.skytech.api.model.TMailToExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMailToMapper extends GenericOneMapper<TMailTo,TMailToExample,Integer>{
}
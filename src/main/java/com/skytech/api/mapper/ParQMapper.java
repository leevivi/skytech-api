package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericMapper;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.ParQ;
import com.skytech.api.model.ParQExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Component;

@Component
public interface ParQMapper extends GenericOneMapper<ParQ,ParQExample,Integer> {

}

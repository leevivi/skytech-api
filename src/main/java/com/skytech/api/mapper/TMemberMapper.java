package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TMember;
import com.skytech.api.model.TMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMemberMapper extends GenericOneMapper<TMember,TMemberExample,Integer>{
}
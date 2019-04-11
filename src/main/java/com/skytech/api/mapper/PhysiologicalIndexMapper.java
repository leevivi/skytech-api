package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericMapper;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.PhysiologicalIndex;
import com.skytech.api.model.PhysiologicalIndexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PhysiologicalIndexMapper extends GenericOneMapper<PhysiologicalIndex,PhysiologicalIndexExample,Integer>{

}
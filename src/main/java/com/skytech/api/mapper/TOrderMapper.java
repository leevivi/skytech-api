package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TOrder;
import com.skytech.api.model.TOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderMapper extends GenericOneMapper<TOrder,TOrderExample,Integer>{
    Integer selectJoinedCourseNum(@Param("eventId") int eventId);
}
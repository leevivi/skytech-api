package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TOrderDetail;
import com.skytech.api.model.TOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

public interface TOrderDetailMapper extends GenericOneMapper<TOrderDetail,TOrderDetailExample,Integer>{
}
package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.Orderdetail;
import com.skytech.api.model.OrderdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdetailMapper extends GenericOneMapper<Orderdetail,OrderdetailExample,Integer>{
}
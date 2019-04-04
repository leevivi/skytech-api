package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TCoupon;
import com.skytech.api.model.TCouponExample;
import java.util.List;

import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

public interface TCouponMapper extends GenericOneMapper<TCoupon,TCouponExample,Integer>{
}
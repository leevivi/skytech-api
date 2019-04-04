package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TCouponLog;
import com.skytech.api.model.TCouponLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponLogMapper extends GenericOneMapper<TCouponLog,TCouponLogExample,Integer>{
}
package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TCouponMembers;
import com.skytech.api.model.TCouponMembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponMembersMapper extends GenericOneMapper<TCouponMembers,TCouponMembersExample,Integer>{
}
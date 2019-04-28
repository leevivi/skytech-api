package com.skytech.api.mapper;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.model.TCouponMembers;
import com.skytech.api.model.TCouponMembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponMembersMapper extends GenericOneMapper<TCouponMembers,TCouponMembersExample,Integer>{
    /**
     * @Title: findByValidityPeriodUnion
     * @Description: 获取公司门店劵
     * @param month
     * @param membersId
     * @param appuser
     * @return
     * @return List<TCouponMembers>
     * @throws
     */
    List<TCouponMembers> findByValidityPeriodUnion(@Param("validityPeriod") String month,
                                                   @Param("memberId") int membersId, @Param("appUser") String appuser, @Param("companyId") Integer companyId, @Param("storesId") Integer storesId);

    /**
     * @Title: findByValidityPeriod
     * @Description: 获取公司劵
     * @param month
     * @param membersId
     * @param appuser
     * @return
     * @return List<TCouponMembers>
     * @throws
     */
    List<TCouponMembers> findByValidityPeriod(@Param("appUser") String appuser);
}
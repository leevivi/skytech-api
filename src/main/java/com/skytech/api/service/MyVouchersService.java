package com.skytech.api.service;

import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.MyVouchers;
import com.skytech.api.model.TCouponMembers;
import com.skytech.api.model.TEvent;

import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/5.
 */
public interface MyVouchersService extends GenericOneService<TCouponMembers,Integer> {
    Pagination<TCouponMembers> findForPage(int memberId, int page, int limit);

    List<MyVouchers> findAllVouchers(String accountSid);
//    Map<String, List<MyVouchers>> findAllVouchers(String accountSid);
//    Map<String, List<MyVouchers>> findAllVouchers(int memberId, int companyId, int storesId);
}

package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.MyOrder;
import com.skytech.api.model.SelectCourseTime;
import com.skytech.api.model.TOrder;

import java.util.List;


/**
 * Created by LiWei on 2019/4/7.
 */
public interface OrderService extends GenericOneService<TOrder,Integer> {
    List<MyOrder> myOrder(String accountSid, int orderStatus);

    JsonMap cancelOrder(String accountSid, String orderNum, int[] courserTimeIds)throws Exception;

    List<SelectCourseTime> cancelConfirm(String accountSid, String orderNum);
}

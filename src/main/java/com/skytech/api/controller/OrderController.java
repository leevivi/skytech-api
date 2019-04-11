package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.TMemberMapper;
import com.skytech.api.model.*;
import com.skytech.api.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;

    @ApiOperation(value = "我的订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "orderStatus", required = true, dataType = "int")
    })
    @PostMapping(value = "/order/myOrder")
    public JsonMap myOrder(HttpSession session, int orderStatus) {
        Map<String, Object> data = new HashMap<>();
        List<MyOrder> list = new ArrayList<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        list = orderService.myOrder(accountSid, orderStatus);

        return JsonMap.of(true, "",list);

    }

    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {
        List<Object> memberInfoList = new ArrayList<>();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.isEmpty()||tMembers.get(0).getCompanyid()==null||tMembers.get(0).getStoresid()==null){
            List<TOrder> list = new ArrayList<>();
            data.put("data", list);
            return data;
        }
        for (TMember tMember :tMembers) {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemberId(tMember.getId());
            memberInfo.setCompanyId(tMember.getCompanyid());
            memberInfo.setStoresId(tMember.getStoresid());
            memberInfoList.add(memberInfo);

        }
        data.put("memberInfoList",memberInfoList);
        return data;
    }
}

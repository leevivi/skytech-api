package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.service.MyVouchersService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by LiWei on 2019/4/5.
 */
@RestController
public class MyVouchersController {
    Logger LOGGER = LoggerFactory.getLogger(MyVouchersController.class);

    @Autowired
    private MyVouchersService myVouchersService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private OrgStoresMapper orgStoresMapper;
    @Autowired
    private OrgCompanyMapper orgCompanyMapper;
    @Autowired
    private TCouponMapper tCouponMapper;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/myVouchers/listForPage")
    public Map<String, Object> listForPage(HttpSession session, int page, int limit) {
        Map<String, Object> data = new HashMap<>();
        Map<String,Map<String,Integer>> mapMap = new HashMap<>();
        List<MemberInfo> memberList = new ArrayList<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        data = checkMembers(data, accountSid);
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) data.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
            }
        }catch (Exception e){
            return JsonMap.of(true, "",data);
        }
        Pagination<TCouponMembers> pagination = myVouchersService.findForPage(memberId,page, limit);

        data.put("code", "2000");
        data.put("message", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TCouponMembers> dataList = pagination.getDataList();
        MyVouchers myVouchers = new MyVouchers();
        for (TCouponMembers tcm : dataList) {

            //健身会所名称取门店名称
           /* OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(storesId);
            myVouchers.setClubName(orgStores.getStoresname());
            TCoupon tCoupon = tCouponMapper.selectByPrimaryKey(tcm.getCouponid());
            myVouchers.setVouchersName(tCoupon.getCouponname());
            //TODO 健身券有效期时间格式和前端统一
            myVouchers.setValidityTime(tcm.getValidityperiod());
            //适用健身会所字段-仅限本门店使用
            myVouchers.setAvailableClub("");*/
        }
        data.put("data",myVouchers);

        return data;
    }

    @ApiOperation(value = "券包管理")
    @GetMapping(value = "/myVouchers/findAllVouchers")
    public Map<String, Object>  findAllVouchers(HttpSession session) {
        Map<String, Object> data = new HashMap<>();
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        Map<String, List<MyVouchers>> allVouchers = new HashMap<>();
        List<MyVouchers> list = new ArrayList();

        list = myVouchersService.findAllVouchers(accountSid);

        data.put("code", "2000");
        data.put("message", "成功");
        data.put("data",list);

        return data;
    }




    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {

        List<Object> memberInfoList = new ArrayList<>();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.isEmpty()||tMembers.get(0).getCompanyid()==null||tMembers.get(0).getStoresid()==null){
            List<TCourse> list = new ArrayList<>();
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

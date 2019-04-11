package com.skytech.api.service.impl;

import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
@Service("orderService")
public class OrderServiceImpl extends GenericOneServiceImpl<TOrder,TOrderExample,Integer> implements OrderService {
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private OrgStoresMapper orgStoresMapper;
    @Autowired
    private TCourseMapper tCourseMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TOrderDetailMapper tOrderDetailMapper;
    @Autowired
    private TCourseTimeMapper tCourseTimeMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private SysBasicDictMapper sysBasicDictMapper;


    @Override
    protected GenericOneMapper<TOrder, TOrderExample, Integer> getGenericOneMapper() {
        return this.tOrderMapper;
    }

    @Override
    public List<MyOrder> myOrder(String accountSid, int orderStatus) {
        List<MyOrder> list = new ArrayList<>();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        List<String> allCourseTime = new ArrayList<>();
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo : memberList) {
                memberId = memberInfo.getMemberId();
                TOrderExample tOrderExample = new TOrderExample();
                tOrderExample.createCriteria().andMemberidEqualTo(memberId).andStatusEqualTo(orderStatus);
                List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
                if(!tOrders.isEmpty()){
                    list = getMyOrder(list, allCourseTime, tOrders);
                }
                //查询所有订单
                else if(orderStatus==3) {
                    TOrderExample tOrderExample1 = new TOrderExample();
                    tOrderExample1.createCriteria().andMemberidEqualTo(memberId);
                    List<TOrder> tOrders1 = tOrderMapper.selectByExample(tOrderExample1);
                    list = getMyOrder(list, allCourseTime, tOrders1);
                }

            }

        }catch (Exception e){
            return list;
        }
        return list;
    }

    public List<MyOrder> getMyOrder(List<MyOrder> list, List<String> allCourseTime, List<TOrder> tOrders) {
        for (TOrder tOrder : tOrders) {
            //新建我的订单实体类-myOrder-返回前端所需数据
            MyOrder myOrder = new MyOrder();
            TCourseTimeExample tCourseTimeExample = new TCourseTimeExample();
            tCourseTimeExample.createCriteria().andCourseidEqualTo(tOrder.getCourseid());
            List<TCourseTime> tCourseTimes = tCourseTimeMapper.selectByExample(tCourseTimeExample);
            for(TCourseTime tct:tCourseTimes){
                allCourseTime.add(DateUtil.formatStandardDate(tct.getCoursedate()) + " " + tct.getStartcoursetime() + "~" + tct.getEndcoursetime());
                myOrder.setAllCourseTime(allCourseTime);
            }
            myOrder.setOrderNum(tOrder.getOrderno());
            myOrder.setOrderDate(tOrder.getOrdertime());
            OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tOrder.getStoresid());
            myOrder.setOrderStoresName(orgStores.getStoresname());
            TCourse tCourse = tCourseMapper.selectByPrimaryKey(tOrder.getCourseid());
            myOrder.setOrderCourseName(tCourse.getTitle());
            if(tCourse.getCoverurl()!=null){
                myOrder.setOrderCourseUrl("http://47.244.189.240:8080/statics" +tCourse.getCoverurl());
            }else{
                myOrder.setOrderCourseUrl(tCourse.getCoverurl());
            }

            SysUser sysUser = sysUserMapper.selectByPrimaryKey(tCourse.getUserid());
            myOrder.setOrderCourserTeacher(sysUser.getNickname());
            myOrder.setOrderCourseCouponNum(String.valueOf(tOrder.getAmount()));
            int status = tOrder.getStatus();
            if (status == 0) {
                myOrder.setOrderStatus("ongoing");
            }
            if (status == 1) {
                myOrder.setOrderStatus("finished");
            }
            if (status == 2) {
                myOrder.setOrderStatus("invalid");
            }
            TOrderDetailExample tOrderDetailExample = new TOrderDetailExample();
            tOrderDetailExample.createCriteria().andOrdernoEqualTo(tOrder.getOrderno());
            List<TOrderDetail> tOrderDetails = tOrderDetailMapper.selectByExample(tOrderDetailExample);
            List<SelectCourseTime> orderCourseTimeList = new ArrayList<>();
            for (TOrderDetail tod :tOrderDetails) {
                TCourseTime tCourseTime = tCourseTimeMapper.selectByPrimaryKey(tod.getCoursetimeid());
                SelectCourseTime selectCourseTime = new SelectCourseTime();
                selectCourseTime.setCourserTimeId(tCourseTime.getId());
                selectCourseTime.setCourseDate(tCourseTime.getCoursedate());
                selectCourseTime.setCourseTime(tCourseTime.getStartcoursetime() + "~" + tCourseTime.getEndcoursetime());
                TCourseTime tCourseTime1 = tCourseTimeMapper.selectByPrimaryKey(tod.getCoursetimeid());
                SysBasicDict sysBasicDict = sysBasicDictMapper.selectByPrimaryKey(tCourseTime1.getClassid());
                selectCourseTime.setClassName(sysBasicDict.getName());
                orderCourseTimeList.add(selectCourseTime);

            }
            myOrder.setOrderCourseTime(orderCourseTimeList);
            list.add(myOrder);
        }
        return list;
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

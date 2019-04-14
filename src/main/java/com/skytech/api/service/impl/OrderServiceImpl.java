package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private TCouponMembersMapper tCouponMembersMapper;


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

    @Transactional
    @Override
    public JsonMap cancelOrder(String accountSid, String orderNum, int[] courserTimeIds) throws Exception{
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        int memberId = 0;
            int oNum = 0;
            int oDNum = 0;
            int oCMNum = 0;
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo : memberList) {
                memberId = memberInfo.getMemberId();
                TOrderExample tOrderExample = new TOrderExample();
                tOrderExample.createCriteria().andOrdernoEqualTo(orderNum);
                List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
                //订单不存在
                if(tOrders.isEmpty()){
                    return JsonMap.of(false, "订单不存在");
                }
                else{

                    for(int i=0;i<courserTimeIds.length;i++){
                        TOrderDetailExample tOrderDetailExample = new TOrderDetailExample();
                        tOrderDetailExample.createCriteria().andCoursetimeidEqualTo(courserTimeIds[i]).andStatusEqualTo(0);
                        List<TOrderDetail> tOrderDetails = tOrderDetailMapper.selectByExample(tOrderDetailExample);
                        //订单中的课程时段不存在
                        if(tOrderDetails.isEmpty()){
                            return JsonMap.of(false, "订单不存在");
                        }
                        else{
                            //判断需要取消的时段是否在可取消时段范围内（大于等于两小时）

                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(new Date());
                            calendar.add(Calendar.HOUR, 2);
                            Date now = calendar.getTime();
                            TCourseTime tCourseTime = tCourseTimeMapper.selectByPrimaryKey(tOrderDetails.get(0).getCoursetimeid());
                            String time = DateUtil.formatStandardDate(tCourseTime.getCoursedate())+" "+tCourseTime.getStartcoursetime();
                            Date courseStartTime = DateUtil.parseDate(time);
                            boolean before = now.before(courseStartTime);
                            //当前时间大于课程开始时间两小时
                            if(before){
                                //订单状态更改为3-退单
                                TOrderDetail tOrderDetail = tOrderDetails.get(0);
                                tOrderDetail.setStatus(3);
                                oDNum = tOrderDetailMapper.updateByPrimaryKeySelective(tOrderDetail);
                                if (oDNum == 0) {
                                    return JsonMap.of(false, "退单失败");
                                }
                                for(int j = 0;j<courserTimeIds.length;j++){
                                    TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
                                    tCouponMembersExample.createCriteria().andOrdernoEqualTo(orderNum).andMemberidEqualTo(memberId).andStatusEqualTo(1);
                                    List<TCouponMembers> tCouponMembersList = tCouponMembersMapper.selectByExample(tCouponMembersExample);
                                    for(TCouponMembers tcm:tCouponMembersList){
                                        //退券
                                        tcm.setOrderno(null);
                                        tcm.setStatus(0);
                                        tcm.setUsedate(null);
                                        oCMNum = tCouponMembersMapper.updateByPrimaryKeySelective(tcm);
                                        if (oCMNum == 0) {
                                            return JsonMap.of(false, "退单失败");
                                        }
                                    }

                                }
                            }
                        }
                    }
                    //修改订单状态
                    TOrderDetailExample tOrderDetailExample = new TOrderDetailExample();
                    tOrderDetailExample.createCriteria().andOrdernoEqualTo(orderNum);
                    List<TOrderDetail> tOrderDetailList = tOrderDetailMapper.selectByExample(tOrderDetailExample);
                    int index = 0;
                    for (TOrderDetail tod :tOrderDetailList) {
                        for(int i =0;i<tOrderDetailList.size();i++){
                            if(tod.getStatus()==0 || tod.getStatus()==1){
                                TOrder tOrder = tOrders.get(0);
                                tOrder.setStatus(0);
                                oNum = tOrderMapper.updateByPrimaryKeySelective(tOrder);
                                index++;
                                break;
                            }
                        }
                        if(index>0){
                            break;
                        }
                        for(int j = 0;j<tOrderDetailList.size();j++){
                            if(tOrderDetailList.get(j).getStatus()==2 ){
                                TOrder tOrder = tOrders.get(0);
                                tOrder.setStatus(1);
                                oNum = tOrderMapper.updateByPrimaryKeySelective(tOrder);
                            }
                        }
                        for(int k = 0;k<tOrderDetailList.size();k++){
                            if(tOrderDetailList.get(k).getStatus()==3 || tOrderDetailList.get(k).getStatus()==4){
                                TOrder tOrder = tOrders.get(0);
                                tOrder.setStatus(2);
                                oNum = tOrderMapper.updateByPrimaryKeySelective(tOrder);
                            }
                        }

                    }
                }
                if (oNum > 0 ) {
                    return JsonMap.of(true, "退单成功");
                } else {
                    return JsonMap.of(false, "退单失败");
                }
            }

        return JsonMap.of(true, "退单成功");
    }

    @Override
    public List<SelectCourseTime> cancelConfirm(String accountSid, String orderNum) {
        List<SelectCourseTime> list = new ArrayList<>();
        List<String> allCourseTime = new ArrayList<>();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo : memberList) {
                memberId = memberInfo.getMemberId();
                TOrderExample tOrderExample = new TOrderExample();
                tOrderExample.createCriteria().andOrdernoEqualTo(orderNum).andMemberidEqualTo(memberId);
                List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
                //订单存在
                if (!tOrders.isEmpty()) {
                    TOrderDetailExample tOrderDetailExample = new TOrderDetailExample();
                    tOrderDetailExample.createCriteria().andOrdernoEqualTo(orderNum).andStatusEqualTo(0);
                    List<TOrderDetail> tOrderDetailList = tOrderDetailMapper.selectByExample(tOrderDetailExample);
                    if(!tOrderDetailList.isEmpty()){
                        for(TOrderDetail tod:tOrderDetailList){
                            TCourseTimeExample tCourseTimeExample = new TCourseTimeExample();
                            tCourseTimeExample.createCriteria().andIdEqualTo(tod.getCoursetimeid()).andCoursedateGreaterThan(new Date());
                            List<TCourseTime> tCourseTimeList = tCourseTimeMapper.selectByExample(tCourseTimeExample);
                            for(TCourseTime tct:tCourseTimeList){
                                SelectCourseTime selectCourseTime = new SelectCourseTime();
                                selectCourseTime.setCourserTimeId(tct.getId());
                                selectCourseTime.setCourseDate(tct.getCoursedate());
                                selectCourseTime.setCourseTime(tct.getStartcoursetime() + "~" + tct.getEndcoursetime());
                                TCourseTime tCourseTime1 = tCourseTimeMapper.selectByPrimaryKey(tod.getCoursetimeid());
                                SysBasicDict sysBasicDict = sysBasicDictMapper.selectByPrimaryKey(tCourseTime1.getClassid());
                                selectCourseTime.setClassName(sysBasicDict.getName());
                                list.add(selectCourseTime);
                            }
                        }
                    }
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
                myOrder.setOrderStatusForInt(0);
            }
            if (status == 1) {
                myOrder.setOrderStatus("finished");
                myOrder.setOrderStatusForInt(1);
            }
            if (status == 2) {
                myOrder.setOrderStatus("invalid");
                myOrder.setOrderStatusForInt(2);
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
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail()).andIsoverdueEqualTo(0);
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.isEmpty()||tMembers.get(0).getCompanyid()==null||tMembers.get(0).getStoresid()==null){
            List<TCourse> list = new ArrayList<>();
            data.put("data", list);
            data.put("memberInfoList", list);
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

package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.core.utils.UUIDUtil;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.model.base.BaseTCourse;
import com.skytech.api.model.base.BaseTCourseExample;
import com.skytech.api.service.CourseService;
import io.swagger.models.auth.In;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by LiWei on 2019/3/31.
 */
@Service("courseService")
public class CourseServiceImpl extends GenericOneServiceImpl<TCourse,TCourseExample,Integer> implements CourseService {

    @Autowired
    private TCourseMapper tCourseMapper;
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TCourseCouponMapper tCourseCouponMapper;
    @Autowired
    private TCourseTimeMapper tCourseTimeMapper;
    @Autowired
    private OrgStoresMapper orgStoresMapper;
    @Autowired
    private OrgCompanyMapper orgCompanyMapper;
    @Autowired
    private SysBasicDictMapper sysBasicDictMapper;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TCouponMembersMapper tCouponMembersMapper;
    @Autowired
    private TCouponMapper tCouponMapper;
    @Autowired
    private TOrderDetailMapper tOrderDetailMapper;

    @Override
    protected GenericOneMapper<TCourse, TCourseExample, Integer> getGenericOneMapper() {
        return this.tCourseMapper;
    }

    @Override
    public Pagination<TCourse> findForPage(int companyId, int storesId, int page, int limit) {
        TCourseExample tCourseExample = new TCourseExample();
        BaseTCourseExample.Criteria criteria = tCourseExample.createCriteria();
        criteria.andCompanyidEqualTo(companyId).andStoresidEqualTo(storesId);
        Pagination<TCourse> pagination = this.queryByPage(tCourseExample, (page - 1) * limit, limit, "createtime desc");

        return pagination;
    }


    @Override
    public Map<String, Object> findForCourseDetail(int id) {
        Map<String, Object> data = new HashMap<>();
        TCourse tCourse = tCourseMapper.selectByPrimaryKey(id);
        //课程已报名人数
        //课程已报名人数根据订单表来计算
        int joinedNum = tOrderMapper.selectJoinedCourseNum(id);
        tCourse.setJoinedNum(joinedNum);
        //老师
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(tCourse.getUserid());
        tCourse.setTeacherName(sysUser.getNickname());
        //门店名称
        OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tCourse.getStoresid());
        tCourse.setStoresName(orgStores.getStoresname());
        //公司名称
        OrgCompany orgCompany = orgCompanyMapper.selectByPrimaryKey(tCourse.getCompanyid());
        tCourse.setCompanyName(orgCompany.getCompanyname());
        data.put("course", tCourse);
        //健身券
        TCourseCouponExample tCourseCouponExample = new TCourseCouponExample();
        tCourseCouponExample.createCriteria().andCourseidEqualTo(id);
        List<TCourseCoupon> tCourseCoupons = tCourseCouponMapper.selectByExample(tCourseCouponExample);
        if(!tCourseCoupons.isEmpty()){
            data.put("coupon", tCourseCoupons.get(0).getCouponnum());
        }
        else {
            data.put("coupon", 0);
        }
        return data;
    }

    @Override
    public List<Map<String, Object>> findForCourse(int courseId) {
        //TODO 统计课程已参加人数，手写sql
//        List<Map<String, Object>> courseMembers = tCourseMapper.selectJoinedNumByEventSid(courseId);
//        return courseMembers;
        return null;
    }

    @Override
    public JsonMap selectWeek(int courseId) {
        //返回该课程当月开课星期安排
        String now = DateUtil.formatmiddledatestr(new Date());
        List<Integer> week = new ArrayList<>();
//            week = tCourseTimeMapper.selectCourseWeek(tCourses.get(0).getId());

        TCourseExample tCourseExample = new TCourseExample();
        tCourseExample.createCriteria().andMonthEqualTo(now).andIdEqualTo(courseId);
        List<TCourse> tCourses = tCourseMapper.selectByExample(tCourseExample);
        if(!tCourses.isEmpty()){
            TCourseTimeExample tCourseTimeExample = new TCourseTimeExample();
            tCourseTimeExample.createCriteria().andCourseidEqualTo(tCourses.get(0).getId());
            List<TCourseTime> tCourseTimes = tCourseTimeMapper.selectByExample(tCourseTimeExample);
            for (TCourseTime tCourseTime :tCourseTimes) {
                week.add(tCourseTime.getWeekid());
            }
            return JsonMap.of(true, "",UUIDUtil.removeDuplicate(week));
        }
        return JsonMap.of(false, "没有对应课程");
    }

    @Override
    public JsonMap selectCourse(int membersId, int courseId,int[] weekIds) {
        TCourseExample tCourseExample = new TCourseExample();
        tCourseExample.createCriteria().andIdEqualTo(courseId);
        List<TCourse> tCourses = tCourseMapper.selectByExample(tCourseExample);
        if(tCourses.isEmpty()){
            return JsonMap.of(false, "没有对应课程");
        }
        HashMap<String,Object> data = new HashMap<>();
        List<Object> list = new ArrayList<>();
        //筛选出用户可选的课程
        for(int i = 0;i<weekIds.length;i++){
            int weekId = weekIds[i];
            TCourseTimeExample tCourseTimeExample = new TCourseTimeExample();
            tCourseTimeExample.createCriteria().andWeekidEqualTo(weekId);
            List<TCourseTime> tCourseTimes = tCourseTimeMapper.selectByExample(tCourseTimeExample);
            for (TCourseTime tCourseTime :tCourseTimes) {
                TOrderDetailExample tOrderDetailExample = new TOrderDetailExample();
                tOrderDetailExample.createCriteria().andCoursetimeidEqualTo(tCourseTime.getId());
                List<TOrderDetail> tOrderDetails = tOrderDetailMapper.selectByExample(tOrderDetailExample);
                if(tOrderDetails.isEmpty()){
                    SysBasicDict sysBasicDict = sysBasicDictMapper.selectByPrimaryKey(tCourseTime.getClassid());
                    tCourseTime.setClassName(sysBasicDict.getName());
                    tCourseTime.setJoined(false);
                    list.add(tCourseTime);

                }
                else {
                    SysBasicDict sysBasicDict = sysBasicDictMapper.selectByPrimaryKey(tCourseTime.getClassid());
                    tCourseTime.setClassName(sysBasicDict.getName());
                    tCourseTime.setJoined(true);
                    list.add(tCourseTime);
//                    data.put("TCourseTime",tCourseTime);
                }
            }
        }
        data.put("TCourseTime",list);
        return JsonMap.of(true, "", data);
        /*TOrderExample tOrderExample = new TOrderExample();
        tOrderExample.createCriteria().andMemberidEqualTo(membersId).andCourseidEqualTo(courseId);
        List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
        for (TOrder tOrder:tOrders) {
            TOrderDetailExample tOrderDetailExample = new TOrderDetailExample();
            tOrderDetailExample.createCriteria().andOrdernoEqualTo(tOrder.getOrderno());
            List<TOrderDetail> tOrderDetails = tOrderDetailMapper.selectByExample(tOrderDetailExample);
            for (TOrderDetail tOrderDetail :tOrderDetails) {
                TCourseTimeExample tCourseTimeExample = new TCourseTimeExample();
                tCourseTimeExample.createCriteria().andIdEqualTo(tOrderDetail.getCoursetimeid());
                List<TCourseTime> tCourseTimes = tCourseTimeMapper.selectByExample(tCourseTimeExample);

            }
        }
        return null;*/
    }

    @Override
    public JsonMap join(int membersId, int courseId,int[] couponIds, int[] tCourseTimeIds) {
        //TODO 课程不需要券情况
        int amount = 0;
        Boolean isNeedCoupon = false;
        for(int i = 0; i<couponIds.length;i++){
            int num = couponIds[i];
            if(num!=0){
                amount=couponIds.length;
                isNeedCoupon = true;
            }
        }
        TCourseExample tCourseExample = new TCourseExample();
        tCourseExample.createCriteria().andIdEqualTo(courseId);
        List<TCourse> tCourses = tCourseMapper.selectByExample(tCourseExample);
        if(tCourses.isEmpty()){
            return JsonMap.of(false, "没有对应课程");
        }
        for(int k = 0;k<tCourseTimeIds.length;k++){
          TCourseTimeExample tCourseTimeExample = new TCourseTimeExample();
          tCourseTimeExample.createCriteria().andIdEqualTo(tCourseTimeIds[k]);
          List<TCourseTime> tCourseTimes = tCourseTimeMapper.selectByExample(tCourseTimeExample);
          if(tCourseTimes.isEmpty()){
              return JsonMap.of(false, "没有对应课程");
          }
        }
        if(isNeedCoupon){
            for(int x = 0;x<couponIds.length;x++){
                TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
                tCouponMembersExample.createCriteria().andIdEqualTo(couponIds[x]).andStatusEqualTo(0);
                List<TCouponMembers> tCouponMembersList = tCouponMembersMapper.selectByExample(tCouponMembersExample);
                //用户可用券为0
                if(tCouponMembersList.isEmpty()){
                    return JsonMap.of(false, "可用券数量不足");
                }
                else {
                    TCourseCouponExample tCourseCouponExample = new TCourseCouponExample();
                    tCourseCouponExample.createCriteria().andCourseidEqualTo(courseId);
                    List<TCourseCoupon> tCourseCoupons = tCourseCouponMapper.selectByExample(tCourseCouponExample);
                    if(!tCourseCoupons.isEmpty()){
                        int couponNumNeed = tCourseCoupons.get(0).getCouponnum() * tCourseTimeIds.length;
                        //用户可用券不足支付选择课程所需券
                        if(tCouponMembersList.size()<couponNumNeed){
                            return JsonMap.of(true, "可用券数量不足");
                        }
                    }
                }
            }
        }

        TOrder one = new TOrder();
        //生成订单（用户课程）
        //订单编号规则：920190401 +11位随机数
        String orderTime = DateUtil.formatPureStandardDate(new Date());
        one.setOrderno(9 + orderTime+ UUIDUtil.getRandom(11));
        one.setCourseid(courseId);
        one.setOrdertime(new Date());
        one.setQuantity(tCourseTimeIds.length);
        one.setAmount(amount);
        one.setMemberid(membersId);
        one.setStatus(Boolean.valueOf("0"));
        one.setCompletedate(null);
        one.setCreatetime(new Date());
        int num = tOrderMapper.insertSelective(one);
        //生成订单详情
        int tODNum = 0;
        for(int j = 0;j<tCourseTimeIds.length;j++){
            TOrderDetail tOrderDetail = new TOrderDetail();
            tOrderDetail.setOrderno(one.getOrderno());
            tOrderDetail.setAmount(amount);
            tOrderDetail.setStatus(0);
            tOrderDetail.setCoursetimeid(tCourseTimeIds[j]);
            tOrderDetail.setCreatetime(new Date());
            tODNum = tOrderDetailMapper.insertSelective(tOrderDetail);
        }
        int tCMNum = 1;
        if(isNeedCoupon){
            tCMNum = 0;
            //清除相应券数量-修改券使用状态
            for(int i =0;i<couponIds.length;i++){
                TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
                tCouponMembersExample.createCriteria().andIdEqualTo(couponIds[i]);
                TCouponMembers tCouponMembers = tCouponMembersMapper.selectByPrimaryKey(couponIds[i]);
                tCouponMembers.setOrderno(one.getOrderno());
                tCouponMembers.setStatus(1);
                tCouponMembers.setUsedate(new Date());
                tCMNum = tCouponMembersMapper.updateByPrimaryKeySelective(tCouponMembers);
            }
        }

        if (num > 0 && tCMNum > 0 && tODNum > 0) {
            return JsonMap.of(true, "加入成功");
        } else {
            return JsonMap.of(false, "加入失败");
        }
    }

    @Override
    public JsonMap save(TCourse tCourse) {
        return null;
    }


    @Override
    public JsonMap update(String eventSid, TCourse tCourse) {
        return null;
    }

    @Override
    public JsonMap delete(String... eventSids) {
        return null;
    }

    @Override
    public JsonMap defaultCoupon(int membersId, int courseId, int courseNum) throws ParseException {
        TCourseExample tCourseExample = new TCourseExample();
        tCourseExample.createCriteria().andIdEqualTo(courseId);
        List<TCourse> tCourses = tCourseMapper.selectByExample(tCourseExample);
        if(tCourses.isEmpty()){
            return JsonMap.of(false, "没有对应课程");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        TCourseCouponExample tCourseCouponExample = new TCourseCouponExample();
        tCourseCouponExample.createCriteria().andCourseidEqualTo(courseId);
        List<TCourseCoupon> tCourseCoupons = tCourseCouponMapper.selectByExample(tCourseCouponExample);
        int couponNum =0;
        Map<String, Object> data = new HashMap<>();
        if(!tCourseCoupons.isEmpty()){
            //需要券最大数量
            couponNum = courseNum*tCourseCoupons.get(0).getCouponnum();
            TMember tMember = tMemberMapper.selectByPrimaryKey(membersId);
            //查询出用户可用的券（有效期内）
            TCouponMembersExample tCouponMembersExample = new TCouponMembersExample();
            tCouponMembersExample.createCriteria().andMemberidEqualTo(membersId).andStatusEqualTo(0);
            List<TCouponMembers> tCouponMembers = tCouponMembersMapper.selectByExample(tCouponMembersExample);

            List<Object> list = new ArrayList<>();
            for (TCouponMembers tCouponMember : tCouponMembers) {
                //有效期内
                Date sd1=df.parse(tCouponMember.getValidityperiod());
                String now = DateUtil.formatmiddledatestr(new Date());
                Date sd2=df.parse(now);

                if(sd1.equals(sd2)) {
                    //对应门店课程使用券

                    TCoupon tCoupons = tCouponMapper.selectByPrimaryKey(tCouponMember.getCouponid());
                    if (tCoupons.getStoresid().equals(tMember.getStoresid()) && tCoupons.getCompanyid().equals(tMember.getCompanyid())) {
//                data.put("tCoupons", tCoupons);
                        list.add(tCoupons);
                    }
                }

            }
            if(list.size()<couponNum){
                data.put("defaultCouponNum",couponNum);
                data.put("availableCoupon",tCouponMembers);
            }
            else{
                data.put("defaultCouponNum",couponNum);
                data.put("availableCoupon",tCouponMembers);
            }
        }
        data.put("defaultCouponNum",couponNum);
        data.put("availableCoupon",0);
        return JsonMap.of(true, "", data);
    }

    @Override
    public JsonMap selectCoupon(int membersId, int courseId) {

        return null;
    }




}
package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.utils.picUtil;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.service.CourseService;
import com.skytech.api.service.EventMembersService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/29.
 */
@EnableTransactionManagement
@RestController
public class CourseController{
    /*@Resource(name = "join")
    private PlatformTransactionManager join;*/
    Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;
    @Autowired
    private EventMembersService eventMembersService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private OrgStoresMapper orgStoresMapper;
    @Autowired
    private TMemberMapper tMemberMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TOrderMapper tOrderMapper;
    @Autowired
    private TCourseMapper tCourseMapper;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/course/listForPage")
    public Map<String, Object> listForPage(HttpSession session, int page, int limit) {
        Map<String, Object> data = new HashMap<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        //保存会员健身会所公司门店id
        Map<String, Object> memberInfoData = new HashMap<>();
        List<Pagination<TCourse>> paginationList = new ArrayList<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList= new ArrayList<>();
//        data = checkMembers(data, accountSid);
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo : memberList) {
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                Pagination<TCourse> pagination = courseService.findForPage(companyId,storesId,page, limit);
                paginationList.add(pagination);
            }
        }catch (Exception e){
            return JsonMap.of(true, "",new ArrayList<>());
        }
        int count = 0;
        data.put("code", "2000");
        data.put("message", "成功");
        List<TCourse> tCourseList = new ArrayList<>();
        for (Pagination<TCourse> pagination : paginationList) {
            List<TCourse> dataList = pagination.getDataList();
            count += pagination.getTotalRowNumber();
            for (TCourse tCourse : dataList) {
                if (tCourse.getCoverurl() != null) {
                    tCourse.setCoverurl(picUtil.getUrl() + tCourse.getCoverurl());
                } else {
                    tCourse.setCoverurl(tCourse.getCoverurl());
                }
//            OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tCourse.getStoresid());
//            tCourse.setStoresName(orgStores.getStoresname());
                if(tCourse.getUserid()==null){
                    tCourse.setTeacherName("");
                }else {
                    SysUser sysUser = sysUserMapper.selectByPrimaryKey(tCourse.getUserid());
                    tCourse.setTeacherName(sysUser.getNickname());
                }
                Integer joinedNum = tOrderMapper.selectJoinedCourseNum(tCourse.getId());
                //返回用户是否已经加入该课程状态
                TOrderExample tOrderExample = new TOrderExample();
                tOrderExample.createCriteria().andMemberidEqualTo(memberId).andCourseidEqualTo(tCourse.getId());
                List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
                if (!tOrders.isEmpty()) {
                    tCourse.setJoined(true);
                } else {
                    tCourse.setJoined(false);
                }
                tCourse.setJoinedNum(joinedNum);
                tCourse.setCoursebody("");
                tCourseList.add(tCourse);
            }
        }
        data.put("data", tCourseList);
        data.put("count", count);
        return data;
    }
    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/course/listById")
    public JsonMap listById(int id) {

        return courseService.findForCourseDetail(id);

    }

    @ApiOperation(value = "选择星期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "courseId", required = true, dataType = "int")
    })
    @PostMapping(value = "/course/selectWeek")
    public JsonMap selectWeek(int courseId) {

        return courseService.selectWeek(courseId);

    }

    @ApiOperation(value = "选择课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "courseId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "weekIds", value = "weekIds", required = true, dataType = "int")
    })
    @PostMapping(value = "/course/selectCourse")
    public JsonMap selectCourse(HttpSession session,int courseId,int[] weekIds) {
        Object accountSidObj = session.getAttribute("accountSid");
        Map<String, Object> data = new HashMap<>();
        List<TCourseTime> list = new ArrayList<>();
        List<TCourseTime> tCourseTimeArrayList = new ArrayList<>();
        String accountSid = accountSidObj.toString();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        TCourse tCourse = tCourseMapper.selectByPrimaryKey(courseId);
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                if(tCourse.getStoresid()==storesId && tCourse.getCompanyid()==companyId){
                    data = courseService.selectCourse(memberId,companyId,storesId,courseId,weekIds);
                    tCourseTimeArrayList = (List<TCourseTime>) data.get("TCourseTime");
                    list.addAll(tCourseTimeArrayList);
                }

            }
        }catch (Exception e){
            return JsonMap.of(true, "",new ArrayList<>());
        }
        return JsonMap.of(true, "",list);

    }

    @ApiOperation(value = "加入课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "courseId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "couponIds", value = "couponIds", required = true, dataType = "int"),
            @ApiImplicitParam(name = "tCourseTimeIds", value = "tCourseTimeIds", required = true, dataType = "int"),
    })
    /*@Bean(name = "join")*/
    @Transactional
    @PostMapping(value = "/course/join")
    public JsonMap join(HttpSession session, int courseId,int[] couponIds, int[] tCourseTimeIds) {
        Map<String, Object> data = new HashMap<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Map<String, Object> memberInfoData = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        TCourse tCourse = tCourseMapper.selectByPrimaryKey(courseId);
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                TMember tMember = tMemberMapper.selectByPrimaryKey(memberId);
                if(tCourse.getCompanyid()==tMember.getCompanyid()&&tCourse.getStoresid()==tMember.getStoresid()){
                    try {
                        return courseService.join(memberId,companyId,storesId, courseId,couponIds, tCourseTimeIds);
                    } catch (Exception e) {
                        return JsonMap.of(false,"加入失败");
                    }
                }
            }
        return JsonMap.of(false, "");

    }

    @ApiOperation(value = "默认券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "courseId", required = true, dataType = "int"),
            @ApiImplicitParam(name = "courseNum", value = "courseNum", required = true, dataType = "int"),
    })
    @PostMapping(value = "/course/defaultCoupon")
    public JsonMap defaultCoupon(HttpSession session, int courseId, int courseNum) throws ParseException {

        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        TCourse tCourse = tCourseMapper.selectByPrimaryKey(courseId);
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                TMember tMember = tMemberMapper.selectByPrimaryKey(memberId);
                if(tCourse.getCompanyid()==tMember.getCompanyid()&&tCourse.getStoresid()==tMember.getStoresid()){
                    return courseService.defaultCoupon(memberId, courseId, courseNum);
                }
            }
        }catch (Exception e){
            return JsonMap.of(true, "",new ArrayList<>());
        }
        return JsonMap.of(false, "");

    }

    @ApiOperation(value = "用户选券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "courseId", required = true, dataType = "int")
    })
    @PostMapping(value = "/course/selectCoupon")
    public JsonMap selectCoupon(HttpSession session, int courseId) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> memberInfoData = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                data = courseService.selectCoupon(memberId, courseId);
                list.add(data);
            }
        }catch (Exception e){
            return JsonMap.of(true, "",data);
        }
        return JsonMap.of(true, "",list);

    }

    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail()).andIsoverdueEqualTo(0);
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        List<Object> memberInfoList = new ArrayList<>();
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

    /*@Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return join;
    }*/
}

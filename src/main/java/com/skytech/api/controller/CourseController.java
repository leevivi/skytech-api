package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
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
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/29.
 */
@RestController
public class CourseController {
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

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/course/listForPage")
    public Map<String, Object> listForPage(HttpSession session, int page, int limit) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        int companyId = tMembers.get(0).getCompanyid();
        int storesId = tMembers.get(0).getStoresid();
        Pagination<TCourse> pagination = courseService.findForPage(companyId,storesId,page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 2000);
        data.put("message", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TCourse> dataList = pagination.getDataList();
        for (TCourse tCourse : dataList) {
//            OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tCourse.getStoresid());
//            tCourse.setStoresName(orgStores.getStoresname());
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(tCourse.getUserid());
            tCourse.setTeacherName(sysUser.getNickname());
            Integer joinedNum = tOrderMapper.selectJoinedCourseNum(tCourse.getId());
            //返回用户是否已经加入该课程状态
            TOrderExample tOrderExample = new TOrderExample();
            tOrderExample.createCriteria().andMemberidEqualTo(tMembers.get(0).getId()).andCourseidEqualTo(tCourse.getId());
            List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
            if(!tOrders.isEmpty()){
                tCourse.setJoined(true);
            }
            else {
                tCourse.setJoined(false);
            }
            tCourse.setJoinedNum(joinedNum);
        }
        data.put("data", dataList);

        return data;
    }
    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/course/listById")
    public JsonMap listById(int id) {

        Map<String, Object> detail = courseService.findForCourseDetail(id);

        return JsonMap.of(true, "", detail);
    }

    @ApiOperation(value = "选择星期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "", required = true, dataType = "Course")
    })
    @PostMapping(value = "/course/selectWeek")
    public JsonMap selectWeek(int courseId) {

        return courseService.selectWeek(courseId);

    }

    @ApiOperation(value = "选择课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "", required = true, dataType = "Course")
    })
    @PostMapping(value = "/course/selectCourse")
    public JsonMap selectCourse(HttpSession session,int courseId,int[] weekIds) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        int membersId = tMembers.get(0).getId();
        return courseService.selectCourse(membersId,courseId,weekIds);

    }

    @ApiOperation(value = "加入课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "", required = true, dataType = "Course")
    })
    @PostMapping(value = "/course/join")
    public JsonMap join(HttpSession session, int courseId,int[] couponIds, int[] tCourseTimeIds) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        int membersId = tMembers.get(0).getId();
        return courseService.join(membersId, courseId,couponIds, tCourseTimeIds);

    }

    @ApiOperation(value = "默认券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "", required = true, dataType = "Course")
    })
    @PostMapping(value = "/course/defaultCoupon")
    public JsonMap defaultCoupon(HttpSession session, int courseId, int courseNum) throws ParseException {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        int membersId = tMembers.get(0).getId();
        return courseService.defaultCoupon(membersId, courseId, courseNum);

    }

    @ApiOperation(value = "用户选券")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "", required = true, dataType = "Course")
    })
    @PostMapping(value = "/course/selectCoupon")
    public JsonMap selectCoupon(HttpSession session, int courseId) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        int membersId = tMembers.get(0).getId();
        return courseService.selectCoupon(membersId, courseId);

    }
}

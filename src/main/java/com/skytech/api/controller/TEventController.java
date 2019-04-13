package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.mapper.*;
import com.skytech.api.model.*;
import com.skytech.api.service.EventMembersService;
import com.skytech.api.service.EventService;
import com.skytech.api.service.TEventMembersService;
import com.skytech.api.service.TEventService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by LiWei on 2019/3/31.
 */
@RestController
public class TEventController {
    Logger LOGGER = LoggerFactory.getLogger(TEventController.class);

    @Autowired
    private TEventService tEventService;
    @Autowired
    private TEventMapper tEventMapper;
    @Autowired
    private OrgStoresMapper orgStoresMapper;
    @Autowired
    private OrgCompanyMapper orgCompanyMapper;
    @Autowired
    private TEventMembersMapper tEventMembersMapper;

    @Autowired
    private TEventMembersService tEventMembersService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/tEvent/listForPage")
    public Map<String, Object> listForPage(HttpSession session, int page, int limit) {
        Map<String, Object> data = new HashMap<>();
        //保存会员健身会所公司门店id
        Map<String, Object> memberInfoData = new HashMap<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<Pagination<TEvent>> paginationList = new ArrayList<>();
        List<MemberInfo> memberList = new ArrayList<>();
        int companyId = 0;
        int storesId = 0;
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo : memberList) {
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                //根据公司门店id查找会员所在健身会所的活动
                Pagination<TEvent> pagination = tEventService.findForPage(companyId, storesId, page, limit);
                paginationList.add(pagination);
            }
        } catch (Exception e) {
            return JsonMap.of(true, "", new ArrayList<>());
        }
        data.put("code", "2000");
        data.put("message", "成功");
        int count = 0;
        List<TEvent> tEventList = new ArrayList<>();
        for (Pagination<TEvent> pagination : paginationList) {
            List<TEvent> dataList = pagination.getDataList();
            count += pagination.getTotalRowNumber();
            for (TEvent tEvent : dataList) {
                Integer members = tEventMembersService.countNum(tEvent.getId());
                tEvent.setMemberNums(members);
                if (tEvent.getEventPic() != null) {
                    tEvent.setEventPic("http://47.244.189.240:8080/statics" + tEvent.getEventPic());
                } else {
                    tEvent.setEventPic(tEvent.getEventPic());
                }
                int index = 0;
                for (MemberInfo memberInfo : memberList) {
                    memberId = memberInfo.getMemberId();
                    TEventMembersExample tEventMembersExample = new TEventMembersExample();
                    tEventMembersExample.createCriteria().andMemberIdEqualTo(memberId).andEventIdEqualTo(tEvent.getId());
                    List<TEventMembers> tEventMembers = tEventMembersMapper.selectByExample(tEventMembersExample);
                    if (!tEventMembers.isEmpty()) {
                        //一个会员所属多个健身会所，只要会员id在活动成员表里就表示已经加入
                        index++;
                    }
                }
                if (index >= 1) {
                    tEvent.setJoined(true);
                } else {
                    tEvent.setJoined(false);
                }
                tEvent.setComanyName("");
                tEvent.setStoresName("");
                tEvent.setEventInfo("");
                tEventList.add(tEvent);
            }
        }
        data.put("data", tEventList);
        data.put("count", count);
        return data;
    }

    @ApiOperation(value = "活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventId", value = "eventId", required = true, dataType = "int")
    })
    @GetMapping(value = "/tEvent/listById")
    public JsonMap listById(HttpSession session, int eventId) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        Map<String, Object> data = new HashMap<>();
        Boolean isJoined = false;
        TEventMembersExample tEventMembersExample = new TEventMembersExample();
        tEventMembersExample.createCriteria().andAccountSidEqualTo(accountSid).andEventIdEqualTo(eventId);
        List<TEventMembers> tEventMembers = tEventMembersMapper.selectByExample(tEventMembersExample);
        TEventExample tEventExample = new TEventExample();
        tEventExample.createCriteria().andIdEqualTo(eventId);
        List<TEvent> tEvents = tEventMapper.selectByExample(tEventExample);
        TEvent tEvent = new TEvent();
        //活动id无效
        if(tEvents.isEmpty()){
            return JsonMap.of(true, "", data);
        }
        else {
            tEvent = tEvents.get(0);
        }
        if (!tEventMembers.isEmpty()) {
            isJoined = true;
            /*会员已经加入活动
            * 判断活动状态-0未开时1进行中2已结束
            * 活动状态为1时则返回上一版app加入活动后的排名页面
            * 活动状态为0时返回活动详情页
            * 活动状态为2时，具体返回数据排名页
            * */
            //活动进行中和活动已结束都可以看到排名
            if (tEvent.getEventStatus() == 1 || tEvent.getEventStatus() == 2) {
                data = tEventMembersService.findForEventDetail(accountSid, eventId);
                return JsonMap.of(true, "", data);
            }
        }
        else{
            if (tEvent.getEventPic() != null) {
                tEvent.setEventPic("http://47.244.189.240:8080/statics" + tEvent.getEventPic());
            } else {
                tEvent.setEventPic(tEvent.getEventPic());
            }
            OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tEvent.getStoresId());
            OrgCompany orgCompany = orgCompanyMapper.selectByPrimaryKey(tEvent.getComanyId());
            tEvent.setStoresName(orgStores.getStoresname());
            tEvent.setComanyName(orgCompany.getCompanyname());
            Integer membersNum = tEventMembersService.countNum(tEvent.getId());
            tEvent.setMemberNums(membersNum);
        }
        if(!isJoined){
            data.put("isMember",false);
            tEvent.setJoined(isJoined);
        }
        else if(isJoined){
            data.put("isMember",true);
            tEvent.setJoined(true);
        }
        if (tEvent.getEventStatus() == 0) {
            tEvent.setStatus("Upcoming");
        }
        else if (tEvent.getEventStatus() == 1) {
            tEvent.setStatus("Ongoing");
        }
        else if (tEvent.getEventStatus() == 2) {
            tEvent.setStatus("Finished");
        }

        Mine mine = new Mine();
        List<Mine> members = new ArrayList<>();
        data.put("mine",mine);
        data.put("members",members);
        data.put("tEvent",tEvent);

        return JsonMap.of(true, "", data);
    }


    @ApiOperation(value = "个人活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/tEvent/listByIdForMe")
    public JsonMap listByIdForMe(HttpSession session, int id) {
        Map<String, Object> data = new HashMap<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList= new ArrayList<>();
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo : memberList) {
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
            }
        }catch (Exception e){
            return JsonMap.of(true, "",data);
        }
        Map<String, Object> detail = tEventMembersService.findForEventDetail(accountSid, id);

        return JsonMap.of(true, "", detail);
    }



    @ApiOperation(value = "加入活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventId", value = "eventId", required = true, dataType = "int")
    })
    @PostMapping(value = "/tEvent/join")
    public JsonMap join(HttpSession session, int eventId) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        int memberId = 0;
        int companyId = 0;
        int storesId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                companyId = memberInfo.getCompanyId();
                storesId = memberInfo.getStoresId();
                TEvent tEvent = tEventMapper.selectByPrimaryKey(eventId);
                //根据活动id查找该活动对应健身会所公司门店id
                //如果会员所属该健身会所公司和门店，则能加入该活动
                if(tEvent.getComanyId()==companyId && tEvent.getStoresId()==storesId){
                    return tEventMembersService.join(accountSid, eventId, memberId);
                }

            }
        }catch (Exception e){
            return JsonMap.of(true, "",data);
        }

        return JsonMap.of(false, "");

    }

    @ApiOperation(value = "我的活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventStatus", value = "eventStatus", required = true, dataType = "int")
    })
    @PostMapping(value = "/tEvent/myActivity")
    public JsonMap myActivity(HttpSession session, int eventStatus) {
        Map<String, Object> data = new HashMap<>();
        List<MyActivity> list = new ArrayList<>();
        List<MyActivity> tEventList = new ArrayList<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                data = tEventService.myActivity(memberId, eventStatus);
                tEventList = (List<MyActivity>) data.get("TEvents");
                list.addAll(tEventList);
            }
        }catch (Exception e){
            return JsonMap.of(true, "",new ArrayList<>());
        }
        return JsonMap.of(true, "",list);

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

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/tEvent/save")
    public JsonMap save(TEvent tEvent) {

        return tEventService.save(tEvent);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "tEvent", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/tEvent/update")
    public JsonMap update(String dataId, TEvent tEvent) {

        return tEventService.update(dataId, tEvent);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/tEvent/delete")
    public JsonMap delete(String sid) {

        return tEventService.delete(sid);

    }
}


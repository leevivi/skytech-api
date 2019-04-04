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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> listForPage(HttpSession session,int page, int limit) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        int companyId = tMembers.get(0).getCompanyid();
        int storesId = tMembers.get(0).getStoresid();
        Boolean isJoined = false;

        Pagination<TEvent> pagination = tEventService.findForPage(companyId,storesId,page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 2000);
        data.put("message", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TEvent> dataList = pagination.getDataList();
        for (TEvent tEvent : dataList) {
            Integer members = tEventMembersService.countNum(tEvent.getId());
            tEvent.setMemberNums(members);
            TEventMembersExample tEventMembersExample = new TEventMembersExample();
            tEventMembersExample.createCriteria().andAccountSidEqualTo(accountSid).andEventIdEqualTo(tEvent.getId());
            List<TEventMembers> tEventMembers = tEventMembersMapper.selectByExample(tEventMembersExample);
            if(!tEventMembers.isEmpty()){
                isJoined = true;
            }
            tEvent.setJoined(isJoined);
            tEvent.setComanyName("");
            tEvent.setStoresName("");
        }
        data.put("data", dataList);

        return data;
    }

    @ApiOperation(value = "活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventId", value = "eventId", required = true, dataType = "int")
    })
    @GetMapping(value = "/tEvent/listById")
    public JsonMap listById(HttpSession session,int eventId) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Boolean isJoined = false;
        TEventMembersExample tEventMembersExample = new TEventMembersExample();
        tEventMembersExample.createCriteria().andAccountSidEqualTo(accountSid).andEventIdEqualTo(eventId);
        List<TEventMembers> tEventMembers = tEventMembersMapper.selectByExample(tEventMembersExample);
        if(!tEventMembers.isEmpty()){
            isJoined = true;
        }
        TEvent tEvent = tEventMapper.selectByPrimaryKey(eventId);
        OrgStores orgStores = orgStoresMapper.selectByPrimaryKey(tEvent.getStoresId());
        OrgCompany orgCompany = orgCompanyMapper.selectByPrimaryKey(tEvent.getComanyId());
        tEvent.setStoresName(orgStores.getStoresname());
        tEvent.setComanyName(orgCompany.getCompanyname());
        Integer members = tEventMembersService.countNum(tEvent.getId());
        tEvent.setMemberNums(members);
        tEvent.setJoined(isJoined);
        return JsonMap.of(true, "", tEvent);
    }

    @ApiOperation(value = "个人活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/tEvent/listBySidForMe")
    public JsonMap listBySidForMe(HttpSession session, int id) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        Map<String, Object> detail = tEventMembersService.findForEventDetail(accountSid, id);

        return JsonMap.of(true, "", detail);
    }

    @ApiOperation(value = "加入活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/tEvent/join")
    public JsonMap join(HttpSession session, int eventId, String accountName, String staffId) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        return tEventMembersService.save(accountSid, eventId, accountName);

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


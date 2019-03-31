package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.mapper.TEventMapper;
import com.skytech.api.model.TEvent;
import com.skytech.api.service.MyEventService;
import com.skytech.api.service.TEventMembersService;
import com.skytech.api.service.TEventService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/31.
 */
@RestController
public class MyEventController {
    Logger LOGGER = LoggerFactory.getLogger(MyEventController.class);

    @Autowired
    private MyEventService myEventService;
    @Autowired
    private TEventMapper tEventMapper;
    @Autowired
    private TEventMembersService tEventMembersService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/myEvent/listForOnComing")
    public Map<String, Object> listForOnComing(HttpSession session, int page, int limit) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Pagination<TEvent> pagination = myEventService.findForOnComing(accountSid,page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TEvent> dataList = pagination.getDataList();
        for (TEvent tEvent : dataList) {
            List<Map<String, Object>> members = tEventMembersService.findForEvent(tEvent.getId());
            tEvent.setMemberNums(members.size());
        }
        data.put("data", dataList);

        return data;
    }
    @GetMapping(value = "/myEvent/listForOnGoing")
    public Map<String, Object> listForOnGoing(HttpSession session, int page, int limit) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Pagination<TEvent> pagination = myEventService.findForOnGoing(accountSid,page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TEvent> dataList = pagination.getDataList();
        for (TEvent tEvent : dataList) {
            List<Map<String, Object>> members = tEventMembersService.findForEvent(tEvent.getId());
            tEvent.setMemberNums(members.size());
        }
        data.put("data", dataList);

        return data;
    }
    @GetMapping(value = "/myEvent/listForFinished")
    public Map<String, Object> listForFinished(HttpSession session, int page, int limit) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Pagination<TEvent> pagination = myEventService.findForFinished(accountSid,page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TEvent> dataList = pagination.getDataList();
        for (TEvent tEvent : dataList) {
            List<Map<String, Object>> members = tEventMembersService.findForEvent(tEvent.getId());
            tEvent.setMemberNums(members.size());
        }
        data.put("data", dataList);

        return data;
    }

    @ApiOperation(value = "个人活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/myEvent/listBySidForMe")
    public JsonMap listBySidForMe(HttpSession session, int id) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        Map<String, Object> detail = tEventMembersService.findForEventDetail(accountSid, id);

        return JsonMap.of(true, "", detail);
    }
}

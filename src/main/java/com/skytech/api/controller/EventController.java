package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.model.Event;
import com.skytech.api.service.EventMembersService;
import com.skytech.api.service.EventService;
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
 * @author 剑神卓凌昭
 * @date 2018-11-06 14:36:15
 */
@RestController
public class EventController {

    Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private EventMembersService eventMembersService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/event/listForPage")
    public Map<String, Object> listForPage(HttpSession session, int page, int limit) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Pagination<Event> pagination = eventService.findForPage(accountSid, page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 2000);
        data.put("message", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<Event> dataList = pagination.getDataList();
        for (Event event : dataList) {
            //机场活动下线处理
            if ("1".equals(event.getSid())) {
                dataList = new ArrayList<>();
                continue;
            }
            List<Map<String, Object>> members = eventMembersService.findForEvent(event.getSid());
            event.setMemberNums(members.size());
            event.setDays(3);
        }
        data.put("data", dataList);

        return data;
    }

    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/event/listBySid")
    public JsonMap listBySid(HttpSession session, String sid) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        Map<String, Object> detail = eventMembersService.findForEventDetail(accountSid, sid);

        return JsonMap.of(true, "", detail);
    }

    @ApiOperation(value = "加入活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/event/join")
    public JsonMap join(HttpSession session, String eventSid, String accountName, String staffId) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        return eventMembersService.save(accountSid, eventSid, accountName, staffId);

    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/event/save")
    public JsonMap save(Event event) {

        return eventService.save(event);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/event/update")
    public JsonMap update(String dataId, Event event) {

        return eventService.update(dataId, event);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/event/delete")
    public JsonMap delete(String sid) {

        return eventService.delete(sid);

    }
}

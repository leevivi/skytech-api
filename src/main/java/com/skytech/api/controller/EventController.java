package com.skytech.api.controller;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.Account;
import com.skytech.api.model.Event;
import com.skytech.api.service.EventMembersService;
import com.skytech.api.service.EventService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 剑神卓凌昭
 * @date 2018-11-06 14:36:15
 */
@RestController
public class EventController {

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
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<Event> pagination = eventService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<Event> dataList = pagination.getDataList();
        for (Event event : dataList) {
            event.setMemberNums(10);
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

        System.out.println(accountSid);

        Event event = eventService.selectByPrimaryKey(sid);

        boolean isMember = false;

        List<Account> members = eventMembersService.findForEvent(sid);

        for (Account member : members) {
            if (StringUtils.equals(accountSid, member.getSid())) {
                isMember = true;
            }
        }

        Map<String, Object> data = new HashMap<>();
        data.put("event", event);
        data.put("isMember", isMember);
        data.put("members", members);

        return JsonMap.of(true, "", data);
    }

    @ApiOperation(value = "加入活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/event/join")
    public JsonMap join(HttpSession session, String eventSid) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        return eventMembersService.save(accountSid, eventSid);

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

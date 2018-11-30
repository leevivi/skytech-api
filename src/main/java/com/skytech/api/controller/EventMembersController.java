package com.skytech.api.controller;

import com.owthree.core.Pagination;
import com.skytech.api.model.EventMembers;
import com.skytech.api.service.EventMembersService;
import com.owthree.core.JsonMap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
*
* @author 剑神卓凌昭
* @date   2018-11-29 19:11:47
*/
@RestController
public class EventMembersController {

    @Autowired
    private EventMembersService eventMembersService;

    @ApiOperation(value="列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/eventMembers/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<EventMembers> pagination = eventMembersService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        data.put("data", pagination.getDataList());

        return data;
    }

    @ApiOperation(value="详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/eventMembers/listBySid")
    public JsonMap listBySid(String sid) {
        EventMembers eventMembers = eventMembersService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", eventMembers);
    }

    @ApiOperation(value="新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventMembers", value = "", required = true, dataType = "EventMembers")
    })
    @PostMapping(value = "/eventMembers/save")
    public JsonMap save(EventMembers eventMembers) {

        return eventMembersService.save(eventMembers);

    }

    @ApiOperation(value="修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "eventMembers", value = "", required = true, dataType = "EventMembers")
    })
    @PostMapping(value = "/eventMembers/update")
    public JsonMap update(String dataId, EventMembers eventMembers) {

        return eventMembersService.update(dataId, eventMembers);

    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/eventMembers/delete")
    public JsonMap delete(String sid) {

        return eventMembersService.delete(sid);

    }
}

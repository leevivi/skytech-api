package com.skytech.api.controller;

import com.owthree.core.Pagination;
import com.skytech.api.model.Event;
import com.skytech.api.service.EventService;
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
* @date   2018-11-06 14:36:15
*/
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @ApiOperation(value="列表")
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
        data.put("data", pagination.getDataList());

        return data;
    }

    @ApiOperation(value="详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/event/listBySid")
    public JsonMap listBySid(String sid) {
        Event event = eventService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", event);
    }

    @ApiOperation(value="新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/event/save")
    public JsonMap save(Event event) {

        return eventService.save(event);

    }

    @ApiOperation(value="修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "event", value = "", required = true, dataType = "Event")
    })
    @PostMapping(value = "/event/update")
    public JsonMap update(String dataId, Event event) {

        return eventService.update(dataId, event);

    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/event/delete")
    public JsonMap delete(String sid) {

        return eventService.delete(sid);

    }
}

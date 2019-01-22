package com.skytech.api.controller;

import com.skytech.api.core.Pagination;
import com.skytech.api.model.EventTeam;
import com.skytech.api.service.EventTeamService;
import com.skytech.api.core.JsonMap;
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
public class EventTeamController {

    @Autowired
    private EventTeamService eventTeamService;

    @ApiOperation(value="列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/eventTeam/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<EventTeam> pagination = eventTeamService.findForPage(page, limit);

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
    @GetMapping(value = "/eventTeam/listBySid")
    public JsonMap listBySid(String sid) {
        EventTeam eventTeam = eventTeamService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", eventTeam);
    }

    @ApiOperation(value="新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventTeam", value = "", required = true, dataType = "EventTeam")
    })
    @PostMapping(value = "/eventTeam/save")
    public JsonMap save(EventTeam eventTeam) {

        return eventTeamService.save(eventTeam);

    }

    @ApiOperation(value="修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "eventTeam", value = "", required = true, dataType = "EventTeam")
    })
    @PostMapping(value = "/eventTeam/update")
    public JsonMap update(String dataId, EventTeam eventTeam) {

        return eventTeamService.update(dataId, eventTeam);

    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/eventTeam/delete")
    public JsonMap delete(String sid) {

        return eventTeamService.delete(sid);

    }
}

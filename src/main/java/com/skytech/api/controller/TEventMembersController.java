package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.model.EventMembers;
import com.skytech.api.model.TEventMembers;
import com.skytech.api.service.EventMembersService;
import com.skytech.api.service.TEventMembersService;
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
 * Created by LiWei on 2019/3/31.
 */
@RestController
public class TEventMembersController {
    @Autowired
    private TEventMembersService tEventMembersService;

    @ApiOperation(value="列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/tEventMembers/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<TEventMembers> pagination = tEventMembersService.findForPage(page, limit);

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
    @GetMapping(value = "/tEventMembers/listBySid")
    public JsonMap listBySid(int id) {
        TEventMembers tEventMembers = tEventMembersService.selectByPrimaryKey(id);

        return JsonMap.of(true, "", tEventMembers);
    }

    @ApiOperation(value="新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eventMembers", value = "", required = true, dataType = "EventMembers")
    })
    @PostMapping(value = "/tEventMembers/save")
    public JsonMap save(TEventMembers tEventMembers) {

        return tEventMembersService.save(tEventMembers);

    }

    @ApiOperation(value="修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "eventMembers", value = "", required = true, dataType = "EventMembers")
    })
    @PostMapping(value = "/tEventMembers/update")
    public JsonMap update(int dataId, TEventMembers tEventMembers) {

        return tEventMembersService.update(dataId, tEventMembers);

    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/tEventMembers/delete")
    public JsonMap delete(int id) {

        return tEventMembersService.delete(id);

    }
}

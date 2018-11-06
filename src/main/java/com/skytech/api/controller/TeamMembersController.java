package com.skytech.api.controller;

import com.owthree.core.Pagination;
import com.skytech.api.model.TeamMembers;
import com.skytech.api.service.TeamMembersService;
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
public class TeamMembersController {

    @Autowired
    private TeamMembersService teamMembersService;

    @ApiOperation(value="列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/teamMembers/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<TeamMembers> pagination = teamMembersService.findForPage(page, limit);

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
    @GetMapping(value = "/teamMembers/listBySid")
    public JsonMap listBySid(String sid) {
        TeamMembers teamMembers = teamMembersService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", teamMembers);
    }

    @ApiOperation(value="新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teamMembers", value = "", required = true, dataType = "TeamMembers")
    })
    @PostMapping(value = "/teamMembers/save")
    public JsonMap save(TeamMembers teamMembers) {

        return teamMembersService.save(teamMembers);

    }

    @ApiOperation(value="修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "teamMembers", value = "", required = true, dataType = "TeamMembers")
    })
    @PostMapping(value = "/teamMembers/update")
    public JsonMap update(String dataId, TeamMembers teamMembers) {

        return teamMembersService.update(dataId, teamMembers);

    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/teamMembers/delete")
    public JsonMap delete(String sid) {

        return teamMembersService.delete(sid);

    }
}

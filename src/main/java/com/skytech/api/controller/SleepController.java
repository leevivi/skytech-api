package com.skytech.api.controller;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.utils.DateUtil;
import com.skytech.api.model.Sleep;
import com.skytech.api.service.SleepService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * @date 2018-12-14 22:27:58
 */
@RestController
public class SleepController {

    @Autowired
    private SleepService sleepService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/sleep/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<Sleep> pagination = sleepService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        data.put("data", pagination.getDataList());

        return data;
    }

    @GetMapping(value = "/sleep/report")
    public Map<String, Object> report(HttpSession session, String deviceSid, String startDate, String endDate) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        List<Sleep> sleeps = sleepService.report(accountSid, deviceSid, DateUtil.parseDate(startDate), DateUtil.parseDate(endDate));

        Map<String, Object> data = new HashMap<>();
        data.put("sleeps", sleeps);

        return JsonMap.of(true, "", data);
    }

    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/sleep/listBySid")
    public JsonMap listBySid(String sid) {
        Sleep sleep = sleepService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", sleep);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sleep", value = "", required = true, dataType = "Sleep")
    })
    @PostMapping(value = "/sleep/save")
    public JsonMap save(HttpSession session, Sleep sleep) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        sleep.setAccountSid(accountSid);
        return sleepService.save(sleep);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "sleep", value = "", required = true, dataType = "Sleep")
    })
    @PostMapping(value = "/sleep/update")
    public JsonMap update(String dataId, Sleep sleep) {

        return sleepService.update(dataId, sleep);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/sleep/delete")
    public JsonMap delete(String sid) {

        return sleepService.delete(sid);

    }
}

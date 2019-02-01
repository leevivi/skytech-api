package com.skytech.api.controller;

import com.alibaba.fastjson.JSON;
import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.model.Steps;
import com.skytech.api.service.StepsService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 剑神卓凌昭
 * @date 2019-01-06 14:22:51
 */
@RestController
public class StepsController {

    private final Logger LOGGER = LoggerFactory.getLogger(StepsController.class);

    @Autowired
    private StepsService stepsService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/steps/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<Steps> pagination = stepsService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        data.put("data", pagination.getDataList());

        return data;
    }

    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/steps/listBySid")
    public JsonMap listBySid(String sid) {
        Steps steps = stepsService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", steps);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "steps", value = "", required = true, dataType = "Steps")
    })
    @PostMapping(value = "/steps/save")
    public JsonMap save(HttpSession session, Steps steps) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        steps.setAccountSid(accountSid);

        LOGGER.info("新增计步" + JSON.toJSONString(steps));
        return stepsService.save(steps);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "steps", value = "", required = true, dataType = "Steps")
    })
    @PostMapping(value = "/steps/update")
    public JsonMap update(String dataId, Steps steps) {

        return stepsService.update(dataId, steps);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/steps/delete")
    public JsonMap delete(String sid) {

        return stepsService.delete(sid);

    }

    @GetMapping(value = "/steps/report")
    public Map<String, Object> report(HttpSession session, String deviceSid, String startDate, String endDate) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        List<Steps> steps = stepsService.report(accountSid, deviceSid, DateUtil.parseDate(startDate), DateUtil.parseDate(endDate));

        Map<String, Object> data = new HashMap<>();
        data.put("steps", steps);

        return JsonMap.of(true, "", data);
    }

    @GetMapping(value = "/steps/getCurrentSteps")
    public Map<String, Object> getCurrentSteps(HttpSession session) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Integer steps = stepsService.getCurrentSteps(accountSid);

        Map<String, Object> data = new HashMap<>();
        data.put("steps", steps);

        return JsonMap.of(true, "", data);
    }
}

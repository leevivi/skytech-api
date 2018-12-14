package com.skytech.api.controller;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.HeartRate;
import com.skytech.api.service.HeartRateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 剑神卓凌昭
 * @date 2018-12-14 22:27:58
 */
@RestController
public class HeartRateController {

    @Autowired
    private HeartRateService heartRateService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/heartRate/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<HeartRate> pagination = heartRateService.findForPage(page, limit);

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
    @GetMapping(value = "/heartRate/listBySid")
    public JsonMap listBySid(String sid) {
        HeartRate heartRate = heartRateService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", heartRate);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "heartRate", value = "", required = true, dataType = "HeartRate")
    })
    @PostMapping(value = "/heartRate/save")
    public JsonMap save(HttpSession session, HeartRate heartRate) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        heartRate.setAccountSid(accountSid);
        return heartRateService.save(heartRate);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "heartRate", value = "", required = true, dataType = "HeartRate")
    })
    @PostMapping(value = "/heartRate/update")
    public JsonMap update(String dataId, HeartRate heartRate) {

        return heartRateService.update(dataId, heartRate);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/heartRate/delete")
    public JsonMap delete(String sid) {

        return heartRateService.delete(sid);

    }
}

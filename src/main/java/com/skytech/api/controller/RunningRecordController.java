package com.skytech.api.controller;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.RunningRecord;
import com.skytech.api.service.RunningRecordService;
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
 * @date 2018-11-06 14:36:15
 */
@RestController
public class RunningRecordController {

    @Autowired
    private RunningRecordService runningRecordService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/runningRecord/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<RunningRecord> pagination = runningRecordService.findForPage(page, limit);

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
    @GetMapping(value = "/runningRecord/listBySid")
    public JsonMap listBySid(String sid) {
        RunningRecord runningRecord = runningRecordService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", runningRecord);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "runningRecord", value = "", required = true, dataType = "RunningRecord")
    })
    @PostMapping(value = "/runningRecord/save")
    public JsonMap save(HttpSession session, RunningRecord runningRecord) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        runningRecord.setAccountSid(accountSid);
        return runningRecordService.save(runningRecord);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "runningRecord", value = "", required = true, dataType = "RunningRecord")
    })
    @PostMapping(value = "/runningRecord/update")
    public JsonMap update(String dataId, RunningRecord runningRecord) {

        return runningRecordService.update(dataId, runningRecord);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/runningRecord/delete")
    public JsonMap delete(String sid) {

        return runningRecordService.delete(sid);

    }
}

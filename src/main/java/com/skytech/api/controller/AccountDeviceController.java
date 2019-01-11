package com.skytech.api.controller;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.AccountDevice;
import com.skytech.api.model.Device;
import com.skytech.api.service.AccountDeviceService;
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
 * @date 2018-12-01 23:22:09
 */
@RestController
public class AccountDeviceController {

    @Autowired
    private AccountDeviceService accountDeviceService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/accountDevice/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<AccountDevice> pagination = accountDeviceService.findForPage(page, limit);

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
    @GetMapping(value = "/accountDevice/listBySid")
    public JsonMap listBySid(String sid) {
        AccountDevice accountDevice = accountDeviceService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", accountDevice);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountDevice", value = "", required = true, dataType = "AccountDevice")
    })
    @PostMapping(value = "/accountDevice/save")
    public JsonMap save(AccountDevice accountDevice) {

        return accountDeviceService.save(accountDevice);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "accountDevice", value = "", required = true, dataType = "AccountDevice")
    })
    @PostMapping(value = "/accountDevice/update")
    public JsonMap update(String dataId, AccountDevice accountDevice) {

        return accountDeviceService.update(dataId, accountDevice);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/accountDevice/delete")
    public JsonMap delete(String sid) {

        return accountDeviceService.delete(sid);

    }

    @PostMapping(value = "/accountDevice/connect")
    public JsonMap connect(HttpSession session, Device device) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        return accountDeviceService.connect(accountSid, device);

    }

    @PostMapping(value = "/accountDevice/disConnect")
    public JsonMap disConnect(HttpSession session, Device device) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        return accountDeviceService.disConnect(accountSid, device);

    }
}

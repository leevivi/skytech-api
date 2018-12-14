package com.skytech.api.controller;

import com.owthree.core.Pagination;
import com.skytech.api.model.Device;
import com.skytech.api.service.DeviceService;
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
* @date   2018-12-01 23:22:09
*/
@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation(value="列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/device/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<Device> pagination = deviceService.findForPage(page, limit);

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
    @GetMapping(value = "/device/listBySid")
    public JsonMap listBySid(String sid) {
        Device device = deviceService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", device);
    }

    @ApiOperation(value="新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "device", value = "", required = true, dataType = "Device")
    })
    @PostMapping(value = "/device/save")
    public JsonMap save(Device device) {

        return deviceService.save(device);

    }

    @ApiOperation(value="修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "device", value = "", required = true, dataType = "Device")
    })
    @PostMapping(value = "/device/update")
    public JsonMap update(String dataId, Device device) {

        return deviceService.update(dataId, device);

    }

    @ApiOperation(value="删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/device/delete")
    public JsonMap delete(String sid) {

        return deviceService.delete(sid);

    }
}

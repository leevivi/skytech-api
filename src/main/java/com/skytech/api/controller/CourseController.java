package com.skytech.api.controller;

import com.skytech.api.core.Pagination;
import com.skytech.api.model.Event;
import com.skytech.api.model.TCourse;
import com.skytech.api.service.CourseService;
import com.skytech.api.service.EventMembersService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/29.
 */
@RestController
public class CourseController {
    Logger LOGGER = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;
    @Autowired
    private EventMembersService eventMembersService;
    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/course/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<TCourse> pagination = courseService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        List<TCourse> dataList = pagination.getDataList();
       /* for (TCourse tCourse : dataList) {

            List<Map<String, Object>> members = eventMembersService.findForEvent(tCourse.getId());
            tCourse.setMemberNums(members.size());
            tCourse.setDays(3);
        }*/
        data.put("data", dataList);

        return data;
    }
}

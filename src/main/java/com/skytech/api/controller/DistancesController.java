package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.model.Distances;
import com.skytech.api.service.DistancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 剑神卓凌昭
 * @date 2019-02-01 22:08:44
 */
@RestController
public class DistancesController {

    @Autowired
    private DistancesService distancesService;

    @PostMapping(value = "/distances/synchronous")
    public JsonMap synchronous(HttpSession session, Distances distances) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        return distancesService.doSynchronous(accountSid, distances);

    }
}

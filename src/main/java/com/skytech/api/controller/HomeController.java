package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.model.Account;
import com.skytech.api.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @author 剑神卓凌昭
 * @date 2019-01-06 14:22:51
 */
@RestController
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private StepsService stepsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private SleepService sleepService;

    @Autowired
    private RunningRecordService runningRecordService;

    @Autowired
    private HeartRateService heartRateService;


    @GetMapping(value = "/home/getCurrentData")
    public Map<String, Object> report(HttpServletRequest request, HttpSession session) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        Account account = accountService.selectByPrimaryKey(accountSid);

        Date lockintime = new Date();

        Integer steps = stepsService.getCurrentSteps(accountSid);
        Map<String, Object> currentData = runningRecordService.getCurrentData(accountSid);

        currentData.put("steps", steps);

        Integer heartRate = heartRateService.getNewest(accountSid);
        currentData.put("heartRate", heartRate);

        currentData.put("stepTarget", account.getStepTarget());

        Integer sleepMin = sleepService.getCurrentSleep(accountSid);
        currentData.put("sleepMin", sleepMin);

        if (account.getLockintime() != null) {
            currentData.put("lockintime", DateUtil.formatStandardDatetime(account.getLockintime()));
        } else {
            currentData.put("lockintime", DateUtil.formatStandardDatetime(new Date()));
        }

        account.setLockintime(lockintime);
        accountService.updateByPrimaryKeySelective(account);
        return JsonMap.of(true, "", currentData);
    }

}

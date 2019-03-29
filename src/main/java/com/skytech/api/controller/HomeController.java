package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.utils.DateUtil;
import com.skytech.api.model.Account;
import com.skytech.api.model.Distances;
import com.skytech.api.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private DistancesService distancesService;


    @GetMapping(value = "/home/getCurrentData")
    public Map<String, Object> report(HttpServletRequest request, HttpSession session) {
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        Account account = accountService.selectByPrimaryKey(accountSid);

        Date lockintime = new Date();

        Integer steps = stepsService.getCurrentSteps(accountSid);
        Map<String, Object> currentData = new HashMap<>();

        currentData.put("steps", steps);

//        String heart = heartRateService.getNewest(accountSid);
        String heart = heartRateService.getRecent(accountSid);
        String heartRate = heart.split(",")[0];
        String heartRateRecordTime = heart.split(",")[1];
        currentData.put("heartRate", heartRate);
        currentData.put("heartRateRecordTime", heartRateRecordTime);

        currentData.put("stepTarget", account.getStepTarget());

        Integer sleepMin = sleepService.getCurrentSleep(accountSid);
        currentData.put("sleepMin", sleepMin);
        int activityCal = runningRecordService.getNewest(accountSid);
        currentData.put("activityCal",activityCal);
        if (account.getLockintime() != null) {
            currentData.put("lockintime", DateUtil.formatStandardDatetime(account.getLockintime()));
        } else {
            currentData.put("lockintime", DateUtil.formatStandardDatetime(new Date()));
        }

        Distances distances = distancesService.getNewest(accountSid);
        if(steps!=0){
            double distanceNum = steps*80/100000.0;
            double distance = new BigDecimal(distanceNum).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
            double restCal = steps/100*4.5;
            int resting = (int)restCal;
            currentData.put("distance",distance);
            currentData.put("restingCal",resting);
        }
        else if(steps==0){
            currentData.put("distance",0);
            currentData.put("restingCal",0);
        }

        //获取用户基本信息
        String BMR = "";
        if(account.getAge()==null || account.getHeight()==null || account.getWeight()==null){
          BMR ="0";
        }
        else {
            if(account.getGender()==1){
                 BMR = String.valueOf((int)((10*account.getWeight()+6.25*account.getHeight()-5*account.getAge()+5)/5));
            }
            else if(account.getGender()==0){
                BMR = String.valueOf((int)((10*account.getWeight()+6.25*account.getHeight()-5*account.getAge()-161)/5));
             }
        }
        currentData.put("BMR",BMR);
       /* if (distances == null) {
            currentData.put("distances", 0);
            currentData.put("cal", 0);
        } else {
            currentData.put("distances", distances.getDistance());
            currentData.put("cal", distances.getCal());
        }*/
        account.setLockintime(lockintime);
        accountService.updateByPrimaryKeySelective(account);
        return JsonMap.of(true, "", currentData);
    }

}

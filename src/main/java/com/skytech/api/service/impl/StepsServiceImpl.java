package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.mapper.StepsMapper;
import com.skytech.api.model.Steps;
import com.skytech.api.model.StepsExample;
import com.skytech.api.model.base.BaseStepsExample;
import com.skytech.api.service.StepsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("stepsService")
public class StepsServiceImpl extends GenericServiceImpl<Steps, StepsExample, String> implements StepsService {

    @Autowired
    private StepsMapper stepsMapper;

    @Override
    protected StepsMapper getGenericMapper() {
        return this.stepsMapper;
    }

    @Override
    public Pagination<Steps> findForPage(int page, int limit) {
        StepsExample stepsExample = new StepsExample();
        BaseStepsExample.Criteria criteria = stepsExample.createCriteria();

        Pagination<Steps> pagination = this.queryByPage(stepsExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Steps steps) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(steps.getRecordDate());

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date date1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        calendar.add(Calendar.SECOND, -1);
        Date date2 = calendar.getTime();

        StepsExample stepsExample = new StepsExample();
        stepsExample.createCriteria().andAccountSidEqualTo(steps.getAccountSid()).andDeviceSidEqualTo(steps.getDeviceSid()).andRecordDateBetween(date1, date2);

        List<Steps> stepss = stepsMapper.selectByExample(stepsExample);

        if (stepss.isEmpty()) {
            steps.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
            steps.setCreatedDatetime(new Date());
            int i = stepsMapper.insertSelective(steps);
            if (i > 0) {
                return JsonMap.of(true, "保存成功");
            } else {
                return JsonMap.of(false, "保存失败");
            }
        } else {
            Steps one = stepss.get(0);
            one.setCreatedDatetime(new Date());
//            one.setStartDatetime(sleep.getStartDatetime());
//            one.setEndDatetime(sleep.getEndDatetime());
            one.setStepNum(steps.getStepNum());
            one.setRecordDate(steps.getRecordDate());
            int i = stepsMapper.updateByPrimaryKeySelective(one);
            if (i > 0) {
                return JsonMap.of(true, "保存成功");
            } else {
                return JsonMap.of(false, "保存失败");
            }
        }

    }

    @Override
    public JsonMap update(String stepsSid, Steps steps) {
        steps.setSid(stepsSid);
        int i = stepsMapper.updateByPrimaryKeySelective(steps);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... stepsSids) {

        try {
            for (int i = 0; i < stepsSids.length; i++) {
                Steps steps = new Steps();

                steps.setSid(stepsSids[i]);

                stepsMapper.updateByPrimaryKeySelective(steps);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public List<Steps> report(String accountSid, String deviceSid, Date startDate, Date endDate) {
        StepsExample stepsExample = new StepsExample();
        stepsExample.createCriteria().andAccountSidEqualTo(accountSid).andDeviceSidEqualTo(deviceSid).andRecordDateBetween(startDate, endDate);
        stepsExample.setOrderByClause(" record_date asc");
        List<Steps> steps = stepsMapper.selectByExample(stepsExample);
        return steps;
    }
}
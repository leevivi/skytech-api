package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.RunningRecordMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.RunningRecord;
import com.skytech.api.model.RunningRecordExample;
import com.skytech.api.model.base.BaseRunningRecordExample;
import com.skytech.api.service.RunningRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("runningRecordService")
public class RunningRecordServiceImpl extends GenericServiceImpl<RunningRecord, RunningRecordExample, String> implements RunningRecordService {

    @Autowired
    private RunningRecordMapper runningRecordMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected RunningRecordMapper getGenericMapper() {
        return this.runningRecordMapper;
    }

    @Override
    public Pagination<RunningRecord> findForPage(String deviceSid, int page, int limit) {
        RunningRecordExample runningRecordExample = new RunningRecordExample();
        BaseRunningRecordExample.Criteria criteria = runningRecordExample.createCriteria();
        criteria.andDeviceSidEqualTo(deviceSid);
        Pagination<RunningRecord> pagination = this.queryByPage(runningRecordExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(RunningRecord runningRecord) {
        Account account = accountMapper.selectByPrimaryKey(runningRecord.getAccountSid());
        runningRecord.setAccountName(account.getFirstName() + account.getLastName());
//        RunningRecordExample runningRecordExample = new RunningRecordExample();
//
//        List<RunningRecord> runningRecords = runningRecordMapper.selectByExample(runningRecordExample);

        runningRecord.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        runningRecord.setCreatedDatetime(new Date());
        int i = runningRecordMapper.insertSelective(runningRecord);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String runningRecordSid, RunningRecord runningRecord) {
        runningRecord.setSid(runningRecordSid);
        int i = runningRecordMapper.updateByPrimaryKeySelective(runningRecord);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... runningRecordSids) {

        try {
            for (int i = 0; i < runningRecordSids.length; i++) {
                RunningRecord runningRecord = new RunningRecord();

                runningRecord.setSid(runningRecordSids[i]);

                runningRecordMapper.updateByPrimaryKeySelective(runningRecord);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public JsonMap findNewest(String accountSid) {
        Map<String, Object> data = new HashMap<>();
        RunningRecordExample runningRecordExample = new RunningRecordExample();
        runningRecordExample.createCriteria().andAccountSidEqualTo(accountSid);

        BigDecimal distances = new BigDecimal(0);
        int durations = 0;
        List<RunningRecord> runningRecords = runningRecordMapper.selectByExample(runningRecordExample);
        for (RunningRecord record : runningRecords) {
            distances = distances.add(record.getDistance());
            durations += record.getDuration();
        }
        data.put("distances", distances);
        data.put("durations", durations);

        return JsonMap.of(true, "", data);
    }

    @Override
    public Map<String, Object> getCurrentData(String accountSid) {
        Map<String, Object> data = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DATE, 1);
        Date endDate = calendar.getTime();
        RunningRecordExample runningRecordExample = new RunningRecordExample();
        runningRecordExample.createCriteria().andAccountSidEqualTo(accountSid).andStartDatetimeBetween(startDate, endDate);

        BigDecimal distances = new BigDecimal(0);
        Integer cal = 0;
        List<RunningRecord> runningRecords = runningRecordMapper.selectByExample(runningRecordExample);
        for (RunningRecord record : runningRecords) {
            distances = distances.add(record.getDistance());
            cal += record.getCal();
        }
        data.put("distances", distances);
        data.put("cal", cal);
        return data;
    }
}
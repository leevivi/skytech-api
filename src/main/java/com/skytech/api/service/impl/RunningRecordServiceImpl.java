package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.impl.GenericServiceImpl;
import com.skytech.api.mapper.RunningRecordMapper;
import com.skytech.api.model.RunningRecord;
import com.skytech.api.model.RunningRecordExample;
import com.skytech.api.model.base.BaseRunningRecordExample;
import com.skytech.api.service.RunningRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("runningRecordService")
public class RunningRecordServiceImpl extends GenericServiceImpl<RunningRecord, RunningRecordExample, String> implements RunningRecordService {

    @Autowired
    private RunningRecordMapper runningRecordMapper;

    @Override
    protected RunningRecordMapper getGenericMapper() {
        return this.runningRecordMapper;
    }

    @Override
    public Pagination<RunningRecord> findForPage(int page, int limit) {
        RunningRecordExample runningRecordExample = new RunningRecordExample();
        BaseRunningRecordExample.Criteria criteria = runningRecordExample.createCriteria();

        Pagination<RunningRecord> pagination = this.queryByPage(runningRecordExample, (page - 1) * limit, limit, "create_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(RunningRecord runningRecord) {

        RunningRecordExample runningRecordExample = new RunningRecordExample();

        List<RunningRecord> runningRecords = runningRecordMapper.selectByExample(runningRecordExample);

        runningRecord.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
//        runningRecord.setCreateDatetime(new Date());
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
}
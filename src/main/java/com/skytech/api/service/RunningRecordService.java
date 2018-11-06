package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.RunningRecord;
import com.skytech.api.model.RunningRecordExample;
import com.owthree.core.service.GenericService;

public interface RunningRecordService extends GenericService<RunningRecord, String> {

    Pagination<RunningRecord> findForPage(int page, int limit);

    JsonMap save(RunningRecord runningRecord);

    JsonMap update(String runningRecordSid, RunningRecord runningRecord);

    JsonMap delete(String... runningRecordSids);
}



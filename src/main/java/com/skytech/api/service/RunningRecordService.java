package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.GenericService;
import com.skytech.api.model.RunningRecord;

public interface RunningRecordService extends GenericService<RunningRecord, String> {

    Pagination<RunningRecord> findForPage(String deviceSid, int page, int limit);

    JsonMap save(RunningRecord runningRecord);

    JsonMap update(String runningRecordSid, RunningRecord runningRecord);

    JsonMap delete(String... runningRecordSids);
}



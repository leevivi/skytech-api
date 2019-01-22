package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.RunningRecord;

public interface RunningRecordService extends GenericService<RunningRecord, String> {

    Pagination<RunningRecord> findForPage(String deviceSid, int page, int limit);

    JsonMap save(RunningRecord runningRecord);

    JsonMap update(String runningRecordSid, RunningRecord runningRecord);

    JsonMap delete(String... runningRecordSids);
}



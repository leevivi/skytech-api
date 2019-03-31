package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.TCourse;

/**
 * Created by LiWei on 2019/3/31.
 */
public interface CourseService extends GenericOneService<TCourse,Integer> {
    Pagination<TCourse> findForPage(int page, int limit);

    JsonMap save(TCourse tCourse);

    JsonMap update(String eventSid, TCourse tCourse);

    JsonMap delete(String... eventSids);
}

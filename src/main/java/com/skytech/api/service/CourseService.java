package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericOneService;
import com.skytech.api.model.TCourse;
import com.skytech.api.model.TOrder;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/3/31.
 */
public interface CourseService extends GenericOneService<TCourse,Integer> {
    Pagination<TCourse> findForPage(int companyId,int storesId,int page, int limit);

    List<Map<String, Object>> findForCourse(int courseId);

    JsonMap findForCourseDetail(int id);

    JsonMap save(TCourse tCourse);

    JsonMap join(int membersId,int companyId,int storesId,int courseId,int[] couponIds,int[] tCourseTimeIds);

    JsonMap update(String eventSid, TCourse tCourse);

    JsonMap delete(String... eventSids);

    JsonMap defaultCoupon(int membersId, int courseId, int courseNum) throws ParseException;

    JsonMap selectCoupon(int membersId, int courseId);

    Map<String,Object> selectCourse(int membersId,int companyId,int storesId, int courseId, int[] weekIds);

    JsonMap selectWeek(int courseId);
}

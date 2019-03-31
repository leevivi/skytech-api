package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.TCourseMapper;
import com.skytech.api.mapper.TMemberMapper;
import com.skytech.api.model.TCourse;
import com.skytech.api.model.TCourseExample;
import com.skytech.api.model.TMember;
import com.skytech.api.model.TMemberExample;
import com.skytech.api.model.base.BaseTCourse;
import com.skytech.api.model.base.BaseTCourseExample;
import com.skytech.api.service.CourseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiWei on 2019/3/31.
 */
@Service("courseService")
public class CourseServiceImpl extends GenericOneServiceImpl<TCourse,TCourseExample,Integer> implements CourseService {

    @Autowired
    private TCourseMapper tCourseMapper;
    @Autowired
    private TMemberMapper tMemberMapper;
    @Override
    protected GenericOneMapper<TCourse, TCourseExample, Integer> getGenericOneMapper() {
        return this.tCourseMapper;
    }
    @Override
    public Pagination<TCourse> findForPage(int page, int limit) {
//        TCourse tCourse = tCourseMapper.selectByPrimaryKey(accountSid);

        TCourseExample tCourseExample = new TCourseExample();
        BaseTCourseExample.Criteria criteria = tCourseExample.createCriteria();
        List<TCourse> tCourses = tCourseMapper.selectByExample(tCourseExample);

        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andUseridEqualTo(tCourses.get(0).getUserid());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);

        /*if (!StringUtils.endsWith(tCourse.getEmail(), "skytech.com.hk")) {
            criteria.andSidNotEqualTo("1");
        }*/

        Pagination<TCourse> pagination = this.queryByPage(tCourseExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(TCourse tCourse) {
        return null;
    }

    @Override
    public JsonMap update(String eventSid, TCourse tCourse) {
        return null;
    }

    @Override
    public JsonMap delete(String... eventSids) {
        return null;
    }


}

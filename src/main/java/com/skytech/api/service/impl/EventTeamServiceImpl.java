package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.mapper.EventTeamMapper;
import com.skytech.api.model.EventTeam;
import com.skytech.api.model.EventTeamExample;
import com.skytech.api.model.base.BaseEventTeamExample;
import com.skytech.api.service.EventTeamService;
import com.skytech.api.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("eventTeamService")
public class EventTeamServiceImpl extends GenericServiceImpl<EventTeam, EventTeamExample, String> implements EventTeamService {

    @Autowired
    private EventTeamMapper eventTeamMapper;

    @Override
    protected EventTeamMapper getGenericMapper() {
        return this.eventTeamMapper;
    }

    @Override
    public Pagination<EventTeam> findForPage(int page, int limit) {
        EventTeamExample eventTeamExample = new EventTeamExample();
        BaseEventTeamExample.Criteria criteria = eventTeamExample.createCriteria();

        Pagination<EventTeam> pagination = this.queryByPage(eventTeamExample, (page - 1) * limit, limit, "create_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(EventTeam eventTeam) {

        EventTeamExample eventTeamExample = new EventTeamExample();

        List<EventTeam> eventTeams = eventTeamMapper.selectByExample(eventTeamExample);

        eventTeam.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
//        eventTeam.setCreateDatetime(new Date());
        int i = eventTeamMapper.insertSelective(eventTeam);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String eventTeamSid, EventTeam eventTeam) {
        eventTeam.setSid(eventTeamSid);
        int i = eventTeamMapper.updateByPrimaryKeySelective(eventTeam);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... eventTeamSids) {

        try {
            for (int i = 0; i < eventTeamSids.length; i++) {
                EventTeam eventTeam = new EventTeam();

                eventTeam.setSid(eventTeamSids[i]);

                eventTeamMapper.updateByPrimaryKeySelective(eventTeam);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}
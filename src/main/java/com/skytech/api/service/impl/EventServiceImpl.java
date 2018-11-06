package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.mapper.EventMapper;
import com.skytech.api.model.Event;
import com.skytech.api.model.EventExample;
import com.skytech.api.model.base.BaseEventExample;
import com.skytech.api.service.EventService;
import com.owthree.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("eventService")
public class EventServiceImpl extends GenericServiceImpl<Event, EventExample, String> implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    protected EventMapper getGenericMapper() {
        return this.eventMapper;
    }

    @Override
    public Pagination<Event> findForPage(int page, int limit) {
        EventExample eventExample = new EventExample();
        BaseEventExample.Criteria criteria = eventExample.createCriteria();

        Pagination<Event> pagination = this.queryByPage(eventExample, (page - 1) * limit, limit, "create_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Event event) {

        EventExample eventExample = new EventExample();

        List<Event> events = eventMapper.selectByExample(eventExample);

        event.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        event.setCreateDatetime(new Date());
        int i = eventMapper.insertSelective(event);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String eventSid, Event event) {
        event.setSid(eventSid);
        int i = eventMapper.updateByPrimaryKeySelective(event);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... eventSids) {

        try {
            for (int i = 0; i < eventSids.length; i++) {
                Event event = new Event();

                event.setSid(eventSids[i]);

                eventMapper.updateByPrimaryKeySelective(event);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}
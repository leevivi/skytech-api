package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.service.GenericService;
import com.skytech.api.model.EventMembers;

import java.util.List;
import java.util.Map;

public interface EventMembersService extends GenericService<EventMembers, String> {

    Pagination<EventMembers> findForPage(int page, int limit);

    List<Map<String, Object>> findForEvent(String eventSid);

    JsonMap save(EventMembers eventMembers);

    JsonMap save(String accountSid, String eventSid, String accountName, String staffId);

    JsonMap update(String eventMembersSid, EventMembers eventMembers);

    JsonMap delete(String... eventMembersSids);
}



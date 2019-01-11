package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.GenericService;
import com.skytech.api.model.Account;
import com.skytech.api.model.EventMembers;

import java.util.List;

public interface EventMembersService extends GenericService<EventMembers, String> {

    Pagination<EventMembers> findForPage(int page, int limit);

    List<Account> findForEvent(String eventSid);

    JsonMap save(EventMembers eventMembers);

    JsonMap save(String accountSid, String eventSid, String accountName, String staffId);

    JsonMap update(String eventMembersSid, EventMembers eventMembers);

    JsonMap delete(String... eventMembersSids);
}



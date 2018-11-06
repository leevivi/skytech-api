package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.EventTeam;
import com.skytech.api.model.EventTeamExample;
import com.owthree.core.service.GenericService;

public interface EventTeamService extends GenericService<EventTeam, String> {

    Pagination<EventTeam> findForPage(int page, int limit);

    JsonMap save(EventTeam eventTeam);

    JsonMap update(String eventTeamSid, EventTeam eventTeam);

    JsonMap delete(String... eventTeamSids);
}



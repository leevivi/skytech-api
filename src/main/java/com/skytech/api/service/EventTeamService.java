package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.model.EventTeam;
import com.skytech.api.model.EventTeamExample;
import com.skytech.api.core.service.GenericService;

public interface EventTeamService extends GenericService<EventTeam, String> {

    Pagination<EventTeam> findForPage(int page, int limit);

    JsonMap save(EventTeam eventTeam);

    JsonMap update(String eventTeamSid, EventTeam eventTeam);

    JsonMap delete(String... eventTeamSids);
}



package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.Team;
import com.skytech.api.model.TeamExample;
import com.owthree.core.service.GenericService;

public interface TeamService extends GenericService<Team, String> {

    Pagination<Team> findForPage(int page, int limit);

    JsonMap save(Team team);

    JsonMap update(String teamSid, Team team);

    JsonMap delete(String... teamSids);
}



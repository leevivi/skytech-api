package com.skytech.api.service;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.model.TeamMembers;
import com.skytech.api.model.TeamMembersExample;
import com.skytech.api.core.service.GenericService;

public interface TeamMembersService extends GenericService<TeamMembers, String> {

    Pagination<TeamMembers> findForPage(int page, int limit);

    JsonMap save(TeamMembers teamMembers);

    JsonMap update(String teamMembersSid, TeamMembers teamMembers);

    JsonMap delete(String... teamMembersSids);
}



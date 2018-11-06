package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.mapper.TeamMembersMapper;
import com.skytech.api.model.TeamMembers;
import com.skytech.api.model.TeamMembersExample;
import com.skytech.api.model.base.BaseTeamMembersExample;
import com.skytech.api.service.TeamMembersService;
import com.owthree.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("teamMembersService")
public class TeamMembersServiceImpl extends GenericServiceImpl<TeamMembers, TeamMembersExample, String> implements TeamMembersService {

    @Autowired
    private TeamMembersMapper teamMembersMapper;

    @Override
    protected TeamMembersMapper getGenericMapper() {
        return this.teamMembersMapper;
    }

    @Override
    public Pagination<TeamMembers> findForPage(int page, int limit) {
        TeamMembersExample teamMembersExample = new TeamMembersExample();
        BaseTeamMembersExample.Criteria criteria = teamMembersExample.createCriteria();

        Pagination<TeamMembers> pagination = this.queryByPage(teamMembersExample, (page - 1) * limit, limit, "create_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(TeamMembers teamMembers) {

        TeamMembersExample teamMembersExample = new TeamMembersExample();

        List<TeamMembers> teamMemberss = teamMembersMapper.selectByExample(teamMembersExample);

        teamMembers.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        teamMembers.setCreateDatetime(new Date());
        int i = teamMembersMapper.insertSelective(teamMembers);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String teamMembersSid, TeamMembers teamMembers) {
        teamMembers.setSid(teamMembersSid);
        int i = teamMembersMapper.updateByPrimaryKeySelective(teamMembers);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... teamMembersSids) {

        try {
            for (int i = 0; i < teamMembersSids.length; i++) {
                TeamMembers teamMembers = new TeamMembers();

                teamMembers.setSid(teamMembersSids[i]);

                teamMembersMapper.updateByPrimaryKeySelective(teamMembers);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}
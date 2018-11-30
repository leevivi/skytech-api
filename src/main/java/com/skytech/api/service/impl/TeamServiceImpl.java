package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.mapper.TeamMapper;
import com.skytech.api.model.Team;
import com.skytech.api.model.TeamExample;
import com.skytech.api.model.base.BaseTeamExample;
import com.skytech.api.service.TeamService;
import com.owthree.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("teamService")
public class TeamServiceImpl extends GenericServiceImpl<Team, TeamExample, String> implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    protected TeamMapper getGenericMapper() {
        return this.teamMapper;
    }

    @Override
    public Pagination<Team> findForPage(int page, int limit) {
        TeamExample teamExample = new TeamExample();
        BaseTeamExample.Criteria criteria = teamExample.createCriteria();

        Pagination<Team> pagination = this.queryByPage(teamExample, (page - 1) * limit, limit, "create_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Team team) {

        TeamExample teamExample = new TeamExample();

        List<Team> teams = teamMapper.selectByExample(teamExample);

        team.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
//        team.setCreateDatetime(new Date());
        int i = teamMapper.insertSelective(team);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String teamSid, Team team) {
        team.setSid(teamSid);
        int i = teamMapper.updateByPrimaryKeySelective(team);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... teamSids) {

        try {
            for (int i = 0; i < teamSids.length; i++) {
                Team team = new Team();

                team.setSid(teamSids[i]);

                teamMapper.updateByPrimaryKeySelective(team);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}
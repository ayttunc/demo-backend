package com.flexible.iot.hq.service;

import com.flexible.iot.hq.io.entity.TeamEntity;
import com.flexible.iot.hq.shared.dto.TeamDto;

import java.util.List;

public interface TeamService {

    TeamDto createTeam(TeamDto teamDto);

    Iterable<TeamEntity> findAllTeams();

    TeamDto updateTeam(TeamDto teamDto);

    TeamDto deleteTeam(Long id);
}

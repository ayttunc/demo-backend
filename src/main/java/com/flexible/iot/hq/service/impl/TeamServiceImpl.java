package com.flexible.iot.hq.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flexible.iot.hq.exception.NotInRangeError;
import com.flexible.iot.hq.exception.RecordNotFoundError;
import com.flexible.iot.hq.io.entity.TeamEntity;
import com.flexible.iot.hq.io.repository.TeamRepository;
import com.flexible.iot.hq.service.TeamService;
import com.flexible.iot.hq.shared.dto.TeamDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        ModelMapper mapper = new ModelMapper();
        TeamEntity teamEntity = mapper.map(teamDto, TeamEntity.class);
        if(teamDto.getCommissionPercentage() > 10 && teamDto.getCommissionPercentage() >= 0){
            throw new NotInRangeError("Team commission shuld be higher than 0 and lower than 10 percent");
        }
        teamRepository.save(teamEntity);
        teamDto.setId(teamEntity.getId());
        log.info("team created with id : ".concat(String.valueOf(teamDto.getId())));
        return teamDto;
    }

    @Override
    public Iterable<TeamEntity> findAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        Optional<TeamEntity> team = teamRepository.findById(teamDto.getId());

        if (team.isPresent()) {
            team.get().setName(teamDto.getDescription());
            team.get().setDescription(teamDto.getDescription());
            team.get().setCountry(teamDto.getDescription());
            team.get().setCity(teamDto.getDescription());
            teamRepository.save(team.get());
            log.info("team updated with id : ".concat(String.valueOf(teamDto.getId())));
        }
        return teamDto;
    }

    @Override
    public TeamDto deleteTeam(Long id) {
        Optional<TeamEntity> team = teamRepository.findById(id);
        if (team.isPresent()) {
            teamRepository.delete(team.get());
            log.info("team of ".concat(String.valueOf(id)).concat(" deleted."));
        }else{
            throw new RecordNotFoundError("Record not found on database...");
        }
        ModelMapper mapper = new ModelMapper();
        TeamDto teamDTO = mapper.map(team.get(), TeamDto.class);
        return teamDTO;
    }
}

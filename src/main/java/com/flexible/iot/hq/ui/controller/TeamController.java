package com.flexible.iot.hq.ui.controller;

import com.flexible.iot.hq.service.TeamService;
import com.flexible.iot.hq.shared.dto.TeamDto;
import com.flexible.iot.hq.ui.model.request.NewsDetailRequestModel;
import com.flexible.iot.hq.ui.model.request.TeamDetailRequestModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity listAllTeams() {
        return ResponseEntity.ok(teamService.findAllTeams());
    }

    @PostMapping
    public ResponseEntity createTeam(@RequestBody TeamDetailRequestModel teamDetailModel) {

        ModelMapper modelMapper = new ModelMapper();
        TeamDto teamDto = modelMapper.map(teamDetailModel, TeamDto.class);
        return ResponseEntity.status(201).body(teamService.createTeam(teamDto));
    }

    @PutMapping
    public ResponseEntity updateTeam(@RequestBody TeamDetailRequestModel teamDetailModel) {

        ModelMapper modelMapper = new ModelMapper();
        TeamDto teamDto = modelMapper.map(teamDetailModel, TeamDto.class);
        return ResponseEntity.ok(teamService.updateTeam(teamDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTeam(@PathVariable long id) {

        return ResponseEntity.ok(teamService.deleteTeam(id));
    }
}

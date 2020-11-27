package com.flexible.iot.hq.service.impl;

import com.flexible.iot.hq.exception.RecordNotFoundError;
import com.flexible.iot.hq.io.entity.PlayerEntity;
import com.flexible.iot.hq.io.entity.TeamEntity;
import com.flexible.iot.hq.io.repository.PlayerRepository;
import com.flexible.iot.hq.io.repository.TeamRepository;
import com.flexible.iot.hq.service.PlayerService;
import com.flexible.iot.hq.shared.dto.PlayerDto;
import com.flexible.iot.hq.ui.model.response.PlayerDetailResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        Optional<TeamEntity> team = teamRepository.findById(playerDto.getTid());
        ModelMapper mapper = new ModelMapper();
        PlayerEntity playerEntity = mapper.map(playerDto, PlayerEntity.class);
        if (team.isPresent()) {
            playerEntity.setTeamEntity(team.get());
        } else {
            // throw new RecordNotFoundError("Team not found");
        }
        playerRepository.save(playerEntity);
        log.info("Player created with id : ".concat(String.valueOf(playerEntity.getId())));
        playerDto.setId(playerEntity.getId());
        return playerDto;
    }

    @Override
    public List<PlayerEntity> findAllPlayers() {

        List<PlayerEntity> players = StreamSupport.stream(playerRepository.findAll().spliterator(), false).collect(Collectors.toList());

        return players;
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {

        Optional<PlayerEntity> player = playerRepository.findById(playerDto.getId());
        if (player.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            PlayerEntity playerEntity = mapper.map(playerDto, PlayerEntity.class);
            Optional<TeamEntity> team = teamRepository.findById(playerDto.getTid());
            if(team.isPresent()){
                playerEntity.setTeamEntity(team.get());
            }
            playerRepository.save(playerEntity);
            log.info(String.valueOf(playerEntity.getId()).concat(" player updated.."));
            playerDto.setId(player.get().getId());
        } else {
            throw new RecordNotFoundError("Player not found...");
        }
        return playerDto;
    }

    @Override
    public PlayerDto deletePlayer(Long id) {
        PlayerDto dto = new PlayerDto();
        playerRepository.deleteById(id);
        return dto;
    }

    @Override
    public PlayerDetailResponseModel findPlayerById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<PlayerEntity> playerEntity = playerRepository.findById(id);
        PlayerDetailResponseModel playerResponse;
        if (playerEntity.isPresent()) {

            playerResponse = mapper.map(playerEntity.get(), PlayerDetailResponseModel.class);
        }else {
            throw new RecordNotFoundError("Player not found...");
        }
        return playerResponse;
    }
}

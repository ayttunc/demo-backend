package com.flexible.iot.hq.service;

import com.flexible.iot.hq.io.entity.PlayerEntity;
import com.flexible.iot.hq.shared.dto.PlayerDto;
import com.flexible.iot.hq.ui.model.response.PlayerDetailResponseModel;

import java.util.List;

public interface PlayerService {

    PlayerDto createPlayer(PlayerDto playerDto);

    List<PlayerEntity> findAllPlayers();

    PlayerDto updatePlayer(PlayerDto playerDto);

    PlayerDto deletePlayer(Long id);

    PlayerDetailResponseModel findPlayerById(Long id);
}

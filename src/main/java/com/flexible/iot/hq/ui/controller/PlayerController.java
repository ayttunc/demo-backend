package com.flexible.iot.hq.ui.controller;


import com.flexible.iot.hq.service.PlayerService;
import com.flexible.iot.hq.shared.dto.PlayerDto;
import com.flexible.iot.hq.ui.model.request.PlayerDetailRequestModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity listAllPlayers() {
        return ResponseEntity.ok(playerService.findAllPlayers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findPlayerById(@PathVariable long id) {
        return ResponseEntity.ok(playerService.findPlayerById(id));
    }

    @PostMapping
    public ResponseEntity createPlayer(@RequestBody PlayerDetailRequestModel playerDetailModel) {

        ModelMapper mapper = new ModelMapper();
        PlayerDto playerDto = mapper.map(playerDetailModel, PlayerDto.class);
        return ResponseEntity.ok(playerService.createPlayer(playerDto));
    }

    @PutMapping
    public ResponseEntity updatePlayer(@RequestBody PlayerDetailRequestModel playerDetailRequestModel) {

        ModelMapper mapper = new ModelMapper();
        PlayerDto playerDto = mapper.map(playerDetailRequestModel, PlayerDto.class);
        return ResponseEntity.ok(playerService.updatePlayer(playerDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePlayer(@PathVariable long id) {

        return ResponseEntity.ok(playerService.deletePlayer(id));
    }
}

package com.flexible.iot.hq.ui.controller;

import com.flexible.iot.hq.service.TransferService;
import com.flexible.iot.hq.shared.dto.TransferDto;
import com.flexible.iot.hq.ui.model.request.TransferPlayerRequestModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public ResponseEntity listAllTransfers() {
        return ResponseEntity.ok(transferService.findAllTransfers());
    }

    @PostMapping
    public ResponseEntity transferPlayer(@RequestBody TransferPlayerRequestModel transferModel) {

        ModelMapper mapper = new ModelMapper();
        TransferDto transferDto = mapper.map(transferModel, TransferDto.class);
        return ResponseEntity.ok(transferService.transferPlayer(transferDto));
    }

    @PutMapping
    public ResponseEntity updateTransfer(@RequestBody TransferPlayerRequestModel transferModel) {

        // TODO : Update was not included in scenarios, So do not even bother to implement
        return ResponseEntity.ok("No such API");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePlayer(@PathVariable long id) {

        return ResponseEntity.ok("No such API");
    }
}

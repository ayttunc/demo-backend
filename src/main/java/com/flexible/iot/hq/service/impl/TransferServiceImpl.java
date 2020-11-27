package com.flexible.iot.hq.service.impl;

import com.flexible.iot.hq.exception.RecordNotFoundError;
import com.flexible.iot.hq.io.entity.PlayerEntity;
import com.flexible.iot.hq.io.entity.TeamEntity;
import com.flexible.iot.hq.io.entity.TransferEntity;
import com.flexible.iot.hq.io.repository.PlayerRepository;
import com.flexible.iot.hq.io.repository.TeamRepository;
import com.flexible.iot.hq.io.repository.TransferRepository;
import com.flexible.iot.hq.service.TransferService;
import com.flexible.iot.hq.shared.dto.TransferDto;
import com.flexible.iot.hq.ui.model.response.OperationStatusResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public TransferServiceImpl(TransferRepository transferRepository, PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.transferRepository = transferRepository;
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<TransferEntity> findAllTransfers() {
        List<TransferEntity> transfers = StreamSupport.stream(transferRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return transfers;
    }

    @Override
    public OperationStatusResponseModel transferPlayer(TransferDto transferDto) {

        double transferFee;
        double teamCommission;
        double contractFee;

        OperationStatusResponseModel operationStatus = new OperationStatusResponseModel();
        Optional<PlayerEntity> player = playerRepository.findById(transferDto.getPid());
        if (player.isPresent()) {
            Optional<TeamEntity> oldTeam = teamRepository.findById(player.get().getTeamEntity().getId());
            if (oldTeam.isPresent()) {
                transferFee = (player.get().getMonthOfExperience() * 100) / player.get().getAge();
                teamCommission = (transferFee * oldTeam.get().getCommissionPercentage()) / 100;
                contractFee = transferFee + teamCommission;
                Optional<TeamEntity> newTeam = teamRepository.findById(transferDto.getTid());
                if (!newTeam.isPresent()) {
                    throw new RecordNotFoundError("There is no such team for that player to be transferred.");
                }
                TransferEntity newTransfer = new TransferEntity();
                newTransfer.setContractFee(contractFee);
                newTransfer.setOldTeamId(oldTeam.get().getId());
                newTransfer.setTeamCommission(teamCommission);
                newTransfer.setPid(player.get().getId());
                newTransfer.setCurrency(oldTeam.get().getCurrency());
                newTransfer.setTid(transferDto.getTid());
                newTransfer.setTransferFee(transferFee);
                transferRepository.save(newTransfer);

                operationStatus.setOperation("Transfer");
                operationStatus.setStatus("success");
                return operationStatus;
            }
        }
        operationStatus.setStatus("failure");
        operationStatus.setOperation("Transfer");
        return operationStatus;
    }
}

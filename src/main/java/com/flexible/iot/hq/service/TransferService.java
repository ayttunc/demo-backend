package com.flexible.iot.hq.service;

import com.flexible.iot.hq.io.entity.TransferEntity;
import com.flexible.iot.hq.shared.dto.TransferDto;
import com.flexible.iot.hq.ui.model.response.OperationStatusResponseModel;

import java.util.List;

public interface TransferService {

    List<TransferEntity> findAllTransfers();

    OperationStatusResponseModel transferPlayer(TransferDto transferDto);
}

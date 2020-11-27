package com.flexible.iot.hq.io.repository;

import com.flexible.iot.hq.io.entity.TransferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<TransferEntity, Long> {

}

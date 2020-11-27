package com.flexible.iot.hq.io.repository;

import com.flexible.iot.hq.io.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long> {

}

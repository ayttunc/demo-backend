package com.flexible.iot.hq.io.repository;

import com.flexible.iot.hq.io.entity.AnnouncementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementReporsitory extends CrudRepository<AnnouncementEntity, Long> {

}

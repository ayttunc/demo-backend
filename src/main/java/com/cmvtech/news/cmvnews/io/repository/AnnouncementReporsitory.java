package com.cmvtech.news.cmvnews.io.repository;

import com.cmvtech.news.cmvnews.io.entity.AnnouncementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementReporsitory extends CrudRepository<AnnouncementEntity, Long> {

}

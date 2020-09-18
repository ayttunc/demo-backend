package com.flexible.iot.hq.io.repository;

import com.flexible.iot.hq.io.entity.NewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<NewsEntity, Long> {

}

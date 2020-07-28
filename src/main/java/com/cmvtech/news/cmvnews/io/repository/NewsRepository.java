package com.cmvtech.news.cmvnews.io.repository;

import com.cmvtech.news.cmvnews.io.entity.NewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<NewsEntity, Long> {

}

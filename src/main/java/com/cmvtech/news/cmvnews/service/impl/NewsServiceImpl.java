package com.cmvtech.news.cmvnews.service.impl;

import com.cmvtech.news.cmvnews.io.entity.NewsEntity;
import com.cmvtech.news.cmvnews.io.repository.NewsRepository;
import com.cmvtech.news.cmvnews.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl( NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsEntity createNews(NewsEntity newsEntity) {
        newsRepository.save(newsEntity);
        return newsEntity;
    }

    @Override
    public Iterable<NewsEntity> findAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public NewsEntity deleteNews(NewsEntity newsEntity) {
        newsRepository.deleteById(newsEntity.getId());
        return newsEntity;
    }

    @Override
    public NewsEntity updateNews(NewsEntity newsEntity) {
        newsRepository.findById(newsEntity.getId());
        return newsEntity;
    }
}

package com.flexible.iot.hq.service.impl;

import com.flexible.iot.hq.io.entity.NewsEntity;
import com.flexible.iot.hq.io.repository.NewsRepository;
import com.flexible.iot.hq.service.NewsService;
import com.flexible.iot.hq.shared.dto.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl( NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsDto createNews(NewsDto newsDto) {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setContent(newsDto.getContent());
        newsEntity.setDescription(newsDto.getDescription());
        newsEntity.setImgPath(newsDto.getImgPath());
        newsEntity.setTitle(newsDto.getTitle());

        newsRepository.save(newsEntity);
        return newsDto;
    }

    @Override
    public Iterable<NewsEntity> findAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public void deleteNews(long newsId) {
        newsRepository.deleteById(newsId);
    }

    @Override
    public NewsDto updateNews(long newsId, NewsDto newsDto) {
        Optional<NewsEntity> newsEntity = newsRepository.findById(newsId);
        if(newsEntity.isPresent()){
            newsEntity.get().setTitle(newsDto.getTitle());
            newsEntity.get().setDescription(newsDto.getDescription());
            newsEntity.get().setContent(newsDto.getContent());
            newsEntity.get().setImgPath(newsDto.getImgPath());
            newsRepository.save(newsEntity.get());
        }

        List<List<String>> a = new ArrayList<>();

        return newsDto;
    }
}

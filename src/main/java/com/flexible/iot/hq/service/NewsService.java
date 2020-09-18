package com.flexible.iot.hq.service;

import com.flexible.iot.hq.io.entity.NewsEntity;
import com.flexible.iot.hq.shared.dto.NewsDto;

public interface NewsService {

    NewsDto createNews(NewsDto newsDto);

    Iterable<NewsEntity> findAllNews();

    void deleteNews(long newsId);

    NewsDto updateNews(long newsId, NewsDto newsDto);
}

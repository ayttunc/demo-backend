package com.cmvtech.news.cmvnews.service;

import com.cmvtech.news.cmvnews.io.entity.NewsEntity;
import com.cmvtech.news.cmvnews.shared.dto.NewsDto;

public interface NewsService {

    NewsDto createNews(NewsDto newsDto);

    Iterable<NewsEntity> findAllNews();

    void deleteNews(long newsId);

    NewsDto updateNews(long newsId, NewsDto newsDto);
}

package com.cmvtech.news.cmvnews.service;

import com.cmvtech.news.cmvnews.io.entity.NewsEntity;

import java.util.List;

public interface NewsService {

    NewsEntity createNews(NewsEntity newsEntity);

    Iterable<NewsEntity> findAllNews();

    NewsEntity deleteNews(NewsEntity newsEntity);

    NewsEntity updateNews(NewsEntity newsEntity);
}

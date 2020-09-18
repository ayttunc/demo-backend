package com.flexible.iot.hq.ui.controller;

import com.flexible.iot.hq.service.NewsService;
import com.flexible.iot.hq.shared.dto.NewsDto;
import com.flexible.iot.hq.ui.model.request.NewsDetailRequestModel;
import com.flexible.iot.hq.ui.model.response.NewsDetailResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "/news")
    public ResponseEntity listAllNews() {
        return ResponseEntity.ok(newsService.findAllNews());
    }

    @PostMapping(value = "/news")
    public ResponseEntity createNews(@RequestBody NewsDetailRequestModel newsDetails){
        ModelMapper modelMapper = new ModelMapper();
        NewsDto newsDto = modelMapper.map(newsDetails, NewsDto.class);

        NewsDto createdNews = newsService.createNews(newsDto);

        NewsDetailResponseModel newsResponse = modelMapper.map(createdNews, NewsDetailResponseModel.class);
        return ResponseEntity.ok(newsResponse);
    }

    @PutMapping(value = "/news/{id}")
    public ResponseEntity updateOneOfNews(@PathVariable int id, @RequestBody NewsDetailRequestModel newsDetail) {

        ModelMapper mapper = new ModelMapper();
        NewsDto newsDto = mapper.map(newsDetail, NewsDto.class);
        NewsDto returnNewsDto = newsService.updateNews(id, newsDto);
        return ResponseEntity.ok(mapper.map(returnNewsDto, NewsDetailResponseModel.class));
    }

    @DeleteMapping(value = "/news/{id}")
    public ResponseEntity deleteOneOfNews(@PathVariable int id) {
        newsService.deleteNews(id);
        return ResponseEntity.status(200).body("");
    }
}

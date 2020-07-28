package com.cmvtech.news.cmvnews.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewsController {

    @GetMapping(value = "/news")
    public ResponseEntity listAllNews() {
        return ResponseEntity.ok("List All news.");
    }

    @PutMapping(value = "/news/{id}")
    public ResponseEntity updateOneOfNews(@PathVariable int id) {
        return ResponseEntity.ok("News Updated: ".concat(String.valueOf(id)));
    }

    @DeleteMapping(value = "/news/{id}")
    public ResponseEntity deleteOneOfNews(@PathVariable int id) {
        return ResponseEntity.status(200).body("News deleted");
    }
}

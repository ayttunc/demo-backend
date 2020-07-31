package com.cmvtech.news.cmvnews.io.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "News")
public class NewsEntity extends BaseEventEntity {


    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    private String content;

    @Column
    private String imgPath;
}

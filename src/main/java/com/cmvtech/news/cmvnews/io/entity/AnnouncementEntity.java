package com.cmvtech.news.cmvnews.io.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "ANNOUNCEMENT")
@Entity
public class AnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}

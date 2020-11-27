package com.flexible.iot.hq.io.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "ANNOUNCEMENT")
@Entity
public class AnnouncementEntity extends BaseEventEntity {


    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String validUntil;



}

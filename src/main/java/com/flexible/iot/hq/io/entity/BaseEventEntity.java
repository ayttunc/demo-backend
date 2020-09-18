package com.flexible.iot.hq.io.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}

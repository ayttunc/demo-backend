package com.flexible.iot.hq.shared.dto;

import lombok.Data;

@Data
public class PlayerDto {

    private long id;
    private String name;
    private int pNumber;
    private int stamina;
    private int intelligence;
    private long tid;
    private int endurance;
    private int dexterity;
    private int age;
    private int monthOfExperience;
}

package com.flexible.iot.hq.shared.dto;

import lombok.Data;

@Data
public class TeamDto {

    private long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private String currency;
    private double commissionPercentage;
}

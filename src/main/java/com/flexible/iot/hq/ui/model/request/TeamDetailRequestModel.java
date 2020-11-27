package com.flexible.iot.hq.ui.model.request;

import lombok.Data;

@Data
public class TeamDetailRequestModel {

    private Long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private String currency;
    private double commissionPercentage;
}

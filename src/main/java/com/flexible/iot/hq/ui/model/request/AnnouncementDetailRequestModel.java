package com.flexible.iot.hq.ui.model.request;

import lombok.Data;

@Data
public class AnnouncementDetailRequestModel {

    private String title;
    private String description;
    private String validUntil;
}

package com.flexible.iot.hq.ui.model.request;

import lombok.Data;

@Data
public class NewsDetailRequestModel {

    private String title;
    private String description;
    private String content;
    private String imgPath;
}

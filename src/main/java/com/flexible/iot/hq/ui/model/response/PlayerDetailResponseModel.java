package com.flexible.iot.hq.ui.model.response;

import com.flexible.iot.hq.io.entity.TeamEntity;
import lombok.Data;

@Data
public class PlayerDetailResponseModel {

    private long id;
    private String name;
    private int pNumber;
    private int stamina;
    private int intelligence;
    private long tid;
    private int endurance;
    private int dexterity;
    private int age;
    private TeamEntity teamEntity;
}

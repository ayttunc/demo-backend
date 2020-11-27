package com.flexible.iot.hq.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexible.iot.hq.shared.dto.PlayerDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "Team")
@SequenceGenerator(name = "TEAM_SEQ",
        sequenceName = "TEAM_SEQ", allocationSize = 1)
public class TeamEntity implements Serializable {

    private static final long serialVersionUID = 12412311231L;

    @Id
    @Column(name = "TID")
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String Country;

    @Column
    private String city;

    @Column(nullable = false)
    private String currency;

    @Column
    private double commissionPercentage;

    @OneToMany(mappedBy = "teamEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PlayerEntity> playerDetail;
}

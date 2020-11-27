package com.flexible.iot.hq.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "Player")
@SequenceGenerator(name = "PLAYER_SEQ",
        sequenceName = "PLAYER_SEQ", allocationSize = 1)
public class PlayerEntity implements Serializable {

    private static final long serialVersionUID = 12412384531L;

    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private int pNumber; // player number

    @Column(nullable = false)
    private int monthOfExperience;

    @Column
    private int stamina;

    @Column
    private int intelligence;

    @Column
    private int dexterity;

    @Column
    private int endurance;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "TID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TeamEntity teamEntity;
}

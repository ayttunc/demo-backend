package com.flexible.iot.hq.io.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity(name = "TRANSFER")
public class TransferEntity implements Serializable {

    private static final long serialVersionUID = 89412311231L;

    @Id
    @Column
    @GeneratedValue
    private long id;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column
    private long pid; // player id

    @Column
    private String currency;

    @Column
    private long tid; // new team id

    @Column
    private long oldTeamId;

    @Column
    private double transferFee;

    @Column
    private double teamCommission;

    @Column
    private double contractFee;


}

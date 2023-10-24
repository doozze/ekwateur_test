package com.ekwateur.test.domains.billing.entity;

import com.ekwateur.test.domains.billing.enums.EnergyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Month;

@Getter
@Setter
@Entity
@Table(name = "ekw_consumption")
public class ConsumptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    @Enumerated(EnumType.STRING)
    private Month monthOfYear;
    private int yearOf;
    @Enumerated(EnumType.STRING)
    private EnergyType energy;
    private double kwh;
    private Timestamp created;
    private Timestamp updated;

}

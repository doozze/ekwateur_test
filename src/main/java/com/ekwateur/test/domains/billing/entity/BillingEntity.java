package com.ekwateur.test.domains.billing.entity;

import com.ekwateur.test.domains.billing.enums.EnergyType;
import com.ekwateur.test.domains.billing.enums.TurnoverRange;
import com.ekwateur.test.domains.customer.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "ekw_billing")
public class BillingEntity {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private EnergyType energy;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    private double price;
    @Enumerated(EnumType.STRING)
    private TurnoverRange proRange;
    private Timestamp created;
    private Timestamp updated;

}

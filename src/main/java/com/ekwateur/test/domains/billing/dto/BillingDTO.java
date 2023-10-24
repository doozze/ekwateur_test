package com.ekwateur.test.domains.billing.dto;

import com.ekwateur.test.domains.billing.enums.EnergyType;
import com.ekwateur.test.domains.billing.enums.TurnoverRange;
import com.ekwateur.test.domains.customer.enums.CustomerType;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class BillingDTO {
    private Long id;
    private EnergyType energy;
    private CustomerType customerType;
    private double price;
    private TurnoverRange proRange;
    private Timestamp created;
    private Timestamp updated;
}

package com.ekwateur.test.domains.billing.dto;

import com.ekwateur.test.domains.billing.enums.EnergyType;
import lombok.Builder;
import lombok.Data;

import java.time.Month;

@Data
@Builder
public class ConsumptionDTO {
    private Long id;
    private Month month;
    private int year;
    private EnergyType energy;
    private double kwh;
}

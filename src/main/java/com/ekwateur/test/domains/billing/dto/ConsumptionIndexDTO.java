package com.ekwateur.test.domains.billing.dto;

import com.ekwateur.test.domains.billing.enums.EnergyType;
import lombok.Data;

import java.time.Month;

@Data
public class ConsumptionIndexDTO {
    private String refCustomer;
    private Month month;
    private int year;
    private EnergyType energy;
    private double kwh;
}

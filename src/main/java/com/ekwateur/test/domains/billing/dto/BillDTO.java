package com.ekwateur.test.domains.billing.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Month;

@Data
@Builder
public class BillDTO {
    private String customerId;
    private Month month;
    private int year;
    private double cost;
}

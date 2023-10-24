package com.ekwateur.test.domains.billing.dto;

import lombok.Data;

import java.time.Month;

@Data
public class CreateBillDTO {
    private String customerId;
    private Month month;
    private int year;
}

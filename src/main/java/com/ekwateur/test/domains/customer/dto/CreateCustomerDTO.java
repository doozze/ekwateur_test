package com.ekwateur.test.domains.customer.dto;

import com.ekwateur.test.domains.customer.enums.CustomerType;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateCustomerDTO implements Serializable {
    private CustomerType type;
    private String civility;
    private String firstName;
    private String lastName;
    private String siretNumber;
    private String raisonSociale;
    private Long turnover;
}

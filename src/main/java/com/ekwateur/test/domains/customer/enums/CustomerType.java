package com.ekwateur.test.domains.customer.enums;

import lombok.Getter;

@Getter
public enum CustomerType {
    PARTICULAR("PARTICULAR"),
    PRO("PRO");

    private final String name;

    CustomerType(String name) {
        this.name = name;
    }
}

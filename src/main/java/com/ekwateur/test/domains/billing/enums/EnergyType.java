package com.ekwateur.test.domains.billing.enums;

import lombok.Getter;

@Getter
public enum EnergyType {
    ELECTRICITY("ELECTRICITY"),
    GAS("GAS");

    private final String name;

    EnergyType(String name) {
        this.name = name;
    }
}

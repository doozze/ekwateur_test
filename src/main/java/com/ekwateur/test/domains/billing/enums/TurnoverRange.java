package com.ekwateur.test.domains.billing.enums;

import lombok.Getter;

@Getter
public enum TurnoverRange {
    LESS_THAN_ONE("LESS_THAN_ONE"),
    MORE_THAN_ONE("MORE_THAN_ONE");

    private final String name;

    TurnoverRange(String name) {
        this.name = name;
    }
}

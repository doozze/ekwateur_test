package com.ekwateur.test.domains.customer.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
public class CustomerDTO {
    protected String refClient;
    protected Timestamp created;
    protected Timestamp updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(refClient, that.refClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refClient);
    }
}

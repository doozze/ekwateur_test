package com.ekwateur.test.domains.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ekw_pro_customer")
public class ProCustomerEntity extends CustomerEntity {
    private String siretNumber;
    private String raisonSociale;
    private Long turnover;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProCustomerEntity that)) return false;
        return Objects.equals(siretNumber, that.siretNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siretNumber);
    }
}

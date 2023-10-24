package com.ekwateur.test.domains.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "ekw_part_customer")
public class ParticularCostumerEntity extends CustomerEntity {
    private String civility;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticularCostumerEntity that)) return false;
        return Objects.equals(civility, that.civility) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(civility, firstName, lastName);
    }
}

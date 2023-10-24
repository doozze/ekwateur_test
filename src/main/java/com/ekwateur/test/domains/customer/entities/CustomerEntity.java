package com.ekwateur.test.domains.customer.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class CustomerEntity {
    @Id
    protected String refClient;
    protected Timestamp created;
    protected Timestamp updated;
}

package com.ekwateur.test.domains.customer.repositories;

import com.ekwateur.test.domains.customer.entities.ParticularCostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticularCustomerRepository extends JpaRepository<ParticularCostumerEntity, String> {
}

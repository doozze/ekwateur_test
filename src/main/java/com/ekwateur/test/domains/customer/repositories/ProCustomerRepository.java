package com.ekwateur.test.domains.customer.repositories;

import com.ekwateur.test.domains.customer.entities.ProCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProCustomerRepository extends JpaRepository<ProCustomerEntity, String> {
}

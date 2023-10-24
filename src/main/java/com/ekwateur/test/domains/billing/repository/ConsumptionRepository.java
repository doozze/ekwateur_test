package com.ekwateur.test.domains.billing.repository;

import com.ekwateur.test.domains.billing.entity.ConsumptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface ConsumptionRepository extends JpaRepository<ConsumptionEntity, Long> {

    List<ConsumptionEntity> findByCustomerIdAndMonthOfYearAndYearOf(String customerId, Month month, int year);

}

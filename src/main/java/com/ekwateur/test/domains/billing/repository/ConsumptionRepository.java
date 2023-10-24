package com.ekwateur.test.domains.billing.repository;

import com.ekwateur.test.domains.billing.entity.ConsumptionEntity;
import com.ekwateur.test.domains.billing.enums.EnergyType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConsumptionRepository extends JpaRepository<ConsumptionEntity, Long> {

    Optional<ConsumptionEntity> findByCustomerIdAndEnergyAndMonthOfYearAndYearOf(String customerId, EnergyType energy, Month month, int Year);

    Page<ConsumptionEntity> findByCustomerId(String customerId, Pageable pageable);

    List<ConsumptionEntity> findByCustomerIdAndMonthOfYearAndYearOf(String customerId, Month month, int year);

}

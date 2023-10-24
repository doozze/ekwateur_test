package com.ekwateur.test.domains.billing.repository;

import com.ekwateur.test.domains.billing.entity.BillingEntity;
import com.ekwateur.test.domains.billing.enums.EnergyType;
import com.ekwateur.test.domains.billing.enums.TurnoverRange;
import com.ekwateur.test.domains.customer.enums.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingEntity, Long> {
    BillingEntity findByEnergyAndCustomerTypeAndProRange(EnergyType energy, CustomerType customerType, TurnoverRange range);

}

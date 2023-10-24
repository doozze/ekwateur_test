package com.ekwateur.test.domains.billing.services;

import com.ekwateur.test.domains.billing.dto.*;

import java.util.List;
import java.util.Optional;

public interface BillingService {
    Long saveConsumption(ConsumptionIndexDTO indexDTO);

    Optional<ConsumptionDTO> getConsumption(Long consumptionId);

    Optional<BillDTO> editBill(CreateBillDTO dto);

    List<BillingDTO> retrieveBilling();
}

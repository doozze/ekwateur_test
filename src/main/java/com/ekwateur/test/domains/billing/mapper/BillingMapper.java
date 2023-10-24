package com.ekwateur.test.domains.billing.mapper;

import com.ekwateur.test.domains.billing.dto.BillingDTO;
import com.ekwateur.test.domains.billing.entity.BillingEntity;

public interface BillingMapper {

    static BillingDTO map(BillingEntity entity) {
        if (entity == null) {
            return null;
        }
        return BillingDTO.builder()
                .id(entity.getId())
                .energy(entity.getEnergy())
                .customerType(entity.getCustomerType())
                .price(entity.getPrice())
                .proRange(entity.getProRange())
                .created(entity.getCreated())
                .updated(entity.getUpdated())
                .build();
    }
}

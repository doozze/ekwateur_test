package com.ekwateur.test.domains.billing.mapper;

import com.ekwateur.test.domains.billing.dto.ConsumptionDTO;
import com.ekwateur.test.domains.billing.dto.ConsumptionIndexDTO;
import com.ekwateur.test.domains.billing.entity.ConsumptionEntity;

import java.sql.Timestamp;
import java.time.Instant;

public interface ConsumptionMapper {

    static ConsumptionEntity toEntity(ConsumptionIndexDTO src) {
        if (src == null)
            return null;
        ConsumptionEntity entity = new ConsumptionEntity();
        entity.setCustomerId(src.getRefCustomer());
        entity.setMonthOfYear(src.getMonth());
        entity.setYearOf(src.getYear());
        entity.setKwh(src.getKwh());
        entity.setEnergy(src.getEnergy());
        entity.setCreated(Timestamp.from(Instant.now()));
        entity.setUpdated(Timestamp.from(Instant.now()));
        return entity;
    }

    static ConsumptionDTO map(ConsumptionEntity entity) {
        if (entity == null)
            return null;
        return ConsumptionDTO.builder().build();
    }
}

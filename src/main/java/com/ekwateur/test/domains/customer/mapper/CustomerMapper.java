package com.ekwateur.test.domains.customer.mapper;

import com.ekwateur.test.domains.customer.dto.CreateCustomerDTO;
import com.ekwateur.test.domains.customer.dto.ParticuliarCustomerDTO;
import com.ekwateur.test.domains.customer.dto.ProCustomerDTO;
import com.ekwateur.test.domains.customer.entities.ParticularCostumerEntity;
import com.ekwateur.test.domains.customer.entities.ProCustomerEntity;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public interface CustomerMapper {

    static ParticularCostumerEntity toPartEntity(CreateCustomerDTO src, String refClient) {
        if (src == null)
            return null;
        ParticularCostumerEntity entity = new ParticularCostumerEntity();
        entity.setRefClient(refClient);
        entity.setCivility(src.getCivility());
        entity.setFirstName(src.getFirstName());
        entity.setLastName(src.getLastName());
        entity.setCreated(Timestamp.from(Instant.now()));
        entity.setUpdated(Timestamp.from(Instant.now()));
        return entity;
    }

    static ProCustomerEntity toProEntity(CreateCustomerDTO src, String refClient) {
        if (src == null)
            return null;
        ProCustomerEntity entity = new ProCustomerEntity();
        entity.setRefClient(refClient);
        entity.setSiretNumber(src.getSiretNumber());
        entity.setRaisonSociale(src.getRaisonSociale());
        entity.setTurnover(src.getTurnover());
        entity.setCreated(Timestamp.from(Instant.now()));
        entity.setUpdated(Timestamp.from(Instant.now()));
        return entity;
    }

    static ParticuliarCustomerDTO map(ParticularCostumerEntity entity) {
        if (entity == null)
            return null;
        ParticuliarCustomerDTO dto = ParticuliarCustomerDTO.Builder.aParticuliarCustomerDTO()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .civility(entity.getCivility())
                .build();
        dto.setRefClient(entity.getRefClient());
        dto.setCreated(entity.getCreated());
        dto.setUpdated(entity.getUpdated());
        return dto;
    }

    static ProCustomerDTO map(ProCustomerEntity entity) {
        if (entity == null)
            return null;
        ProCustomerDTO dto = ProCustomerDTO.Builder.aProCustomerDTO()
                .raisonSociale(entity.getRaisonSociale())
                .siretNumber(entity.getSiretNumber())
                .turnover(entity.getTurnover())
                .build();
        dto.setRefClient(entity.getRefClient());
        dto.setCreated(entity.getCreated());
        dto.setUpdated(entity.getUpdated());
        return dto;
    }
}

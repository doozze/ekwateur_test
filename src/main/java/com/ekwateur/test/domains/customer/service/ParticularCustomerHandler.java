package com.ekwateur.test.domains.customer.service;

import com.ekwateur.test.domains.customer.dto.CreateCustomerDTO;
import com.ekwateur.test.domains.customer.dto.CustomerDTO;
import com.ekwateur.test.domains.customer.dto.ParticuliarCustomerDTO;
import com.ekwateur.test.domains.customer.entities.ParticularCostumerEntity;
import com.ekwateur.test.domains.customer.enums.CustomerType;
import com.ekwateur.test.domains.customer.mapper.CustomerMapper;
import com.ekwateur.test.domains.customer.repositories.ParticularCustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParticularCustomerHandler extends CustomerHandler {

    private final ParticularCustomerRepository repository;

    @Override
    public String handleCreate(CreateCustomerDTO create) {
        if (!CustomerType.PARTICULAR.equals(create.getType()))
            handleCreateNext(create);
        // valid Data
        // s'assurer client pas encore en base
        String refClient = "";
        ParticularCostumerEntity entity = CustomerMapper.toPartEntity(create, generateRefClient());
        return repository.save(entity).getRefClient();
    }

    @Override
    public CustomerDTO handleFetch(String customerId) {
        Optional<ParticuliarCustomerDTO> optional = repository.findById(customerId).map(CustomerMapper::map);
        if (optional.isPresent())
            return optional.get();
        else
            return handleFetchNext(customerId);
    }
}

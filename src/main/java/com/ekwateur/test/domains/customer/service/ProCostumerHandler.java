package com.ekwateur.test.domains.customer.service;

import com.ekwateur.test.domains.customer.dto.CreateCustomerDTO;
import com.ekwateur.test.domains.customer.dto.CustomerDTO;
import com.ekwateur.test.domains.customer.dto.ProCustomerDTO;
import com.ekwateur.test.domains.customer.entities.ProCustomerEntity;
import com.ekwateur.test.domains.customer.enums.CustomerType;
import com.ekwateur.test.domains.customer.mapper.CustomerMapper;
import com.ekwateur.test.domains.customer.repositories.ProCustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProCostumerHandler extends CustomerHandler {

    private final ProCustomerRepository repository;

    @Override
    public String handleCreate(CreateCustomerDTO create) {
        if (!CustomerType.PARTICULAR.equals(create.getType()))
            handleCreateNext(create);
        ProCustomerEntity entity = CustomerMapper.toProEntity(create, generateRefClient());
        return repository.save(entity).getRefClient();
    }

    @Override
    public CustomerDTO handleFetch(String customerId) {
        Optional<ProCustomerDTO> optional = repository.findById(customerId).map(CustomerMapper::map);
        if (optional.isPresent())
            return optional.get();
        else
            return handleFetchNext(customerId);
    }
}

package com.ekwateur.test.domains.billing.services;

import com.ekwateur.test.domains.billing.dto.*;
import com.ekwateur.test.domains.billing.entity.BillingEntity;
import com.ekwateur.test.domains.billing.entity.ConsumptionEntity;
import com.ekwateur.test.domains.billing.enums.TurnoverRange;
import com.ekwateur.test.domains.billing.mapper.BillingMapper;
import com.ekwateur.test.domains.billing.mapper.ConsumptionMapper;
import com.ekwateur.test.domains.billing.repository.BillingRepository;
import com.ekwateur.test.domains.billing.repository.ConsumptionRepository;
import com.ekwateur.test.domains.customer.dto.CustomerDTO;
import com.ekwateur.test.domains.customer.dto.ParticuliarCustomerDTO;
import com.ekwateur.test.domains.customer.dto.ProCustomerDTO;
import com.ekwateur.test.domains.customer.enums.CustomerType;
import com.ekwateur.test.domains.customer.factory.CustomerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    private final ConsumptionRepository consumptionRepository;

    private final CustomerFactory customerFactory;

    @Override
    public Long saveConsumption(ConsumptionIndexDTO indexDTO) {
        // check if not already exists
        // if yes => update
        ConsumptionEntity entity = ConsumptionMapper.toEntity(indexDTO);
        return consumptionRepository.save(entity).getId();
    }

    @Override
    public Optional<ConsumptionDTO> getConsumption(Long consumptionId) {
        return consumptionRepository.findById(consumptionId).map(ConsumptionMapper::map);
    }

    @Override
    public Optional<BillDTO> editBill(CreateBillDTO dto) {
        CustomerDTO customerDTO = customerFactory.creation().handleFetch(dto.getCustomerId());
        CustomerType customerType;
        if (customerDTO instanceof ParticuliarCustomerDTO) {
            customerType = CustomerType.PARTICULAR;
        } else {
            customerType = CustomerType.PRO;
        }
        // check if customer exist
        List<ConsumptionEntity> conso = consumptionRepository.findByCustomerIdAndMonthOfYearAndYearOf(dto.getCustomerId(),
                dto.getMonth(), dto.getYear());
        if (conso.isEmpty()) {
            return Optional.of(BillDTO.builder()
                    .customerId(dto.getCustomerId())
                    .month(dto.getMonth())
                    .year(dto.getYear())
                    .cost(0)
                    .build());
        }
        double cost = 0;
        for (ConsumptionEntity entity : conso) {
            TurnoverRange range = defineTurnoverRange(customerDTO, customerType);
            BillingEntity billing = billingRepository.findByEnergyAndCustomerTypeAndProRange(entity.getEnergy(), customerType, range);
            cost += (billing.getPrice()) * entity.getKwh();
        }

        return Optional.ofNullable(BillDTO.builder()
                .customerId(dto.getCustomerId())
                .month(dto.getMonth())
                .year(dto.getYear())
                .cost(cost)
                .build());
    }

    private TurnoverRange defineTurnoverRange(CustomerDTO customer, CustomerType customerType) {
        if (CustomerType.PARTICULAR.equals(customerType))
            return null;
        ProCustomerDTO pro = (ProCustomerDTO) customer;
        return pro.getTurnover() >= 1000000 ? TurnoverRange.MORE_THAN_ONE : TurnoverRange.LESS_THAN_ONE;
    }

    @Override
    public List<BillingDTO> retrieveBilling() {
        return billingRepository.findAll().stream().map(BillingMapper::map).toList();
    }
}

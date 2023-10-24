package com.ekwateur.test.domains.customer.factory;

import com.ekwateur.test.domains.customer.service.CustomerHandler;
import com.ekwateur.test.domains.customer.service.ParticularCustomerHandler;
import com.ekwateur.test.domains.customer.service.ProCostumerHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CustomerFactory {

    private final ParticularCustomerHandler particularHandler;
    private final ProCostumerHandler proHandler;


    public CustomerHandler creation() {
        return CustomerHandler.link(particularHandler, proHandler);
    }

}

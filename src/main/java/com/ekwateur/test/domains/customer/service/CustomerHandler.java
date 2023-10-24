package com.ekwateur.test.domains.customer.service;

import com.ekwateur.test.domains.customer.dto.CreateCustomerDTO;
import com.ekwateur.test.domains.customer.dto.CustomerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.ThreadLocalRandom;

public abstract class CustomerHandler {

    protected ObjectMapper objectMapper;
    private CustomerHandler next;

    public static CustomerHandler link(CustomerHandler first, CustomerHandler... chain) {
        CustomerHandler head = first;
        for (CustomerHandler nextHandler : chain) {
            head.next = nextHandler;
            head = nextHandler;
        }
        return first;
    }

    public abstract String handleCreate(CreateCustomerDTO create);

    public abstract CustomerDTO handleFetch(String customerId);

    protected void handleCreateNext(CreateCustomerDTO create) {
        if (next == null)
            return;
        next.handleCreate(create);
    }

    protected CustomerDTO handleFetchNext(String customerId) {
        if (next == null)
            return null;
        return next.handleFetch(customerId);
    }

    protected String generateRefClient() {
        int min = 10000000;
        int max = 99999999;
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);
        return String.format("EKW%d", random);
    }
}

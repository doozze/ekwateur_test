package com.ekwateur.test.web.controller;


import com.ekwateur.test.domains.customer.dto.CreateCustomerDTO;
import com.ekwateur.test.domains.customer.dto.CustomerDTO;
import com.ekwateur.test.domains.customer.factory.CustomerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerFactory factory;

    @PostMapping
    ResponseEntity<String> createCustomer(@RequestBody CreateCustomerDTO create) {
        log.debug("Request to create a customer with data {}", create);
        return new ResponseEntity<>(factory.creation().handleCreate(create), HttpStatus.CREATED);
    }

    @GetMapping("{customerId}")
    ResponseEntity<CustomerDTO> getCustomer(@PathVariable String customerId) {
        log.debug("Request to fetch a customer with id {}", customerId);
        return ResponseEntity.ok(factory.creation().handleFetch(customerId));
    }

}

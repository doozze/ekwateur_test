package com.ekwateur.test.web.controller;

import com.ekwateur.test.domains.billing.dto.*;
import com.ekwateur.test.domains.billing.services.BillingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/billing")
@RequiredArgsConstructor
@Slf4j
public class BillingController {

    private final BillingService billingService;

    @PostMapping("consumption")
    ResponseEntity<Long> saveConsumption(@RequestBody ConsumptionIndexDTO index) {
        return new ResponseEntity<>(billingService.saveConsumption(index), HttpStatus.CREATED);
    }

    @GetMapping("consumption/{id}")
    ResponseEntity<ConsumptionDTO> getConsumption(@PathVariable Long id) {
        Optional<ConsumptionDTO> optional = billingService.getConsumption(id);
        return optional.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("bill")
    ResponseEntity<BillDTO> editConsumptionBill(@RequestBody CreateBillDTO create) {
        Optional<BillDTO> optional = billingService.editBill(create);
        return optional.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    ResponseEntity<List<BillingDTO>> fetchBillings() {
        return ResponseEntity.ok(billingService.retrieveBilling());
    }

}

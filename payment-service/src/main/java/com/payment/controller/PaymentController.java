package com.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping
    public String makePayment() {
        return "Payment successful ";
    }

    @GetMapping("/{id}")
    public String getPayment(@PathVariable Long id) {
        return "Payment details for: " + id;
    }
}
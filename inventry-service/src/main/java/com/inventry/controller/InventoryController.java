package com.inventry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public String checkInventory(@PathVariable Long productId) {
        return "Inventory available for product: " + productId;
    }

    @PostMapping("/reserve")
    public String reserveInventory(@RequestBody String product) {
        return "Inventory reserved for: " + product;
    }
}
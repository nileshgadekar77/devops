package com.order.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final RestClient restClient;

	public OrderController(RestClient.Builder builder) {
		this.restClient = builder.build();
	}

	@PostMapping
	public String createOrder(@RequestParam Long productId) {

		// Call Inventory Service
		String inventory = restClient.get().uri("http://inventry-service:8081/inventory/101").retrieve()
				.body(String.class);

		// Call Payment Service
		String payment = restClient.post().uri("http://payment-service:8082/payments").retrieve().body(String.class);

		return "Order created | " + inventory + " | " + payment;
	}

	@GetMapping
	public String getPayment() {

		return "Order successful ";
	}
}

@Configuration
class RestClientConfig {

	@Bean
	public RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}
}
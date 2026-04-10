package com.skk.apigateway.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class FallbackController {

    @GetMapping("/fallback/order-service")
    fun orderServiceFallback(): Mono<String> {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later.")
    }
}

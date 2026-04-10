package com.skk.apigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * The entry point for your API Gateway.
 *
 * Using @EnableDiscoveryClient allows this gateway to find other
 * microservices (like your inventory or order services) using
 * Netflix Eureka (the Chassis pattern).
 */
@SpringBootApplication
@EnableDiscoveryClient
class ApiGatewayApplication

fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}

package com.skk.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * Main entry point for the Authentication Service.
 * This service handles user login, JWT generation, and validation.
 */
@SpringBootApplication
@EnableDiscoveryClient
class AuthApplication

fun main(args: Array<String>) {
    runApplication<AuthApplication>(*args)
}

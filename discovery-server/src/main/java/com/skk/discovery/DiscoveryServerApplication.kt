package com.skk.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication(exclude = [
    org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration::class,
    org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration::class
])
@EnableEurekaServer // This turns the app into a Eureka Registry
class DiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<DiscoveryServerApplication>(*args)
}

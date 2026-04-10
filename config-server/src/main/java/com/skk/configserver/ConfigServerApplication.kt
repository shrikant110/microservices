package com.skk.configserver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer



@SpringBootApplication(exclude = [
    org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration::class,
    org.springframework.boot.autoconfigure.r2dbc.R2dbcTransactionManagerAutoConfiguration::class
])
@EnableConfigServer // This is the key annotation
class ConfigServerApplication

fun main(args: Array<String>) {
    runApplication<ConfigServerApplication>(*args)
}

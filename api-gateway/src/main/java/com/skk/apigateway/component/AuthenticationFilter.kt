package com.skk.apigateway.component

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class AuthenticationFilter : AbstractGatewayFilterFactory<AuthenticationFilter.Config>(Config::class.java) {
    class Config

    override fun apply(config: Config): GatewayFilter = GatewayFilter { exchange, chain ->
        val request = exchange.request
        if (!request.headers.containsKey(HttpHeaders.AUTHORIZATION)) {
            throw RuntimeException("Missing Authorization Header")
        }

        val authHeader = request.headers[HttpHeaders.AUTHORIZATION]?.get(0)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw RuntimeException("Invalid Authorization Header")
        }

        val token = authHeader.substring(7)
        try {
            // MUST be the exact same 32+ character string used in JwtService
            val secret = "your-very-secure-secret-key-that-is-at-least-32-characters"
            val key = Keys.hmacShaKeyFor(secret.toByteArray())

            val jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)

            // 1. You MUST call .body to get the claims
            val claims = jws.body
            val type = claims["tokenType"]?.toString()
            if (type != "ACCESS") {
                throw RuntimeException("Refresh token cannot be used for API access")
            }

        } catch (e: Exception) {
            // Log the actual cause so you can see it in the console
            println("Gateway JWT Validation Error: ${e.message}")
            throw RuntimeException("Unauthorized access to order details")
        }

        chain.filter(exchange)
    }
}

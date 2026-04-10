package com.skk.auth.service

import org.springframework.stereotype.Service
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.Date

@Service
class JwtService {
    private val secret = "your-very-secure-secret-key-that-is-at-least-32-characters"
    private val expirationTime = 3600000 // 1 hour
    /*
    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(Keys.hmacShaKeyFor(secret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }*/
    fun generateAccessToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .claim("tokenType", "ACCESS") // Key differentiation
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 900000)) // 15 mins
            .signWith(Keys.hmacShaKeyFor(secret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }

    fun generateRefreshToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .claim("tokenType", "REFRESH") // Key differentiation
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 604800000)) // 7 days
            .signWith(Keys.hmacShaKeyFor(secret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }

    fun extractUsername(token: String): String {
        return extractAllClaims(token).subject
    }

    private fun extractAllClaims(token: String): io.jsonwebtoken.Claims {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secret.toByteArray()))
            .build()
            .parseClaimsJws(token)
            .body
    }
}

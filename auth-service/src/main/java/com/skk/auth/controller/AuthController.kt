package com.skk.auth.controller


import com.skk.auth.service.JwtService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(private val jwtService: JwtService) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): AuthResponse {
        // TODO: In a real app, validate credentials against a database here
        val token = jwtService.generateAccessToken(loginRequest.username)
        val refreshToken = jwtService.generateRefreshToken(loginRequest.username)
        return AuthResponse(token,refreshToken)
    }
    @GetMapping("/login")
    fun login(@RequestParam username: String): AuthResponse {
        // TODO: In a real app, validate credentials against a database here
        val token = jwtService.generateAccessToken(username)
        val refreshToken = jwtService.generateRefreshToken(username)
        return AuthResponse(token,refreshToken)
    }
    @PostMapping("/refresh")
    fun refresh(@RequestBody request: RefreshRequest): AuthResponse {
        val username = jwtService.extractUsername(request.refreshToken)

        // 1. Validate the refresh token signature/expiration
        // 2. Optional: Verify against Database/Redis to check if revoked

        val newAccessToken = jwtService.generateAccessToken(username)
        return AuthResponse(newAccessToken, request.refreshToken)
    }
}


data class RefreshRequest(val refreshToken: String)

data class LoginRequest(val username: String, val password: String)
data class AuthResponse(val token: String,val refreshToken:String)
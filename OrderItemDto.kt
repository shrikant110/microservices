package com.skk.order.dto

data class OrderItemDto(
    val productId: String,
    val name: String,
    val quantity: Int,
    val price: Double
)
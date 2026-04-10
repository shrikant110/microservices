package com.skk.order.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Order(
    @JsonProperty("orderId")
    val orderId: String,
    
    @JsonProperty("orderDate")
    val orderDate: LocalDateTime,
    
    @JsonProperty("status")
    val status: String,
    
    @JsonProperty("customer")
    val customer: CustomerDto,
    
    @JsonProperty("items")
    val items: List<OrderItemDto>,
    
    @JsonProperty("shipping")
    val shipping: ShippingDto,
    
    @JsonProperty("totals")
    val totals: TotalsDto
)
package com.skk.order.service

import com.skk.order.dto.Country
import org.springframework.stereotype.Service

@Service
class CountryService {
    fun getCountries(): List<Country> {
        return listOf(
            Country("US", "United States"),
            Country("CA", "Canada"),
            Country("GB", "United Kingdom")
        )
    }
}

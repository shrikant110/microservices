package com.skk.order.controller

import com.skk.order.dto.Country
import com.skk.order.service.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders/api/countries")
class CountryController(private val countryService: CountryService) {

    @GetMapping
    fun getAllCountries(): List<Country> {
        return countryService.getCountries()
    }
}

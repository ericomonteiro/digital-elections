package com.github.ericomonteiro.elections.gateway

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@FeignClient(value ="viaCepApi", url = "http://viacep.com.br")
interface ViaCepApi {

    @GetMapping("/ws/{zipCode}/json/", consumes = ["application/json"])
    @ResponseBody
    fun searchAddress(@PathVariable("zipCode") zipCode: String): Map<String, Any>

}
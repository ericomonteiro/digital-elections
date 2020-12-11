package com.github.ericomonteiro.elections.entrypoint.rest.v1

import com.github.ericomonteiro.elections.usecase.viacep.SearchAddress
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/address")
class AddressController (
    private val searchAddress: SearchAddress
)
{
    @GetMapping("/zipcode/{zipCode}")
    @ResponseBody
    fun findAddress(@PathVariable zipCode: String) =
        searchAddress.execute(zipCode)

}
package com.github.ericomonteiro.elections.usecase.viacep

import com.github.ericomonteiro.elections.gateway.ViaCepApi
import org.springframework.stereotype.Service

@Service
class SearchAddress (
    private val viaCepApi: ViaCepApi
) {

    fun execute(cep: String) = viaCepApi.searchAddress(cep)

}
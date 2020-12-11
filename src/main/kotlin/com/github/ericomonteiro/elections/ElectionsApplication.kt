package com.github.ericomonteiro.elections

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ElectionsApplication

fun main(args: Array<String>) {
	runApplication<ElectionsApplication>(*args)
}

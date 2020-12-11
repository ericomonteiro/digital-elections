package com.github.ericomonteiro.elections.config.feign

import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.Logbook
import org.zalando.logbook.okhttp.GzipInterceptor
import org.zalando.logbook.okhttp.LogbookInterceptor

@Configuration
class FeignDefaultConfiguration(
    private val logbook: Logbook
) {

    @Bean
    fun client(): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(LogbookInterceptor(logbook))
            .addNetworkInterceptor(GzipInterceptor())
            .build()

}
package com.github.ericomonteiro.elections.config.feign

import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.Logbook
import org.zalando.logbook.httpclient.LogbookHttpRequestInterceptor
import org.zalando.logbook.httpclient.LogbookHttpResponseInterceptor

@Configuration
class FeignDefaultConfiguration(
    private val logbook: Logbook
) {

    @Bean
    fun client(): CloseableHttpClient = HttpClientBuilder.create()
        .addInterceptorFirst(LogbookHttpRequestInterceptor(logbook))
        .addInterceptorFirst(LogbookHttpResponseInterceptor())
        .build()

}
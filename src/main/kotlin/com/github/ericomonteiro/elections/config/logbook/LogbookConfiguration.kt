package com.github.ericomonteiro.elections.config.logbook

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.zalando.logbook.Conditions.exclude
import org.zalando.logbook.Conditions.requestTo
import org.zalando.logbook.DefaultHttpLogWriter
import org.zalando.logbook.DefaultSink
import org.zalando.logbook.HeaderFilters.authorization
import org.zalando.logbook.Logbook
import org.zalando.logbook.QueryFilters.accessToken
import org.zalando.logbook.QueryFilters.replaceQuery
import org.zalando.logbook.json.JsonHttpLogFormatter
import org.zalando.logbook.json.PrettyPrintingJsonBodyFilter

@Configuration
class LogbookConfiguration {


    @Bean
    fun logbook(): Logbook = Logbook.builder()
        .condition(exclude(
            requestTo("/webjars/**"),
            requestTo("/v2/api-docs"),
            requestTo("/swagger-resources/**"),
            requestTo("/swagger-ui.html"),
            requestTo("/csrf"),
            requestTo("/health")
        ))
        .sink(DefaultSink(
            JsonHttpLogFormatter(),
            DefaultHttpLogWriter()
        ))
        .bodyFilter(PrettyPrintingJsonBodyFilter())
        .queryFilter(accessToken())
        .queryFilter(replaceQuery("password", "<secret>"))
        .headerFilter(authorization())
        .build()

}
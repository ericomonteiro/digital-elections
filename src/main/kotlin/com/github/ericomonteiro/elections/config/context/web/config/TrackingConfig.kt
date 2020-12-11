package com.github.ericomonteiro.elections.config.context.web.config

import com.github.ericomonteiro.elections.config.context.web.filter.TrackingFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TrackingConfig {

    @Bean
    fun trackingFilterBean(): FilterRegistrationBean<TrackingFilter> =
        FilterRegistrationBean<TrackingFilter>()
            .apply {
                this.setName("trackingFilter")
                this.filter = TrackingFilter()
                this.order = 1
            }

}
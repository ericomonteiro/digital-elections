package com.github.ericomonteiro.elections.config.tracing

import io.opentracing.contrib.java.spring.jaeger.starter.TracerBuilderCustomizer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@AutoConfigureBefore(name = ["io.opentracing.contrib.java.spring.jaeger.starter.JaegerAutoConfiguration"])
class TracingAutoConfiguration (
    @Value("\${spring.application.name}")
    private val name: String
) {

    @Configuration
    class ScopeManagerTraceConfiguration {
        @Bean
        fun scopeManagerJaegerTracerCustomizer(): TracerBuilderCustomizer = ScopeManagerTracerBuilderCustomizer()
    }
}
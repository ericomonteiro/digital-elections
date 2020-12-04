package com.github.ericomonteiro.elections.config.tracing

import io.jaegertracing.internal.JaegerTracer
import io.opentracing.contrib.java.spring.jaeger.starter.TracerBuilderCustomizer

class ScopeManagerTracerBuilderCustomizer : TracerBuilderCustomizer {

    override fun customize(builder: JaegerTracer.Builder) {
        builder.withScopeManager(DiagnosticContextScopeManager())
    }
}
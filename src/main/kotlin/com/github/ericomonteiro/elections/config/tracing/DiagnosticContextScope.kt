package com.github.ericomonteiro.elections.config.tracing

import com.github.ericomonteiro.elections.config.tracing.DiagnosticContextScopeManager.Companion.CORRELATION_ID
import com.github.ericomonteiro.elections.config.tracing.DiagnosticContextScopeManager.Companion.SPAN_ID
import com.github.ericomonteiro.elections.config.tracing.DiagnosticContextScopeManager.Companion.TRACE_ID
import io.opentracing.Scope
import io.opentracing.Span
import io.opentracing.SpanContext
import org.slf4j.MDC

class DiagnosticContextScope private constructor(
    private val scopeManager: DiagnosticContextScopeManager,
    private val wrapped: Span,
    private val toRestore: DiagnosticContextScope?
) : Scope {

    constructor(scopeManager: DiagnosticContextScopeManager, wrapped: Span) : this(
        scopeManager,
        wrapped,
        scopeManager.getTlsScope().get()
    ) {
        this.scopeManager.getTlsScope().set(this)
        injectMdc(wrapped.context())
    }

    override fun close() {
        if (scopeManager.getTlsScope().get() !== this) {
            return
        }
        scopeManager.getTlsScope().set(toRestore)// restore the previous scope

        if (toRestore?.wrapped != null) {
            injectMdc(toRestore.wrapped.context())
        } else {
            cleanMdc(wrapped.context())
        }
    }

    fun span(): Span {
        return wrapped
    }

    private fun injectMdc(context: SpanContext) {
        mdcReplace(TRACE_ID, context.toTraceId())
        mdcReplace(SPAN_ID, context.toSpanId())
        context.baggageItems().forEach {
            var key = it.key
            if (key == CORRELATION_ID.toLowerCase()) key = CORRELATION_ID //Set correlation-id field to camel case
            mdcReplace(key, it.value)
        }
    }

    private fun cleanMdc(context: SpanContext) {
        MDC.remove(TRACE_ID)
        MDC.remove(SPAN_ID)
        MDC.remove(CORRELATION_ID)
        context.baggageItems().forEach { MDC.remove(it.key) }
    }

    private fun mdcReplace(key: String, value: String?) {
        if (value != null) {
            MDC.put(key, value)
        } else {
            MDC.remove(key)
        }
    }

}
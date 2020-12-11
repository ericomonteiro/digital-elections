package com.github.ericomonteiro.elections.config.context.web.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(TrackingConfig::class)
class ContextTrackingAutoConfiguration
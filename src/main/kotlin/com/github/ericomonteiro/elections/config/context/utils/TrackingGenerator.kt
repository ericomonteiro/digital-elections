package com.github.ericomonteiro.elections.config.context.utils

import java.util.UUID

fun generate(): String = UUID.randomUUID().toString().replace("-", "")
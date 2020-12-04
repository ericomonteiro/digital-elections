package com.github.ericomonteiro.elections.entrypoint.dto

import java.time.LocalDateTime
import javax.validation.constraints.Future
import javax.validation.constraints.Max
import javax.validation.constraints.Min


data class ElectionCreateDto (
    val year: Int,
    @field:Min(1)
    @field:Max(2)
    val round: Int,
    @field:Future
    val startTime: LocalDateTime,
    @field:Future
    val endTime: LocalDateTime
)
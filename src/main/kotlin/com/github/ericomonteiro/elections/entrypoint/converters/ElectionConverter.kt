package com.github.ericomonteiro.elections.entrypoint.converters

import com.github.ericomonteiro.elections.domain.entity.Election
import com.github.ericomonteiro.elections.entrypoint.dto.ElectionCreateDto
import java.util.UUID

fun ElectionCreateDto.toDomain() = Election(
    id = UUID.randomUUID(),
    year = this.year,
    round = this.round,
    startTime = this.startTime,
    endTime = this.endTime
)
package com.github.ericomonteiro.elections.domain.entity

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class Election(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val year: Int,
    val round: Int,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)
package com.github.ericomonteiro.elections.domain.entity

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Candidate(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID,
    val name: String,
    val number: Int,
    @ManyToOne
    val party: Party,
    @ManyToOne
    val election: Election,
    val imageAddress: String
)
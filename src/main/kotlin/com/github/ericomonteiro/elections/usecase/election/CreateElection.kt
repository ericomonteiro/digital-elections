package com.github.ericomonteiro.elections.usecase.election

import com.github.ericomonteiro.elections.domain.entity.Election
import com.github.ericomonteiro.elections.domain.port.ElectionRepository
import org.springframework.stereotype.Service

@Service
class CreateElection (
    val electionRepository: ElectionRepository
) {

    fun execute(election: Election): Election {
        return electionRepository.save(election)
    }

}
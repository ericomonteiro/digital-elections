package com.github.ericomonteiro.elections.entrypoint.rest

import com.github.ericomonteiro.elections.domain.entity.Election
import com.github.ericomonteiro.elections.entrypoint.converters.toDomain
import com.github.ericomonteiro.elections.entrypoint.dto.ElectionCreateDto
import com.github.ericomonteiro.elections.usecase.election.CreateElection
import com.github.ericomonteiro.elections.usecase.election.ListAllElections
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("election")
class ElectionController(
    private val createElection: CreateElection,
    private val listAllElections: ListAllElections
) {

    @PostMapping
    fun createElection(@Valid @RequestBody election: ElectionCreateDto): ResponseEntity<Election> =
        ResponseEntity(createElection.execute(election.toDomain()), HttpStatus.CREATED)

    @GetMapping()
    fun listAllElections() = listAllElections.execute()

}
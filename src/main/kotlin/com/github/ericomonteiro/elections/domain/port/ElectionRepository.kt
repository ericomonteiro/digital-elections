package com.github.ericomonteiro.elections.domain.port

import com.github.ericomonteiro.elections.domain.entity.Election
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ElectionRepository: JpaRepository<Election, UUID>
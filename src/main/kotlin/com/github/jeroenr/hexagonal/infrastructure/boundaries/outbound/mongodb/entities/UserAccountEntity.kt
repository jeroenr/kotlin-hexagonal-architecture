package com.github.jeroenr.hexagonal.infrastructure.boundaries.outbound.mongodb.entities

import com.github.jeroenr.hexagonal.domain.model.Currency
import com.github.jeroenr.hexagonal.domain.model.Money
import com.github.jeroenr.hexagonal.domain.model.UserAccountDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.Instant

/**
 * Sample entity
 */
@Document
data class UserAccountEntity(
    @Id
    val id: String,
    var name: String,
    var balance: BigDecimal,
    var currency: String,
    var createdAt: Instant = Instant.now(),
    var updatedAt: Instant = Instant.now()
)

package com.github.jeroenr.hexagonal.infrastructure.boundaries.outbound.mongodb

import com.github.jeroenr.hexagonal.domain.model.UserAccountDto
import com.github.jeroenr.hexagonal.domain.ports.UserAccountRepositoryPort
import com.github.jeroenr.hexagonal.infrastructure.boundaries.outbound.mongodb.entities.UserAccountEntity
import com.github.jeroenr.hexagonal.infrastructure.boundaries.outbound.mongodb.entities.UserAccountMapper
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

/**
 * Adapter to convert our entity to our DTO and back,
 */
@Component
class UserAccountRepositorySpringDataAdapter(
    private val userAccountRepository: UserAccountRepository,
    private val userAccountMapper: UserAccountMapper) :
        UserAccountRepositoryPort {
    override suspend fun findById(id: String): UserAccountDto? =
        userAccountRepository.findById(id)?.let { userAccountMapper.toUserAccountDto(it) }

    override suspend fun save(userAccount: UserAccountDto): UserAccountDto =
        userAccountMapper.toUserAccountEntity(userAccount).let {
            userAccountMapper.toUserAccountDto(userAccountRepository.save(it))
        }
}

/**
 * Sample of an actual spring data repository. In this case it uses coroutines.
 */
@Repository
interface UserAccountRepository : CoroutineCrudRepository<UserAccountEntity, String>

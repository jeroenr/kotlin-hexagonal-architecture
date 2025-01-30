package com.github.jeroenr.hexagonal.infrastructure.boundaries.outbound.mongodb.entities

import com.github.jeroenr.hexagonal.domain.model.UserAccountDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface UserAccountMapper {
    @Mapping(source = "balance", target = "balance.amount")
    @Mapping(source = "currency", target = "balance.currency")
    fun toUserAccountDto(userAccountEntity: UserAccountEntity): UserAccountDto

    @Mapping(source = "balance.amount", target = "balance")
    @Mapping(source = "balance.currency", target = "currency")
    fun toUserAccountEntity(userAccountDto: UserAccountDto): UserAccountEntity
}
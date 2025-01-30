package com.github.jeroenr.hexagonal.infrastructure.boundaries.outbound.mongodb.entities

import com.github.jeroenr.hexagonal.domain.model.UserAccountDto
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.ERROR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
interface UserAccountMapper {
    @Mapping(source = "balance", target = "balance.amount")
    @Mapping(source = "currency", target = "balance.currency")
    @BeanMapping(ignoreUnmappedSourceProperties = ["createdAt", "updatedAt"])
    fun toUserAccountDto(userAccountEntity: UserAccountEntity): UserAccountDto

    @Mapping(source = "balance.amount", target = "balance")
    @Mapping(source = "balance.currency", target = "currency")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    fun toUserAccountEntity(userAccountDto: UserAccountDto): UserAccountEntity
}
package com.github.jeroenr.hexagonal.infrastructure.configuration

import org.mapstruct.MapperConfig

@MapperConfig(
    componentModel = "spring",
    unmappedSourcePolicy = org.mapstruct.ReportingPolicy.ERROR,
    unmappedTargetPolicy = org.mapstruct.ReportingPolicy.ERROR
)
interface MapperConfiguration
package com.narinc.rootproject.remote.mappers

interface EntityMapper<M, E> {

    fun mapFromModel(model: M): E
}

package com.example.newsfeedtestapp.remote.mappers

interface EntityMapper<M, E> {
    fun mapFromModel(model: M): E
}

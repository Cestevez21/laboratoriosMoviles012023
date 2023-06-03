package com.example.laboratorio05.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MovieWithActor (
    @Embedded val movie: MovieModel,
    @Relation(
            parentColumn = "movieId",
            entityColumn = "actorId",
            associateBy = Junction(CastModel::class)

    )
    val actors: List<ActorModel>
)
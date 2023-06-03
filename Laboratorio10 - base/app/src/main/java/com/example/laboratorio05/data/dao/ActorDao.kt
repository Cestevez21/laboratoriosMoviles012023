package com.example.laboratorio05.data.dao

interface ActorDao {
    @Query("SELECT * FROM actor_table")
    suspend fun getAllActors(): List<ActorModel>

    @Transaction
    @Insert
    suspend fun insertActor(actor: ActorModel)
}
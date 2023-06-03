package com.example.laboratorio05.data.dao

interface CastDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(casting:CastModel)
}
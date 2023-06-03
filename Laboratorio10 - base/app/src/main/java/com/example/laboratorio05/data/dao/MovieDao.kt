package com.example.laboratorio05.data.dao

interface MovieDao {
    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieModel>

    @Transaction
    @Insert
    suspend fun insertMovie(movie: MovieModel)

    @Query("SELECT * FROM movie_table WHERE movieIde = :movieId")
    suspend fun getMovieWithActorsById(movie: MovieModel): MovieWithActor?
}
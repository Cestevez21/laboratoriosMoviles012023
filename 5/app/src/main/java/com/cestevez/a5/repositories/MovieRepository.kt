package com.cestevez.a5.repositories

import com.cestevez.a5.data.model.MovieModel
import com.cestevez.a5.data.movies

class MovieRepository (private val movie:MutableList<MovieModel>){

    fun getMovies() = movies

    fun addMovies(movie:MovieModel) = movies.add(movie)

}
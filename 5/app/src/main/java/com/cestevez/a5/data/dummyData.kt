package com.cestevez.a5.data

import com.cestevez.a5.data.model.MovieModel

val name = "Movie 1"
val category = "category movie 1"
val description = "Description movie 1"
val calification = "9.8"

var movies = mutableListOf(
    MovieModel(name, category, description, calification)
)
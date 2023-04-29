package com.cestevez.a5

import android.app.Application
import com.cestevez.a5.data.movies
import com.cestevez.a5.repositories.MovieRepository

class MovieReviwerApplication : Application() {
    val MovieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}
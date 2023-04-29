package com.cestevez.a5.ui.movies

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cestevez.a5.MovieReviwerApplication
import com.cestevez.a5.data.model.MovieModel
import com.cestevez.a5.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel(){
    fun getMovies() = repository.getMovie()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY]as MovieReviwerApplication
                MovieViewModel(app.MovieRepository)
            }
            }
    }
}
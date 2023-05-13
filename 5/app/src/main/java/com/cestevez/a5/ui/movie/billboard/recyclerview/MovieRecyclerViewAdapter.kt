package com.cestevez.a5.ui.movie.billboard.recyclerview

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cestevez.a5.data.model.MovieModel
import com.cestevez.a5.databinding.ThirdFragmentBinding

class MovieRecyclerViewAdapter (
    private val clickListener: MovieModel) : RecyclerView.Adapter<MovieRecyclerViewHolder>(){
    private val movies = ArrayList<MovieModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = ThirdFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie,clickListener)
    }

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }

}


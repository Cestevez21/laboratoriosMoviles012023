package com.cestevez.a5.ui.movie.billboard.recyclerview

import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.cestevez.a5.data.model.MovieModel

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(movie: MovieModel, clickListener: MovieModel){
        binding.titleTextView.text = movie.name
        binding.qualiticationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickLister{
            clickListener(movie)
        }

    }
}
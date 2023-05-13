package com.cestevez.a5.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cestevez.a5.R
import com.cestevez.a5.data.model.MovieModel
import com.cestevez.a5.databinding.BillboardFragmentBinding
import com.cestevez.a5.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.cestevez.a5.ui.movie.billboard.recyclerview.MovieRecyclerViewHolder
import com.cestevez.a5.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {


    private lateinit var recyclerViewMovies: RecyclerView
    private lateinit var adapter: MovieRecyclerViewAdapter

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: BillboardFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BillboardFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieViewModel.SetMovieFragment()
    }
    private fun showSelectedItem(movie: MovieModel){
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_firstFragment2_to_secondFragment)
    }
    private fun displayMovies(){
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        setRecyclerView(view)
        setViewModel()
        listeners()
    }

    private fun bind() {
        recyclerViewMovies = view?.findViewById(R.id.movies_recycle_view) as RecyclerView
    }

    private fun listeners(){

        binding.btnAddMovie.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_firstFragment2_to_thirdFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.moviesRecycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.moviesRecycleView.adapter = adapter
        displayMovies()
    }
    private fun setViewModel(){
        binding.viewmodel = movieViewModel
    }
}
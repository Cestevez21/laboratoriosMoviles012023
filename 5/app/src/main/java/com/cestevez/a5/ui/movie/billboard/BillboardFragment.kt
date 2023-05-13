package com.cestevez.a5.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.cestevez.a5.R
import com.cestevez.a5.data.model.MovieModel
import com.cestevez.a5.ui.movie.billboard.recyclerview.MovieRecyclerViewHolder
import com.cestevez.a5.ui.movie.viewmodel.MovieViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var buttonFirstFragment: FloatingActionButton
    private lateinit var cardViewFirst: CardView
    private lateinit var cardViewSecond: CardView
    private lateinit var adapter: MovieRecyclerViewHolder

    private lateinit var binding: FragmentBi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BillboardFragment.inflate(inflater,container,false)
        return binding.root
    }

    private fun showSelectedItem(movie: MovieModel){
        MovieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_firstFragment2_to_secondFragment)
    }
    private fun displayMovies(){
        adapter.setData(MovieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonFirstFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment2_to_thirdFragment)
        }
        cardViewFirst.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment2_to_secondFragment)
        }
    }

    private fun bind() {
        buttonFirstFragment = view?.findViewById(R.id.button_first_fragment) as FloatingActionButton
        cardViewFirst= view?.findViewById(R.id.card_view_first) as CardView
        cardViewSecond = view?.findViewById(R.id.card_view_second) as CardView
    }
}
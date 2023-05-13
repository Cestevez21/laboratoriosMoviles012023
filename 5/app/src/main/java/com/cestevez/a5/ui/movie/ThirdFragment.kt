package com.cestevez.a5.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.cestevez.a5.R
import com.cestevez.a5.data.model.MovieModel
import com.cestevez.a5.databinding.ThirdFragmentBinding
import com.cestevez.a5.ui.movie.viewmodel.MovieViewModel


class ThirdFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var buttonSubmit: Button
    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var calificationEditText: EditText


    private lateinit var binding: ThirdFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ThirdFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonSubmit.setOnClickListener{
            addMovie()
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment2)
        }

    }
    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }
    private fun bind() {
        buttonSubmit = view?.findViewById(R.id.submit_button) !!
        nameEditText = view?.findViewById(R.id.nameEditText) !!
        categoryEditText = view?.findViewById(R.id.categoryEditText) !!
        descriptionEditText = view?.findViewById(R.id.descriptionEditText) !!
        calificationEditText = view?.findViewById(R.id.calificationEditText) !!
    }

    private fun addMovie(){
        val name = nameEditText.toString()
        val categpry = categoryEditText.toString()
        val description = descriptionEditText.toString()
        val calification = calificationEditText.toString()

        val movie = MovieModel(name,categpry,description,calification)
        movieViewModel.addMovies(movie)

        findNavController().popBackStack()
    }

}
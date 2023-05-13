package com.cestevez.a5.ui.movie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cestevez.a5.R
import com.cestevez.a5.databinding.ThirdFragmentBinding


class SecondFragment : Fragment() {


    private lateinit var binding: SecondFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}
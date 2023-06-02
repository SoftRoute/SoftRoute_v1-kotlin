package com.example.softroute_v1.controller.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.softroute_v1.R
import com.example.softroute_v1.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private var _binding:FragmentWelcomeBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.btnClient.setOnClickListener {
            val action=WelcomeFragmentDirections.actionWelcomeFragmentToClientHomeFragment()
            findNavController().navigate(action)
        }

        binding.btnAdmin.setOnClickListener {
            val action=WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }
}
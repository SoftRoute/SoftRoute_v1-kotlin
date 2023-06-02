package com.example.softroute_v1.controller.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.AdminActivity
import com.example.softroute_v1.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view:View,savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.next.setOnClickListener {
            if(binding.inputUser.text.toString().isEmpty()){
                Toast.makeText(requireContext(),"Enter your name user", Toast.LENGTH_SHORT).show()
            }else if(binding.inputUser.text.toString().isNotEmpty()&&binding.inputPassword.text.toString().isNotEmpty())
            {
                val action=LoginFragmentDirections.actionLoginFragmentToAdminHomeFragment()
                findNavController().navigate(action)
            }
        }

        binding.btnSignUp.setOnClickListener{
            val action=LoginFragmentDirections.actionLoginFragmentToSignUp()
            findNavController().navigate(action)
        }

    }

}
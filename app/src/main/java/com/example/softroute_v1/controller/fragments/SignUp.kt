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
import com.example.softroute_v1.databinding.FragmentSignUpBinding


class SignUp : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.setOnClickListener {


            if (binding.inputName.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please enter you name", Toast.LENGTH_SHORT).show()
            }
            if (binding.inputPhone.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Please enter your phone", Toast.LENGTH_SHORT)
                    .show()
            }
            if (binding.inputEmail.text.toString().isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please enter your mail address",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if (binding.inputName.text.toString().isEmpty() && binding.inputPhone.text.toString()
                    .isEmpty() && binding.inputEmail.text.toString().isEmpty()
            ) {
                Toast.makeText(requireContext(), "Please fill the fields", Toast.LENGTH_SHORT)
                    .show()
            } else if (binding.inputName.text.toString()
                    .isNotEmpty() && binding.inputPhone.text.toString()
                    .isNotEmpty() && binding.inputEmail.text.toString().isNotEmpty()
            ) {

            }

        }

    }

}
package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.softroute_v1.R
import com.example.softroute_v1.databinding.FragmentAdminHomeBinding
import com.example.softroute_v1.databinding.FragmentClientHomeBinding


class AdminHomeFragment : Fragment() {

    private var _binding: FragmentAdminHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAdminHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Inflate the layout for this fragment
        val btnCreateShipment = binding.btnCreateShipment
        val btnViewShipment = binding.btnViewShipment
        val btnShipmentList = binding.btnShipmentList
        val btnComents = binding.btnComents
        val btnConsignessList=binding.btnConsigneesList
        val btnSendersList=binding.btnSenderList
        val btnDestinationList=binding.btnManageDestinations

        btnCreateShipment.setOnClickListener {
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminAddShipmentFragment()
            findNavController().navigate(action)
        }

        btnShipmentList.setOnClickListener {
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminShipmentListFragment()
            findNavController().navigate(action)
        }

        btnViewShipment.setOnClickListener {
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminTrackingFragment()
            findNavController().navigate(R.id.action_adminHomeFragment_to_adminTrackingFragment)
        }

        btnComents.setOnClickListener {
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminCommentsFragment()
            findNavController().navigate(action)
        }

        btnConsignessList.setOnClickListener{
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminConsigneesFragment()
            findNavController().navigate(action)
        }

        btnSendersList.setOnClickListener{
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminSendersListFragment()
            findNavController().navigate(action)
        }

        btnDestinationList.setOnClickListener {
            val action=AdminHomeFragmentDirections.actionAdminHomeFragmentToAdminDestinationListFragment()
            findNavController().navigate(action)
        }

        return view
    }



}
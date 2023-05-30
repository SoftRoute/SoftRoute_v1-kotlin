package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.softroute_v1.R


class AdminHomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_home, container, false)
        val btnCreateShipment = view.findViewById<Button>(R.id.btnCreateShipment)
        val btnViewShipment = view.findViewById<Button>(R.id.btnViewShipment)
        val btnShipmentList = view.findViewById<Button>(R.id.btnShipmentList)
        val btnComents = view.findViewById<Button>(R.id.btnComents)
        val btnConsignessList=view.findViewById<Button>(R.id.btnConsigneesList)
        val btnSendersList=view.findViewById<Button>(R.id.btnSenderList)

        btnCreateShipment.setOnClickListener {
            val fragment = AdminAddShipmentFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        }

        btnShipmentList.setOnClickListener {
            val fragment = AdminShipmentListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        }

        btnViewShipment.setOnClickListener {
            val fragment = AdminTrackingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        }

        btnComents.setOnClickListener {
            val fragment = AdminCommentsFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        }

        btnConsignessList.setOnClickListener{
            val fragment = AdminConsigneesFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        }

        btnSendersList.setOnClickListener{
            val fragment = AdminSendersListFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()
        }


        return view
    }



}
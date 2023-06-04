package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.softroute_v1.R


class AdminFreights: Fragment() {

    private lateinit var TypePayment: Spinner
    private lateinit var ShipmentType: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_admin_freights, container, false)
        TypePayment = view.findViewById(R.id.PaymentType)
        val values = arrayOf("Visa", "Contado", "Contraentrega")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, values)
        TypePayment.setAdapter(adapter)

        ShipmentType = view.findViewById(R.id.ShipmentType)
        val Shipmentvalues = arrayOf("electronico", "libros", "comida")
        val Shipmentadapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, Shipmentvalues)
        ShipmentType.setAdapter(Shipmentadapter)
        return view
    }
}
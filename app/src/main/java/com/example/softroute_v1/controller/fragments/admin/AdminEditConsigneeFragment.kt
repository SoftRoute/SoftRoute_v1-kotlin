package com.example.softroute_v1.controller.fragments.admin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.retrofitApiConsume.Consignees.model.Consignee

class AdminEditConsigneeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args: AdminEditConsigneeFragmentArgs by navArgs()
        val consignee: Consignee = args.consignee

        // Accede a los datos de consignee y realiza las operaciones necesarias
        Log.v("ConsigneeEdit","$consignee")

        return inflater.inflate(R.layout.fragment_admin_edit_consignee, container, false)
    }

}
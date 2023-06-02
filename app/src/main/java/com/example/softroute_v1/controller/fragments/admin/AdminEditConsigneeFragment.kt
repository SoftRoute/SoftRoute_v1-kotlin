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
import kotlin.math.log

class AdminEditConsigneeFragment : Fragment() {

    private val args: AdminEditConsigneeFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val consignee: Consignee = args.consignee

        println(consignee)

        return inflater.inflate(R.layout.fragment_admin_edit_consignee, container, false)
    }

}
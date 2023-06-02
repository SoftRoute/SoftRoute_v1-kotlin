package com.example.softroute_v1.controller.fragments.client
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.ClientActivity

import com.example.softroute_v1.controller.fragments.admin.AdminSendersListFragment
import com.example.softroute_v1.databinding.FragmentClientHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ClientHomeFragment : Fragment() {

    private var _binding: FragmentClientHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentClientHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Obtener las referencias a los botones utilizando el binding
        val buttonTracking = binding.btnTracking
        val buttonLeaveComment = binding.btnCreateComent

        buttonTracking.setOnClickListener {
            val action=ClientHomeFragmentDirections.actionClientHomeFragmentToClientTrackingFragment()
            findNavController().navigate(action)
/*            val clientActivity = activity as ClientActivity
            clientActivity.findViewById<BottomNavigationView>(R.id.bnvMenuClient)
                .menu.findItem(R.id.bottom_client_tracking).isChecked = true*/
        }

        buttonLeaveComment.setOnClickListener {
            val action=ClientHomeFragmentDirections.actionClientHomeFragmentToClientAddCommentFragment()
            findNavController().navigate(action)
/*            val clientActivity = activity as ClientActivity
            clientActivity.findViewById<BottomNavigationView>(R.id.bnvMenuClient)
                .menu.findItem(R.id.bottom_client_comment).isChecked = true*/
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
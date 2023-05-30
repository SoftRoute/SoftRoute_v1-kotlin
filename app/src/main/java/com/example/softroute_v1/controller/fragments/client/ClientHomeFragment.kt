package com.example.softroute_v1.controller.fragments.client
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.ClientActivity

import com.example.softroute_v1.controller.fragments.admin.AdminSendersListFragment
import com.example.softroute_v1.databinding.FragmentClientHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [ClientHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClientHomeFragment : Fragment() {

    private var _binding: FragmentClientHomeBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
            val fragment = ClientTrackingFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()

            val clientActivity = activity as ClientActivity
            clientActivity.findViewById<BottomNavigationView>(R.id.bnvMenuClient)
                .menu.findItem(R.id.bottom_client_tracking).isChecked = true
        }

        buttonLeaveComment.setOnClickListener {
            val fragment = ClientAddCommentFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit()

            val clientActivity = activity as ClientActivity
            clientActivity.findViewById<BottomNavigationView>(R.id.bnvMenuClient)
                .menu.findItem(R.id.bottom_client_comment).isChecked = true
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ClientHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClientHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
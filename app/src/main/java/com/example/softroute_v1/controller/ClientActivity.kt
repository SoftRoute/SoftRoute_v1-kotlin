package com.example.softroute_v1.controller


import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.softroute_v1.R

import com.example.softroute_v1.controller.fragments.client.ClientCommentListFragment
import com.example.softroute_v1.controller.fragments.client.ClientHomeFragment
import com.example.softroute_v1.controller.fragments.client.ClientTrackingFragment

import com.example.softroute_v1.databinding.ActivityClientBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ClientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientBinding

    private val onNavigationItemSelectedListener= BottomNavigationView.
    OnNavigationItemSelectedListener{item->navigateTo(item)}

    private fun navigateTo(item: MenuItem):Boolean{
        item.isChecked=true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment,getFragmentFor(item))
            .commit()>0
    }
    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId){
            R.id.bottom_client_home-> ClientHomeFragment()
            R.id.bottom_client_tracking-> ClientTrackingFragment()
            R.id.bottom_client_comment->ClientCommentListFragment()
            else -> ClientHomeFragment()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        binding = ActivityClientBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        val navView: BottomNavigationView =findViewById(R.id.bnvMenuClient )
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigateTo(navView.menu.findItem(R.id.bottom_client_home))


    }

}
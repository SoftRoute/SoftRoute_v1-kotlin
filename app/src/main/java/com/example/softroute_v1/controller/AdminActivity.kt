package com.example.softroute_v1.controller

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.softroute_v1.R
import com.example.softroute_v1.controller.fragments.admin.*
import com.example.softroute_v1.databinding.ActivityAdminBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class AdminActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityAdminBinding


    private val onNavigationItemSelectedListener= BottomNavigationView.
    OnNavigationItemSelectedListener{item->navigateTo(item)}

    private fun navigateTo(item: MenuItem):Boolean{
        item.isChecked=true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment,getFragmentFor(item))
            .commit()>0
    }
    private fun getFragmentFor(item:MenuItem): Fragment {
        return when(item.itemId){
            R.id.bottom_admin_home->AdminHomeFragment()
            R.id.bottom_admin_add_shipment->AdminAddShipmentFragment()
            R.id.bottom_admin_tracking->AdminTrackingFragment()
            else -> AdminHomeFragment()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        binding = ActivityAdminBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        val navView: BottomNavigationView=findViewById(R.id.bnvMenu )
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigateTo(navView.menu.findItem(R.id.bottom_admin_home))


  //HOME ADMIN
//        var userName=intent.getStringExtra(setData.name)
//        var userPhone=intent.getStringExtra(setData.phone)
//        var userEmail=intent.getStringExtra(setData.userEmail)
//
//        binding.homeName.text="holaaa ${userName}"
//        binding.btnComents.setOnClickListener { navigateToViewCommentsActivity() }
//
//        showSelected()


    }



    //admin home

//    private fun navigateToViewCommentsActivity(){
//        Log.i("Devs", "Navigating to ViewCommentsActivity")
//        val intent= Intent(this, ViewCommentsActivity::class.java)
//        startActivity(intent)
//    }


}






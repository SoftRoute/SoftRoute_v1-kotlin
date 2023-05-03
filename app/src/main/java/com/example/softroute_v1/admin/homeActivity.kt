package com.example.softroute_v1.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.softroute_v1.R

import com.example.softroute_v1.admin.navAdminHeader

import com.example.softroute_v1.databinding.ActivityHomeAdminBinding
import com.google.android.material.navigation.NavigationView

class homeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_admin)

        binding = ActivityHomeAdminBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        var userName=intent.getStringExtra(setData.name)
        var userPhone=intent.getStringExtra(setData.phone)
        var userEmail=intent.getStringExtra(setData.userEmail)

        binding.homeName.text="holaaa ${userName}"




        showSelected()
    }

    fun showSelected(){

        binding.btnCreateShipment.setOnClickListener {
            startActivity(Intent(this, AddShipment::class.java))
            finish()
        }




    }
}
package com.example.softroute_v1.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.softroute_v1.R

import com.example.softroute_v1.databinding.ActivityNavAdminHeaderBinding

class navAdminHeader : AppCompatActivity() {
    private lateinit var binding: ActivityNavAdminHeaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_admin_header)

        binding = ActivityNavAdminHeaderBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

//        binding.btnSignUp.setOnClickListener {
//            var userName=intent.getStringExtra(setData.name)
//            var userPhone=intent.getStringExtra(setData.phone)
//            var userEmail=intent.getStringExtra(setData.userEmail)
//
//            binding.headerName.text="holaaa ${userName}"
//            binding.headerEmail.text="sdajhkf ${userEmail}"
//
//            showNav()
//        }




    }

    fun showNav(){

    }
}
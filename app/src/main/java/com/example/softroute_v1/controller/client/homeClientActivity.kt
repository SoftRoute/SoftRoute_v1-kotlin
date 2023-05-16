package com.example.softroute_v1.controller.client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.softroute_v1.R

import com.example.softroute_v1.databinding.ActivityHomeClientBinding

class homeClientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeClientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_client)

        binding = ActivityHomeClientBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        val btnNext = findViewById<Button>(R.id.btnCreateComent)
        btnNext.setOnClickListener {
            val intent = Intent(this, CommentActivity::class.java)
            startActivity(intent)
        }

        showNext()


    }

    fun showNext(){
        binding.btnTracking.setOnClickListener{
            startActivity(Intent(this, TrackingActivity::class.java))
        }


    }
}
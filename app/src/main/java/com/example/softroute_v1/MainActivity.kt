package com.example.softroute_v1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.softroute_v1.client.homeClientActivity

import com.example.softroute_v1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        showNext()

    }

    fun showNext(){
        binding.btnAdmin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.btnClient.setOnClickListener{
            startActivity(Intent(this,homeClientActivity::class.java))
            finish()
        }

    }
}
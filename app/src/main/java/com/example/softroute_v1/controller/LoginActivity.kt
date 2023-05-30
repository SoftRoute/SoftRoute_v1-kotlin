package com.example.softroute_v1.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.softroute_v1.R

import com.example.softroute_v1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)


        showNext()
    }
    fun showNext(){

        binding.next.setOnClickListener{
            if(binding.inputUser.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your name user", Toast.LENGTH_SHORT).show()
            }else if(binding.inputUser.text.toString().isNotEmpty()&&binding.inputPassword.text.toString().isNotEmpty())
            {
                var intent=Intent(this, AdminActivity::class.java)
/*                intent.putExtra("${setData.name}",binding.inputUser.text.toString())*/
                startActivity(intent)
                finish()

            }

        }

        binding.btnSignUp.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
            finish()
        }


    }
}
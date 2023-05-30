package com.example.softroute_v1.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.softroute_v1.R

import com.example.softroute_v1.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        showSignUp()


    }

    private fun showSignUp(){
        binding.btnSignUp.setOnClickListener {
            if (binding.inputName.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter you name", Toast.LENGTH_SHORT).show()
            }
            if(binding.inputPhone.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your phone", Toast.LENGTH_SHORT).show()
            }
            if(binding.inputEmail.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your mail address", Toast.LENGTH_SHORT).show()
            }
            if(binding.inputName.text.toString().isEmpty()&&binding.inputPhone.text.toString().isEmpty()&&binding.inputEmail.text.toString().isEmpty()){
                Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show()
            }else if(binding.inputName.text.toString().isNotEmpty()&&binding.inputPhone.text.toString().isNotEmpty()&&binding.inputEmail.text.toString().isNotEmpty()){

                var intent=Intent(this, AdminActivity::class.java)


/*                intent.putExtra("${setData.name}",binding.inputName.text.toString())
                intent.putExtra("${setData.phone}",binding.inputPhone.text.toString())
                intent.putExtra("${setData.userEmail}",binding.inputEmail.text.toString())*/

                startActivity(intent)
                finish()

            }

        }

    }

}
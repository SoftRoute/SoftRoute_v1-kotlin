package com.example.softroute_v1.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.listRegister.ViewListRegisterActivity
import com.example.softroute_v1.databinding.ActivityAddShipmentBinding


class AddShipment : AppCompatActivity() {
    private lateinit var binding: ActivityAddShipmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shipment)
        binding = ActivityAddShipmentBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        binding.next.setOnClickListener { navigateToViewListRegisterActivity()}

            }
    private fun navigateToViewListRegisterActivity(){
        Log.i("Devs", "Navigating to ViewListRegisterActivity")
        val intent= Intent(this, ViewListRegisterActivity::class.java)
        startActivity(intent)
    }
}
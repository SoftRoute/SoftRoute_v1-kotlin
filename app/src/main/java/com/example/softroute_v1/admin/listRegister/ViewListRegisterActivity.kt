package com.example.softroute_v1.admin.listRegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.listRegister.adapter.ListRegisterAdapter
class ViewListRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_register)
        initRecyclerView()

    }
    private fun initRecyclerView(){
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerRegister)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=ListRegisterAdapter(ListRegisterProvider.ListRegisters)

    }
}






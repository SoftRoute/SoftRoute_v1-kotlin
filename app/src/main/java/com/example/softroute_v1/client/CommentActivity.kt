package com.example.softroute_v1.client

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.softroute_v1.R

class CommentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        val btnNext = findViewById<Button>(R.id.btListarComentario)
        btnNext.setOnClickListener {
            val intent = Intent(this, CommentDetalisActivity::class.java)
            startActivity(intent)
        }
    }
}
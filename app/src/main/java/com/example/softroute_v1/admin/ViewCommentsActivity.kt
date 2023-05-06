package com.example.softroute_v1.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.softroute_v1.R

class ViewCommentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_comments)

        val commentView = layoutInflater.inflate(R.layout.comment_card, null)
        val cardView = commentView.findViewById<CardView>(R.id.cardComment)

        // Agrega el cardView a la vista principal
        //val mainLayout = findViewById<ConstraintLayout>()
        //mainLayout.addView(commentView)
    }
}
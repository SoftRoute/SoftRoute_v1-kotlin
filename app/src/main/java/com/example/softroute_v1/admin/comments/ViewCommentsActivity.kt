package com.example.softroute_v1.admin.comments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.comments.adapter.CommentAdapter

class ViewCommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_comments)
        initRecyclerView()
        //val commentView = layoutInflater.inflate(R.layout.comment_card, null)
        //val cardView = commentView.findViewById<CardView>(R.id.cardComment)

        // Agrega el cardView a la vista principal
        //val mainLayout = findViewById<ConstraintLayout>()
        //mainLayout.addView(commentView)
    }
    private fun initRecyclerView(){
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerComment)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=CommentAdapter(CommentsProvider.commentsList)

    }
}
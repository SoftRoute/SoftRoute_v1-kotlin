package com.example.softroute_v1.admin.comments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.comments.Comment

class CommentAdapter(private val commentsList:List<Comment>) : RecyclerView.Adapter<CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return CommentViewHolder(layoutInflater.inflate(R.layout.comment_card,parent,false))
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val itemComment=commentsList[position]
        holder.render(itemComment)
    }


}
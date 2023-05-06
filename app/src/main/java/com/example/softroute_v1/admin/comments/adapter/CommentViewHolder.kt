package com.example.softroute_v1.admin.comments.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.comments.Comment

class CommentViewHolder(view: View):ViewHolder(view){

    val user=view.findViewById<TextView>(R.id.commentUserName)
    val titleComment=view.findViewById<TextView>(R.id.commentUserTitle)
    val contentComment=view.findViewById<TextView>(R.id.commentUserContent)


    fun render(comment:Comment){
        user.text=comment.user
        titleComment.text=comment.title
        contentComment.text=comment.content
    }
}
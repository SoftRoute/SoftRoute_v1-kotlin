package com.example.softroute_v1.admin.listRegister.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.softroute_v1.R
import com.example.softroute_v1.admin.listRegister.ListRegister
class ListRegisterAdapter(private val ListRegisters:List<ListRegister>) : RecyclerView.Adapter<ListRegisterViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRegisterViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ListRegisterViewHolder(layoutInflater.inflate(R.layout.activity_list_register,parent,false))
    }

    override fun getItemCount(): Int {
        return ListRegisters.size
    }

    override fun onBindViewHolder(holder: ListRegisterViewHolder, position: Int) {
        val itemComment=ListRegisters[position]
        holder.render(itemComment)
    }
}



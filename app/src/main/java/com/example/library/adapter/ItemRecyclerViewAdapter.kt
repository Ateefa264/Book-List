package com.example.library.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.library.R
import com.example.library.model.ItemModel

class ItemRecyclerViewAdapter(private val mList: List<ItemModel>): RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int) : ViewHolder{
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val itemModel=mList[position]
        holder.imageView.setImageResource(itemModel.Image)
        //holder.textView.text=itemModel.text
        holder.titleView.text = itemModel.title
        holder.authorView.text = itemModel.author

    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val imageView:ImageView=this.itemView.findViewById(R.id.itemIcon)
    //val textView:TextView = this.itemView.findViewById(R.id.itemTitle)
        val titleView: TextView = itemView.findViewById(R.id.itemTitle)
        val authorView: TextView = itemView.findViewById(R.id.author)
    }

}
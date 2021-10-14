package com.example.xmlformatassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*
import kotlinx.android.synthetic.main.row_item.view.*
import java.security.AccessControlContext

class RecyclerViewAdapter(val context: Context,val ids: ArrayList<Int>, val names: ArrayList<String>, val marks: ArrayList<Int>):
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val id = ids[position]
        val name = names[position]
        val mark = marks[position]
        holder.itemView.apply {
            idText.text = id.toString()
            nameText.text = name
            markText.text = mark.toString()
        }
    }

    override fun getItemCount(): Int = ids.size
}
package com.example.globalsolution.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globalsolution.R
import com.example.globalsolution.model.Beach

class BeachAdapter : RecyclerView.Adapter<BeachAdapter.ItemViewHolder>() {
    private var items = listOf<Beach>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<Beach>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_beach, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName = view.findViewById<TextView>(R.id.tvName)
        val textViewCity = view.findViewById<TextView>(R.id.tvCity)
        val textViewState = view.findViewById<TextView>(R.id.tvState)
        val button = view.findViewById<ImageButton>(R.id.btnDelete)
        fun bind(item: Beach) {
            textViewName.text = item.name
            textViewCity.text = item.city
            textViewState.text = item.state
            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}
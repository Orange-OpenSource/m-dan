package com.orange.ease.dan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.ListGuideViewHolderBinding
import com.orange.ease.dan.databinding.ListViewHolderBinding
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.model.DevelopmentGuide

class ListRecyclerViewAdapter(private val lists: List<AccessibilityEntity>, val clickListener: ListRecyclerViewClickListener, val context: Context) : RecyclerView.Adapter<ListRecyclerViewHolder>() {

    interface ListRecyclerViewClickListener {
        fun listItemClicked(row: AccessibilityEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerViewHolder {
        val binding =
            ListViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListRecyclerViewHolder, position: Int) {
        holder.binding.itemString.text = context.getString(lists[position].resTitle)
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}



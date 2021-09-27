package com.orange.ease.dan.ui.tools

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.ListGuideViewHolderBinding
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.model.Option

class ListOptionsRecyclerViewAdapter(private val lists: List<Option>, val clickListener: ListOptionRecyclerViewClickListener, val context: Context) : RecyclerView.Adapter<ListOptionsViewHolder>() {

    interface ListOptionRecyclerViewClickListener {
        fun listItemClicked(option: Option)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOptionsViewHolder {
        val binding =
            ListGuideViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListOptionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListOptionsViewHolder, position: Int) {
        holder.binding.itemString.text = context.getString(lists[position].title)
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}



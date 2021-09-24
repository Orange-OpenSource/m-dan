package com.orange.ease.dan.ui.developmentguide

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.ListGuideViewHolderBinding
import com.orange.ease.dan.model.DevelopmentGuide

class ListGuideRecyclerViewAdapter(private val lists: List<DevelopmentGuide>, val clickListener: ListGuideRecyclerViewClickListener, val context: Context) : RecyclerView.Adapter<ListGuideViewHolder>() {

    interface ListGuideRecyclerViewClickListener {
        fun listItemClicked(guide: DevelopmentGuide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGuideViewHolder {
        val binding =
            ListGuideViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListGuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListGuideViewHolder, position: Int) {
        holder.binding.itemString.text = context.getString(lists[position].titleRes)
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}



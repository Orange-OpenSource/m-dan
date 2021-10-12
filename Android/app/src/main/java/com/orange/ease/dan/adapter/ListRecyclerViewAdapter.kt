package com.orange.ease.dan.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.ListGuideViewHolderBinding
import com.orange.ease.dan.databinding.ListViewHolderBinding
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.model.Example

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
        val item = lists[position]
        holder.itemView.isEnabled = true
        holder.binding.itemString.text = context.getString(item.resTitle)
        holder.binding.apiItem.visibility = View.GONE
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(item)
        }

        if (item is Example && item.apiVersion!= null && item.apiVersion > Build.VERSION.SDK_INT) {
            holder.binding.apiItem.visibility = View.VISIBLE
            holder.itemView.isEnabled = false
            holder.binding.apiItem.text = context.getString(R.string.required_version, item.apiVersion)
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }


}



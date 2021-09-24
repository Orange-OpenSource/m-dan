package com.orange.ease.dan.ui.criteria.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.ListSelectionViewHolderBinding
import com.orange.ease.dan.model.Example

class ListExampleRecyclerViewAdapter(private val lists: List<Example>, val clickListener: ListExampleRecyclerViewClickListener, val context: Context) : RecyclerView.Adapter<ListExampleViewHolder>() {

    interface ListExampleRecyclerViewClickListener {
        fun listItemClicked(example: Example)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListExampleViewHolder {
        val binding =
            ListSelectionViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListExampleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListExampleViewHolder, position: Int) {
        holder.binding.itemString.text = context.getString(lists[position].title)
        holder.itemView.setOnClickListener {
            clickListener.listItemClicked(lists[position])
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}



package com.orange.ease.dan.ui.criteria.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.DetailsHeaderBinding
import com.orange.ease.dan.model.Criteria

class DetailsHeaderAdapter(val criteria: Criteria?, val context: Context) : RecyclerView.Adapter<DetailsHeaderAdapter.HeaderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding =
            DetailsHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.binding.headerCriteriaWhyDescription.text = criteria?.let { context.getString(it.resWhyDescription) }
        holder.binding.headerCriteriaRuleDescription.text = criteria?.let { context.getString(it.resRuleDescription) }
    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeaderViewHolder(val binding: DetailsHeaderBinding) : RecyclerView.ViewHolder(binding.root){}
}



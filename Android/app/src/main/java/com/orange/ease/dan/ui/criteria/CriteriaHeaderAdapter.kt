package com.orange.ease.dan.ui.criteria

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.HeaderBinding

class CriteriaHeaderAdapter() : RecyclerView.Adapter<CriteriaHeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding =
            HeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeaderViewHolder(val binding: HeaderBinding) : RecyclerView.ViewHolder(binding.root){}
}



package com.orange.ease.dan.ui.developmentguide

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.HeaderDevelopmentGuideBinding

class DevelopmentHeaderAdapter() : RecyclerView.Adapter<DevelopmentHeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding =
            HeaderDevelopmentGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeaderViewHolder(val binding: HeaderDevelopmentGuideBinding) : RecyclerView.ViewHolder(binding.root){}
}



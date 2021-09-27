package com.orange.ease.dan.ui.tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.databinding.HeaderDevelopmentGuideBinding
import com.orange.ease.dan.databinding.HeaderOptionsBinding

class OptionHeaderAdapter() : RecyclerView.Adapter<OptionHeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding =
            HeaderOptionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeaderViewHolder(val binding: HeaderOptionsBinding) : RecyclerView.ViewHolder(binding.root){}
}



package com.orange.ease.dan.adapter.header

import android.content.Intent
import android.provider.Settings
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.ease.dan.adapter.ListRecyclerViewAdapter
import com.orange.ease.dan.databinding.HeaderOptionsBinding
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.navigation.DialogActivity

class OptionHeaderAdapter(private val clickListener: OptionHeaderAdapter.HeaderOptionButtonClickListener) : RecyclerView.Adapter<OptionHeaderAdapter.HeaderViewHolder>() {

    interface HeaderOptionButtonClickListener {
        fun accessibilityButton()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding =
            HeaderOptionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.binding.buttonOptionsAxs.setOnClickListener { _ ->
            clickListener.accessibilityButton()
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

    class HeaderViewHolder(val binding: HeaderOptionsBinding) : RecyclerView.ViewHolder(binding.root){}
}



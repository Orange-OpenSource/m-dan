/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


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



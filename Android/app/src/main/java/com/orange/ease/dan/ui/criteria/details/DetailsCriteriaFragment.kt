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

package com.orange.ease.dan.ui.criteria.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.adapter.header.DetailsHeaderAdapter
import com.orange.ease.dan.adapter.ListRecyclerViewAdapter
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.model.Example
import com.orange.ease.dan.navigation.FragmentManagerActivity
import com.orange.ease.dan.viewmodel.CriteriaDetailsViewModel

class DetailsCriteriaFragment: Fragment(), ListRecyclerViewAdapter.ListRecyclerViewClickListener {

    private lateinit var binding: RecyclerViewFragmentBinding
    private lateinit var viewModel: CriteriaDetailsViewModel
    private lateinit var mContext : Context

    companion object {
        fun newInstance() = DetailsCriteriaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(CriteriaDetailsViewModel::class.java)
        initExample()
    }

    override fun onResume() {
        super.onResume()
        viewModel.criteria?.let {
            (activity as AppCompatActivity).supportActionBar?.title = getString(it.resTitle)
            (activity as AppCompatActivity).title = getString(it.resTitle)
        }
        (mContext as FragmentManagerActivity).setMenuActionVisibility(false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun initExample() {
        binding.listsRecyclerview.layoutManager = LinearLayoutManager(mContext)

        val headerAdapter = DetailsHeaderAdapter(viewModel.criteria, mContext)
        val recyclerViewAdapter =
            this.context?.let { ListRecyclerViewAdapter(viewModel.criteria!!.exampleList, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(row: AccessibilityEntity) {
        viewModel.setCurrentExample(row as Example)
        (activity as FragmentManagerActivity?)?.let {
            it.updateFragmentWithExample()
        }
    }
}



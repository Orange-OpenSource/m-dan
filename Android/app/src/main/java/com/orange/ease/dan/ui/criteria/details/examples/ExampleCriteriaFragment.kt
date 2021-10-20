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

package com.orange.ease.dan.ui.criteria.details.examples

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.ExampleFragLvl2Binding
import com.orange.ease.dan.data.repository.CriteriaRepository
import com.orange.ease.dan.navigation.FragmentManagerActivity
import com.orange.ease.dan.viewmodel.CriteriaDetailsViewModel

class ExampleCriteriaFragment: Fragment() {

    private lateinit var binding: ExampleFragLvl2Binding
    private lateinit var viewModel: CriteriaDetailsViewModel
    private lateinit var mContext : Context

    companion object {
        fun newInstance() = ExampleCriteriaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExampleFragLvl2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(CriteriaDetailsViewModel::class.java)
        viewModel.criteria = CriteriaRepository.getCurrentCriteria()
        initHeader()
        initExample()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun initHeader() {
        binding.textViewTitleExample.text = viewModel.getCurrentExample()?.let { it.detailsExample.getTitleRessource(mContext) }
        binding.textViewDescriptionExample.text = viewModel.getCurrentExample()?.let { it.detailsExample.getDescriptionRessource(mContext) }
    }

    private fun initExample() {
        viewModel.getCurrentExample()?.let {
            binding.frameLayoutExampleAxsYes.addView(it.detailsExample.getAccessibleExample(mContext))
            binding.frameLayoutExampleAxsNo.addView(it.detailsExample.getNotAccessibleExample(mContext))
            val examplesCount = viewModel.criteria?.exampleList?.size ?: 1
            val currentExampleCount = (viewModel.criteria?.exampleList?.indexOf(it) ?: 0) + 1
            val title = if (it.detailsExample.hasEmptyTitle()) "" else (getString(R.string.example) + " $currentExampleCount/$examplesCount")
            (activity as AppCompatActivity).supportActionBar?.title = title

            val useOption = it.detailsExample.useOption()
            val optionVisibility =  if (useOption) View.VISIBLE else View.GONE
            binding.viewOptionEnabled.visibility = optionVisibility
            binding.textViewOptionEnabled.text = it.detailsExample.getOptionRessource(mContext)
            (mContext as FragmentManagerActivity).setMenuActionVisibility(useOption)
        }
    }

}



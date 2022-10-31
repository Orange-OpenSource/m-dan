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

package com.orange.ease.dan.ui.tools

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.adapter.ListRecyclerViewAdapter
import com.orange.ease.dan.adapter.header.DevelopmentHeaderAdapter
import com.orange.ease.dan.adapter.header.TestHeaderAdapter
import com.orange.ease.dan.data.repository.DevelopmentGuideRepository
import com.orange.ease.dan.data.repository.OptionRepository
import com.orange.ease.dan.data.repository.TestGuideRepository
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.*
import com.orange.ease.dan.navigation.DialogActivity
import com.orange.ease.dan.ui.developmentguide.DetailsDevGuideActivity
import com.orange.ease.dan.ui.test.DetailsTestActivity
import com.orange.ease.dan.ui.tools.talkback.TalkbackOptionActivity
import com.orange.ease.dan.viewmodel.DevelopmentGuideViewModel
import com.orange.ease.dan.viewmodel.OptionsViewModel
import com.orange.ease.dan.viewmodel.TestGuideViewModel

class TestFragment: Fragment(), ListRecyclerViewAdapter.ListRecyclerViewClickListener {

    private lateinit var binding: RecyclerViewFragmentBinding
    //private lateinit var binding1: RecyclerViewFragmentBinding
    private lateinit var viewModel: TestGuideViewModel

    companion object {
        fun newInstance() = TestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)

        binding.listsRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        //binding1.listsRecyclerview.layoutManager = LinearLayoutManager(requireContext())


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(TestGuideViewModel::class.java)

        //Change DevelopmentGuideRepository by TestGuideRepository
        viewModel.listGuide = TestGuideRepository.getListOfGuide()
        //viewModel.listOtherGuide = TestGuideRepository.getListOfOtherGuide()

        val headerAdapter = TestHeaderAdapter()
        val recyclerViewAdapter =
            this.context?.let { ListRecyclerViewAdapter(viewModel.listGuide, this, it) }
        //val recyclerViewAdapter1 =
           //this.context?.let { ListRecyclerViewAdapter(viewModel.listOtherGuide, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }


    override fun listItemClicked(row: AccessibilityEntity) {
        TestGuideRepository.setCurrentGuide(row as TestGuide)
        val intent = Intent(activity, DetailsTestActivity::class.java)
        startActivity(intent)
    }


}



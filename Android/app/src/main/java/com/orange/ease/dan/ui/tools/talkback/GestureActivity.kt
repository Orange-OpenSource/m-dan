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

package com.orange.ease.dan.ui.tools.talkback

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.orange.ease.dan.adapter.GestureAdapter
import com.orange.ease.dan.databinding.ActivityTalkbackBinding
import com.orange.ease.dan.model.Gesture
import com.orange.ease.dan.data.repository.GestureRepository
import com.orange.ease.dan.viewmodel.GestureViewModel


class GestureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTalkbackBinding
    private lateinit var viewModel: GestureViewModel

    private lateinit var gestureAdapter: GestureAdapter

    private val gesturesObserver = Observer<List<Gesture>> { gestures ->
        gestureAdapter.setGestures(gestures)
        gestureAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTalkbackBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewPager()
        initViewModel()
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(GestureViewModel::class.java)
        viewModel.setListGesture(GestureRepository.getListOfGesture())
        configureLiveDataObservers()
    }

    private fun initViewPager() {
        gestureAdapter = GestureAdapter(this)
        binding.container.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.setCurrentPage(position)
            }
        })
        binding.container.adapter = gestureAdapter
    }

    private fun configureLiveDataObservers() {
        viewModel.getListGesture().observe(this, gesturesObserver)

        viewModel.isFirstPage().observe(this, Observer { isFirst ->
            binding.buttonPrevious.isEnabled = !isFirst
        })

        viewModel.isLastPage().observe(this, Observer { isLast ->
            binding.buttonNext.isEnabled = !isLast
        })
    }

    fun previous(view: View) {
        binding.container.currentItem = binding.container.currentItem - 1;
    }

    fun next(view: View) {
        binding.container.currentItem = binding.container.currentItem + 1;
    }
}
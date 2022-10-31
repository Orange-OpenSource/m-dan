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

package com.orange.ease.dan.ui.test

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.data.repository.TestGuideRepository
import com.orange.ease.dan.databinding.DetailsDevGuideActivityBinding
import com.orange.ease.dan.viewmodel.TestGuideDetailsViewModel

class DetailsTestActivity : AppCompatActivity() {

    private lateinit var binding: DetailsDevGuideActivityBinding

    private lateinit var viewModel: TestGuideDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsDevGuideActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(TestGuideDetailsViewModel::class.java)
        viewModel.guide = TestGuideRepository.getCurrentGuide()

        initView()
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

    private fun initView() {
        binding.textViewTitleLinksGuideDev.visibility = View.GONE
        binding.textViewContentLinksGuideDev.visibility = View.GONE

        val guide = viewModel.guide?.let { it } ?: return

        //holder.binding.headerCriteriaWhyDescription.text = criteria?.let { context.getString(it.resWhyDescription) }
        binding.textViewDescriptionContentGuideDev.text = guide?.let{ getString(guide.resDescription)}

        val img = guide.resImg1;
        if (img!=null) {
            binding.imgTestExemple.visibility = View.VISIBLE
            binding.imgTestExemple.setImageDrawable(img?.let { ContextCompat.getDrawable(this, it) })
        } else {
            //binding.imgTestExemple.visibility = View.GONE
        }
        binding.imgTestExemple.setImageDrawable(img?.let { ContextCompat.getDrawable(this, it) })

    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.guide?.let { getString(it.resTitle) }
        title = viewModel.guide?.let { getString(it.resTitle) }
    }
}



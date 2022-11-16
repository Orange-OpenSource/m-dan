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

package com.orange.ease.dan.ui.developmentguide

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.databinding.DetailsDevGuideActivityBinding
import com.orange.ease.dan.data.repository.DevelopmentGuideRepository
import com.orange.ease.dan.viewmodel.DevGuideDetailsViewModel

class DetailsDevGuideActivity : AppCompatActivity() {

    private lateinit var binding: DetailsDevGuideActivityBinding

    private lateinit var viewModel: DevGuideDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsDevGuideActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(DevGuideDetailsViewModel::class.java)
        viewModel.guide = DevelopmentGuideRepository.getCurrentGuide()

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

        binding.textViewDescriptionContentGuideDev.text = guide?.let{ getString(guide.resDescription)}
            //HtmlCompat.fromHtml(getString(guide.resDescription),  HtmlCompat.FROM_HTML_MODE_LEGACY)

        val strongLink = guide.resLink?.let {getString(it)} ?: return

        binding.textViewContentLinksGuideDev.text = strongLink
        binding.textViewTitleLinksGuideDev.visibility = View.VISIBLE
        binding.textViewContentLinksGuideDev.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.guide?.let { getString(it.resTitle) }
        title = viewModel.guide?.let { getString(it.resTitle) }
    }
}



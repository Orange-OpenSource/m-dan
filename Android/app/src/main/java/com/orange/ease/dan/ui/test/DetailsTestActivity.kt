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

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.data.repository.TestGuideRepository
import com.orange.ease.dan.databinding.DetailsDevGuideActivityBinding
import com.orange.ease.dan.model.TestGuide
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
        viewModel.guide = TestGuideRepository.getCurrentGuide() as TestGuide?

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

        val link = guide.resLink;
        if (link!=null) {
            binding.buttonDetailsWebview.visibility = View.VISIBLE
            binding.buttonDetailsWebview.setText(guide.resLink)
        }

    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.guide?.let { getString(it.resTitle) }
        title = viewModel.guide?.let { getString(it.resTitle) }
    }

    fun seeWebviewDetails(view: View) {
        startTuto()
    }

    private fun startTuto() {
        val openTutoActivity = Intent(Intent.ACTION_VIEW, Uri.parse("https://a11y-guidelines.orange.com/fr/web/"))
        startActivity(openTutoActivity)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)
    }
}



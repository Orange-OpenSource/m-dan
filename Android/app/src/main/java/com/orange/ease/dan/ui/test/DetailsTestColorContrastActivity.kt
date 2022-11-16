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
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.data.repository.TestGuideRepository
import com.orange.ease.dan.databinding.DetailsTestGuideActivityBinding
import com.orange.ease.dan.model.TestColorContrastGuide
import com.orange.ease.dan.viewmodel.TestGuideDetailsViewModel

class DetailsTestColorContrastActivity : AppCompatActivity() {

    private lateinit var binding: DetailsTestGuideActivityBinding

    private lateinit var viewModel: TestGuideDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsTestGuideActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(TestGuideDetailsViewModel::class.java)
        viewModel.guideColorContrastGuide = TestGuideRepository.getCurrentGuide() as TestColorContrastGuide?

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
        binding.textViewDescriptionContentPart3.visibility = View.VISIBLE
        binding.imgTestExample2.visibility = View.VISIBLE
        binding.textViewContentLinksGuideDev.visibility = View.GONE

        val guide = viewModel.guideColorContrastGuide?.let { it } ?: return
        binding.buttonGuideTester.setText(R.string.tb_scanner_guide_btn)
        binding.textViewDescriptionContentPart1.text = guide?.let{ getString(guide.resDescription1)}
        binding.textViewDescriptionContentPart2.text = guide?.let{ getString(guide.resDescription2)}
        binding.textViewDescriptionContentPart3.text = guide?.let{ getString(guide.resDescription3)}

        val img1 = guide.resImg1;
        if (img1!=null) {
            binding.imgTestExemple.visibility = View.VISIBLE
            binding.imgTestExemple.setImageDrawable(img1?.let { ContextCompat.getDrawable(this, it) })
        }
        val img2 = guide.resImg2
        if (img2!=null) {
            binding.imgTestExample2.visibility = View.VISIBLE
            binding.imgTestExample2.setImageDrawable(img2?.let { ContextCompat.getDrawable(this, it) })
        }

    }

    fun seeTalkback(view: View) {
        startTuto()
    }

    private fun startTuto() {

        val openTutoActivity = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.accessibility.auditor&pli=1"))
        startActivity(openTutoActivity)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)
    }

    override fun onResume() {
        super.onResume()
    }
}

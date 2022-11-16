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
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.data.repository.TestGuideRepository
import com.orange.ease.dan.databinding.DetailsTestGuideActivityBinding
import com.orange.ease.dan.model.TestTalkbackGuide
import com.orange.ease.dan.ui.tools.talkback.TalkbackOptionActivity
import com.orange.ease.dan.viewmodel.TestGuideDetailsViewModel

class DetailsTestTalkbackActivity : AppCompatActivity() {

    private lateinit var binding: DetailsTestGuideActivityBinding

    private lateinit var viewModel: TestGuideDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsTestGuideActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(TestGuideDetailsViewModel::class.java)
        viewModel.guideTalkaback = TestGuideRepository.getCurrentGuide() as TestTalkbackGuide?

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
        //binding.textViewTitleLinksGuideDev.visibility = View.GONE
        binding.textViewContentLinksGuideDev.visibility = View.GONE

        val guide = viewModel.guideTalkaback?.let { it } ?: return
        binding.buttonGuideTester.setText(R.string.tb_talback_guide_btn)
        binding.textViewDescriptionContentPart1.text = guide?.let{ getString(guide.resDescription1)}
        val imgExample = guide.resImg;
        binding.textViewDescriptionContentPart2.text = guide?.let{ getString(guide.resDescription2)}

        if (imgExample!=null) {
            binding.imgTestExemple.visibility = View.VISIBLE
            binding.imgTestExemple.setImageDrawable(imgExample?.let { ContextCompat.getDrawable(this, it) })
        }

    }

    fun seeTalkback(view: View) {
        startTuto()
    }

    private fun startTuto() {
        val openTutoActivity = Intent(this, TalkbackOptionActivity::class.java)
        startActivity(openTutoActivity)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)
    }

    override fun onResume() {
        super.onResume()

    }
}

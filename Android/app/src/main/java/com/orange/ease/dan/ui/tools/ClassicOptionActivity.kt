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

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.databinding.OptionsTemplateBinding
import com.orange.ease.dan.model.OptionClassic
import com.orange.ease.dan.data.repository.OptionRepository
import com.orange.ease.dan.viewmodel.ClassicOptionViewModel

class ClassicOptionActivity : AppCompatActivity() {

    private lateinit var binding: OptionsTemplateBinding
    private lateinit var viewModel: ClassicOptionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OptionsTemplateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(ClassicOptionViewModel::class.java)
        viewModel.option = OptionRepository.getCurrentOption() as OptionClassic

        initView()
        setupToolbar()
    }

    private fun initView() {
        val option = viewModel.option?.let { it } ?: return
        binding.optionDescription.text = getString((option as OptionClassic).description)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.option?.let { getString(it.resTitle) }
    }
}



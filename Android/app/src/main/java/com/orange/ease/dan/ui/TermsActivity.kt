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

package com.orange.ease.dan.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orange.ease.dan.databinding.ActivityTermsBinding
import java.util.*

class TermsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        val view = binding.root
        setupToolbar()
        setContentView(view)

        val webView = binding.webViewTerms
        if (Locale.getDefault().language == "fr") {
            webView.loadUrl("file:///android_asset/terms-fr.html")
        } else {
            webView.loadUrl("file:///android_asset/terms-en.html")
        }

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

}



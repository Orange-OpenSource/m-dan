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
import com.orange.ease.dan.databinding.ActivityLegalNoticeBinding
import com.orange.ease.dan.databinding.ActivityTermsBinding
import java.util.*

class LegalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLegalNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLegalNoticeBinding.inflate(layoutInflater)
        val view = binding.root
        setupToolbar()
        setContentView(view)

        val webView = binding.webViewLegalNotice
        if (Locale.getDefault().language == "fr") {
            webView.loadUrl("file:///android_asset/legal_notice_fr.html")
        } else {
            webView.loadUrl("file:///android_asset/legal_notice_en.html")
        }

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

}



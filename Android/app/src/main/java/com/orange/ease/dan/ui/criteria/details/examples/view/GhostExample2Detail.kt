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

package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.orange.ease.dan.databinding.Exghost11FragBinding
import com.orange.ease.dan.navigation.FragmentManagerActivity

class GhostExample2Detail: Fragment() {

    private lateinit var binding: Exghost11FragBinding
    private lateinit var mContext : Context
    private var mContent: String = ""

    companion object {
        fun newInstance() = GhostExample2Detail()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Exghost11FragBinding.inflate(inflater, container, false)
        var bundle : Bundle ? = arguments
        mContent = bundle?.getString("content") ?: ""
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.textViewContent.announceForAccessibility(mContent)
        binding.textViewContent.text = mContent
        binding.btnok.setOnClickListener{
            (context as FragmentManagerActivity?)?.let {
                it.back()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

}


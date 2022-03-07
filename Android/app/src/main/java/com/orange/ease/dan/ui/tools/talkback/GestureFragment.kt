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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.FragmentGestureBinding
import com.orange.ease.dan.model.Gesture
import com.orange.ease.dan.viewmodel.GestureViewModel

class GestureFragment: Fragment() {

    private lateinit var binding: FragmentGestureBinding
    private lateinit var viewModel: GestureViewModel

    private lateinit var gesture: Gesture
    private var currentStep = 0
    private var nbStep = 0

    companion object {
        fun newInstance() = GestureFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGestureBinding.inflate(inflater, container, false)
        updateContent()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(GestureViewModel::class.java)
    }

    private fun updateContent() {
        binding.imgViewGesture.setImageResource(gesture.resImage)
        binding.textViewGestureDescritpion.text = getString(gesture.resTitle)
        binding.textViewGestureSubDescription.text = getString(gesture.resDescription)
        binding.textViewStep.text = "$currentStep/$nbStep"
        binding.textViewStep.contentDescription = getString(R.string.step) + " $currentStep " + getString(R.string.on) + " $nbStep"
    }

    public fun setGestureValues(gesture: Gesture, currentStep: Int, nbStep: Int) {
        this.gesture = gesture
        this.currentStep = currentStep
        this.nbStep = nbStep
    }
}
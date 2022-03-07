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


package com.orange.ease.dan.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.orange.ease.dan.model.Gesture
import com.orange.ease.dan.ui.tools.talkback.GestureFragment

class GestureAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private var gestures: List<Gesture> = listOf()

    override fun getItemCount(): Int = gestures.size

    override fun createFragment(position: Int): Fragment {
        val fragment = GestureFragment()
        fragment.setGestureValues(gestures[position], position+1, gestures.size)
        return fragment
    }

    public fun setGestures(gestures: List<Gesture>) {
        this.gestures = gestures
    }
}
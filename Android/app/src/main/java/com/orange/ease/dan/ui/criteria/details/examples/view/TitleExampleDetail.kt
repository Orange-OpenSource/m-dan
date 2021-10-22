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
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.ui.criteria.details.examples.ExampleCriteriaFragment

class TitleExampleDetail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
        val texteExampleAccessible = TextView(context)
        texteExampleAccessible.text = context.getString(R.string.criteria_title_ex1_axs)
        val lyaxs = LinearLayout(context)
        val scale: Float = context.resources.displayMetrics.density
        lyaxs.setPadding((15 * scale + 0.5f).toInt(), 0, (15 * scale + 0.5f).toInt(), 0)
        lyaxs.orientation = LinearLayout.VERTICAL
        lyaxs.addView(texteExampleAccessible)
        return lyaxs
    }

    override fun getNotAccessibleExample(context: Context): View {
        val texteExampleNotAccessible = TextView(context)
        texteExampleNotAccessible.text = context.getString(R.string.criteria_title_ex1_noaxs)
        val lyaxs = LinearLayout(context)
        val scale: Float = context.resources.displayMetrics.density
        lyaxs.setPadding((15 * scale + 0.5f).toInt(), 0, (15 * scale + 0.5f).toInt(), 0)
        lyaxs.orientation = LinearLayout.VERTICAL
        lyaxs.addView(texteExampleNotAccessible)
        return lyaxs
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_title_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_title_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_title_ex1_description)
    }

    override fun hasEmptyTitle(): Boolean {
        return true
    }
}



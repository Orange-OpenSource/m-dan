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
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class GroupExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.grouped_elements, null)
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.ungrouped_elements, null)
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.example_group_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.getString(R.string.example_group_title)
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.example_group_desc)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



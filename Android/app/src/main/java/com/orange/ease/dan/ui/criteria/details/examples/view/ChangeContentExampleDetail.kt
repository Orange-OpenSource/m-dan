
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
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ChangeContentExampleDetail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val accessibleView = inflater.inflate(R.layout.btnreload, null) as LinearLayout
        val ly = LinearLayout(context)
        ly.orientation = LinearLayout.VERTICAL
        ly.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

        val buttonReloadYes = accessibleView.findViewById<Button>(R.id.imgButtonReload)
        buttonReloadYes.contentDescription =
            context.getString(R.string.criteria_contentchange_ex1_majwifireload)
        buttonReloadYes.setOnClickListener {
            ly.removeAllViewsInLayout()
            val mItemsWifiList =
                context.resources.getStringArray(R.array.criteria_contentchange_ex1_list_wifi2)
            for (network in mItemsWifiList) {
                val mFakeListView =
                    inflater.inflate(R.layout.list_item_content_change, null) as LinearLayout
                (mFakeListView.findViewById<View>(R.id.textCategory) as TextView).text =
                    network
                ly.addView(mFakeListView)
            }
            ly.addView(accessibleView)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                it.announceForAccessibility(context.getString(R.string.criteria_contentchange_ex1_announce))
            }

        }

        val mItemsWifiList = context.resources.getStringArray(R.array.criteria_contentchange_ex1_list_wifi)
        for (network in mItemsWifiList) {
            val mFakeListView =
                inflater.inflate(R.layout.list_item_content_change, null) as LinearLayout
            mFakeListView.findViewById<TextView>(R.id.textCategory).text =
                network
            ly.addView(mFakeListView)
        }
        ly.addView(accessibleView)
        return ly
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.btnreload, null) as LinearLayout

        val ly2 = LinearLayout(context)
        ly2.orientation = LinearLayout.VERTICAL
        ly2.layoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

        val buttonReloadNo = notAccessibleView.findViewById<Button>(R.id.imgButtonReload)
        buttonReloadNo.contentDescription =
            context.getString(R.string.criteria_contentchange_ex1_majwifireload)
        buttonReloadNo.setOnClickListener {
            ly2.removeAllViewsInLayout()
            val mItemsWifiList =
                context.resources.getStringArray(R.array.criteria_contentchange_ex1_list_wifi2)
            for (network in mItemsWifiList) {
                val mFakeListView =
                    inflater.inflate(R.layout.list_item_content_change, null) as LinearLayout
                mFakeListView.findViewById<TextView>(R.id.textCategory).text =
                    network
                ly2.addView(mFakeListView)
            }
            ly2.addView(notAccessibleView)
        }

        val mItemsWifiList = context.resources.getStringArray(R.array.criteria_contentchange_ex1_list_wifi)
        for (network in mItemsWifiList) {
            val mFakeListView =
                inflater.inflate(R.layout.list_item_content_change, null) as LinearLayout
            mFakeListView.findViewById<TextView>(R.id.textCategory).text =
                network
            ly2.addView(mFakeListView)
        }

        ly2.addView(notAccessibleView)
        return ly2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_contentchange_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_contentchange_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_contentchange_ex1_description)
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }

    override fun useOption(): Boolean {
        return true
    }
}



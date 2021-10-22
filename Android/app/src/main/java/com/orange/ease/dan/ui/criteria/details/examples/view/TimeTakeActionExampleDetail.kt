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
import android.view.accessibility.AccessibilityManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample


class TimeTakeActionExampleDetail: AccessibilityDetailsExample() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnYes = accessibleView.findViewById<Button>(R.id.btngeneric)
        btnYes.text = context.getString(R.string.axsactivated)
        btnYes.setOnClickListener {
            val accessibilityManager = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as
                    android.view.accessibility.AccessibilityManager
            val snackbar = Snackbar
                .make(accessibleView, R.string.snackbar_title_take_action, accessibilityManager.getRecommendedTimeoutMillis(2000, AccessibilityManager.FLAG_CONTENT_CONTROLS))
                .setAction(R.string.snackbar_button_take_action) { // Show another Snackbar.
                    val toaster =
                        Toast.makeText(context, R.string.toast_message_take_action, accessibilityManager.getRecommendedTimeoutMillis(2000, AccessibilityManager.FLAG_CONTENT_TEXT))
                    toaster.show()
                }
                .setBackgroundTint(context.resources.getColor(R.color.primary_dark))
                .setActionTextColor(context.resources.getColor(R.color.accent))
                .setTextColor(context.resources.getColor(R.color.white))

            snackbar.show()
        }
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnNo = notAccessibleView.findViewById<Button>(R.id.btngeneric)
        btnNo.text = context.getString(R.string.axsdisabled)
        btnNo.setOnClickListener {
            val snackbar = Snackbar
                .make(notAccessibleView, R.string.snackbar_title_not_take_action, 2000)
                .setAction(R.string.snackbar_button_take_action) { // Show another Snackbar.
                    val toaster =
                        Toast.makeText(context, R.string.toast_message_take_action, Toast.LENGTH_SHORT)
                    toaster.show()
                }
                .setBackgroundTint(context.resources.getColor(R.color.primary_dark))
                .setActionTextColor(context.resources.getColor(R.color.accent))
                .setTextColor(context.resources.getColor(R.color.white))
            snackbar.show()
        }
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_timetotakeaction_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.getString(R.string.criteria_timetotakeaction_cell)
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_timetotakeaction_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.options_timetotakeaction_title)
    }
}



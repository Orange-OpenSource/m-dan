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
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ClickZoneExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val myViewAxsYes = inflater.inflate(R.layout.exclickzone1_frag_lvl2, null) as LinearLayout

        val tb = myViewAxsYes.findViewById<TableRow>(R.id.tableRow)

        val ibYes = myViewAxsYes.findViewById<View>(R.id.imageButtonplay)
        val titlemusic = myViewAxsYes.findViewById<TextView>(R.id.textView30)
        ibYes.contentDescription =
            context.getString(R.string.criteria_clickarea_ex1_play).toString() + " " + titlemusic.text
        ibYes.isFocusable = false
        tb.setContentDescription(
            context.getString(R.string.criteria_clickarea_ex1_music).toString() + " " + titlemusic.text + " " + context.getString(
                R.string.criteria_clickarea_ex1_author
            ) + " " + (myViewAxsYes.findViewById<View>(R.id.textView31) as TextView).text
        )

        ibYes.setOnClickListener {
            Toast.makeText(
                context,
                context.getString(R.string.criteria_clickarea_ex1_success),
                Toast.LENGTH_SHORT
            ).show()
        }

        return myViewAxsYes
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val myViewAxsNo = inflater.inflate(R.layout.exclickzone1_frag_lvl2, null) as LinearLayout
        val scale: Float = context.resources.displayMetrics.density

        val titlemusic = myViewAxsNo.findViewById<TextView>(R.id.textView30)
        val authormusic = myViewAxsNo.findViewById<TextView>(R.id.textView31)

        val ibNo = myViewAxsNo.findViewById<ImageButton>(R.id.imageButtonplay)
        ibNo.background =
            ContextCompat.getDrawable(context, R.drawable.play_bad_button_selector)
        val layoutParams =
            LinearLayout.LayoutParams((12 * scale + 0.5f).toInt(), (12 * scale + 0.5f).toInt())
        layoutParams.gravity = Gravity.CENTER
        ibNo.layoutParams = layoutParams
        ibNo.contentDescription =
            context.getString(R.string.criteria_clickarea_ex1_play).toString() + " " + titlemusic.text
        ibNo.isFocusable = false
        val tbNo = myViewAxsNo.findViewById<TableRow>(R.id.tableRow)
        tbNo.contentDescription =
            context.getString(R.string.criteria_clickarea_ex1_music).toString() + " " + titlemusic.text + " " + context.getString(
                R.string.criteria_clickarea_ex1_author
            ) + " " + authormusic.text
        ibNo.setOnClickListener {
            Toast.makeText(
                context,
                context.getString(R.string.criteria_clickarea_ex1_success),
                Toast.LENGTH_SHORT
            ).show()
        }
        return myViewAxsNo
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_clickarea_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_clickarea_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_clickarea_ex1_description)
    }

    override fun useOption(): Boolean {
        return false
    }

    override fun getOptionRessource(context: Context): String? {
        return null
    }
}



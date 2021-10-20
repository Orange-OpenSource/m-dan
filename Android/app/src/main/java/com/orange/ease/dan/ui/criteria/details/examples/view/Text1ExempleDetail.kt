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
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import java.text.SimpleDateFormat
import java.util.*

class Text1ExempleDetail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.extxt1_frag, null) as LinearLayout

        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(context.getString(R.string.date_format), Locale.getDefault())
        val date = sdf.format(c.time)

        val monthName = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())

        val ex1 = accessibleView.findViewById<TextView>(R.id.ex1txt1)

        ex1.text = date
        ex1.contentDescription =
            c[Calendar.DAY_OF_MONTH].toString() + " " + monthName + " " + c[Calendar.YEAR] + " , " + (c[Calendar.HOUR] + 12) + " " + context.getString(
                R.string.heure
            ) + " " + c[Calendar.MINUTE]

        accessibleView.findViewById<View>(R.id.ex2txt1).contentDescription =
            context.getString(R.string.criteria_alt_ex1_cd_txt1)
        accessibleView.findViewById<View>(R.id.ex3txt1).contentDescription =
            context.getString(R.string.criteria_alt_ex1_cd_txt2)
        accessibleView.findViewById<View>(R.id.ex4txt1).contentDescription =
            context.getString(R.string.criteria_alt_ex1_cd_txt3)

        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.extxt1_frag, null) as LinearLayout
        notAccessibleView.removeView(notAccessibleView.findViewById(R.id.ex3txt1))

        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(context.getString(R.string.date_format), Locale.getDefault())
        val date = sdf.format(c.time)

        val ex1AxsNo = notAccessibleView.findViewById<TextView>(R.id.ex1txt1)
        ex1AxsNo.text = date
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_alt_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex1_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



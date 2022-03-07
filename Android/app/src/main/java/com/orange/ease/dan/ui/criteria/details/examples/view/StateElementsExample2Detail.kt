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
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import com.orange.ease.dan.R
import com.orange.ease.dan.adapter.ArrayAdapterWithCD
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.view.NonScrollableListView

class StateElementsExample2Detail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
        val scale: Float = context.resources.displayMetrics.density
        val dpAsPixels = (15 * scale + 0.5f).toInt() //padding de 15dp

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val items: Array<String> =
            context.resources.getStringArray(R.array.criteria_stateelement_ex2_list)
        val aaAxs = ArrayAdapterWithCD(
            context,
            R.layout.simple_list_item_text,
            R.id.textCategory,
            items
        )

        val lvaxsYes: ListView =
            inflater.inflate(R.layout.exstateelements2_frag, null) as NonScrollableListView
        lvaxsYes.choiceMode = AbsListView.CHOICE_MODE_SINGLE
        lvaxsYes.adapter = aaAxs
        lvaxsYes.onItemClickListener =
            OnItemClickListener { parent, view, position, _ ->
                if (!view.isSelected) {
                    view.isSelected = true
                    for (i in 0 until parent.count) {
                        val parentView = parent.getChildAt(i) as RelativeLayout
                        val descTextView =
                            parentView.findViewById<TextView>(R.id.textCategory)
                        descTextView.contentDescription =
                            descTextView.text.toString() + ", " + context.getString(R.string.not) + " " + context.getString(
                                R.string.selected
                            )
                    }
                    val parentViewSelected = parent.getChildAt(position) as RelativeLayout
                    val myTextViewSelected =
                        parentViewSelected.findViewById<TextView>(R.id.textCategory)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        myTextViewSelected.contentDescription = myTextViewSelected.text
                    } else { //LOLLIPOP_MR1 -
                        myTextViewSelected.contentDescription =
                            myTextViewSelected.text.toString() + " " + context.getString(R.string.selected)
                    }
                } else {
                    view.isSelected = false
                    val parentViewSelected = parent.getChildAt(position) as RelativeLayout
                    val myTextViewSelected =
                        parentViewSelected.findViewById<TextView>(R.id.textCategory)
                    myTextViewSelected.contentDescription =
                        myTextViewSelected.text.toString() + ", " + context.getString(R.string.not) + " " + context.getString(
                            R.string.selected
                        )
                }
            }

        val exAxsDescription = TextView(context)
        exAxsDescription.text = context.getString(R.string.criteria_stateelement_ex2_axsDesc)
        exAxsDescription.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels)

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val lyAxs = LinearLayout(context)
        lyAxs.orientation = LinearLayout.VERTICAL
        lyAxs.layoutParams = layoutParams
        lyAxs.addView(exAxsDescription)
        lyAxs.addView(lvaxsYes)

        return lyAxs
    }

    override fun getNotAccessibleExample(context: Context): View {
        val scale: Float = context.resources.displayMetrics.density
        val dpAsPixels = (15 * scale + 0.5f).toInt() //padding de 15dp

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val items: Array<String> =
            context.getResources().getStringArray(R.array.criteria_stateelement_ex2_list)

        val aaNotAxs = ArrayAdapter(
            context,
            R.layout.simple_list_item_text,
            R.id.textCategory,
            items
        )

        val lvaxsNo: ListView =
            inflater.inflate(R.layout.exstateelements2_frag, null) as NonScrollableListView
        lvaxsNo.choiceMode = AbsListView.CHOICE_MODE_SINGLE
        lvaxsNo.adapter = aaNotAxs

        val exNotAxsDescription = TextView(context)
        exNotAxsDescription.text = context.getString(R.string.criteria_stateelement_ex2_notAxsDesc)
        exNotAxsDescription.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels)

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val lyNotAxs = LinearLayout(context)
        lyNotAxs.orientation = LinearLayout.VERTICAL
        lyNotAxs.layoutParams = layoutParams
        lyNotAxs.addView(exNotAxsDescription)
        lyNotAxs.addView(lvaxsNo)

        return lyNotAxs
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_stateelement_ex2_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_stateelement_list)[1]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_stateelement_ex2_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    fun getViewByPosition(pos: Int, listView: ListView): View? {
        val firstListItemPosition = listView.firstVisiblePosition
        val lastListItemPosition = firstListItemPosition + listView.childCount - 1
        return if (pos < firstListItemPosition || pos > lastListItemPosition) {
            listView.adapter.getView(pos, null, listView)
        } else {
            val childIndex = pos - firstListItemPosition
            listView.getChildAt(childIndex)
        }
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



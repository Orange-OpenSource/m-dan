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
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.ChildItem
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.GroupItem
import com.orange.ease.dan.data.ExpandableListDataPumpRepository
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.utils.Utils
import com.orange.ease.idunnololz.widgets.AnimatedExpandableListView
import java.util.*

class StandardComponentExempleDetail: AccessibilityDetailsExample {


    private var mExpandableListViewAxsMore: ExpandableListView? = null
    private var mExpandableListView: AnimatedExpandableListView? = null
    private var mExpandableListAdapterMore: ExpandableListAdapter? = null
    private var mExpandableListAdapter: CustomExpandableListViewAdapter? = null
    private var mExpandableListTitle: List<String>? = null
    private var mExpandableListDetail: HashMap<String, List<String>>? = null

    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.exstandardcomponent1_frag, null) as LinearLayout

        mExpandableListViewAxsMore =
            accessibleView.findViewById<ExpandableListView>(R.id.expandableListView)
        mExpandableListDetail = ExpandableListDataPumpRepository.getData(context)
        mExpandableListTitle = (mExpandableListDetail as HashMap<String, MutableList<String>>?)?.keys?.toList()
        mExpandableListAdapterMore = com.orange.ease.dan.adapter.ExpandableListAdapter(
            context,
            mExpandableListTitle,
            mExpandableListDetail,
            true
        )
        mExpandableListViewAxsMore!!.setAdapter(mExpandableListAdapterMore)
        Utils.setListViewHeightBasedOnItems(mExpandableListViewAxsMore)
        mExpandableListViewAxsMore!!.setOnGroupExpandListener {
            Utils.setListViewHeightBasedOnItems(
                mExpandableListViewAxsMore
            )
        }

        mExpandableListViewAxsMore!!.setOnGroupCollapseListener {
            Utils.setListViewHeightBasedOnItems(
                mExpandableListViewAxsMore
            )
        }
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.exstateelmts3_frag, null) as LinearLayout

        val items: MutableList<GroupItem> = ArrayList()

        for (i in 1..2) {
            val item = GroupItem()
            item.title = context.getString(R.string.criteria_stateelement_ex3_grp) + i
            for (j in 0 until i) {
                val child = ChildItem()
                child.title = context.getString(R.string.criteria_stateelement_ex3_item) + j
                child.hint = "lorem ipsum"
                item.addItem(child)
            }
            items.add(item)
        }

        mExpandableListAdapter = CustomExpandableListViewAdapter(context)
        mExpandableListAdapter!!.setData(items)

        mExpandableListView =
            notAccessibleView.findViewById<AnimatedExpandableListView>(R.id.expandableListView)
        mExpandableListView!!.setAdapter(mExpandableListAdapter)

        Utils.setListViewHeightBasedOnItems(mExpandableListView)

        mExpandableListView!!.setOnGroupClickListener { _, _, groupPosition, _ ->
            if (mExpandableListView!!.isGroupExpanded(groupPosition)) {
                mExpandableListView!!.collapseGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mExpandableListView)
            } else {
                mExpandableListView!!.expandGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mExpandableListView)
            }
            true
        }
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_standardcomponent_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_scroll_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_standardcomponent_ex1_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



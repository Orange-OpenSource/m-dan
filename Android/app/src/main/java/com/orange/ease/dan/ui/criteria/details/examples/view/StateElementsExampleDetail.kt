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
import android.widget.TabHost
import android.widget.TabHost.OnTabChangeListener
import android.widget.TabHost.TabSpec
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class StateElementsExampleDetail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.exstateelmts1_frag, null) as LinearLayout


        //HostYesAxs
        val tabslabs = arrayOfNulls<String>(2)
        tabslabs[0] = context.getString(R.string.criteria_stateelement_ex1_public)
        tabslabs[1] = context.getString(R.string.criteria_stateelement_ex1_private)
        val hostYes = initTabHost(accessibleView, context)
        hostYes?.setOnTabChangedListener(TabHostListener(hostYes, tabslabs))
        setContentDescription(hostYes, tabslabs)

        for (i in 0 until hostYes!!.tabWidget.childCount) hostYes?.tabWidget?.getChildAt(i)!!.setBackgroundResource(R.drawable.tab_selector)

        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.exstateelmts1_frag, null) as LinearLayout

        val hostNo = initTabHost(notAccessibleView, context)
        for (i in 0 until hostNo!!.tabWidget.childCount) hostNo.tabWidget.getChildAt(i)
            .setBackgroundResource(R.drawable.tab_selector)

        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_stateelement_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_stateelement_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_stateelement_ex1_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    private fun initTabHost(view: LinearLayout, context: Context): TabHost? {
        val host = view.findViewById<View>(R.id.tabHost) as TabHost
        host.setup()
        //Tab 1
        var spec: TabSpec
        spec = host.newTabSpec(context.getString(R.string.criteria_stateelement_ex1_public))
        spec.setContent(view.findViewById<View>(R.id.tab1).id)
        spec.setIndicator(context.getString(R.string.criteria_stateelement_ex1_public))
        host.addTab(spec)
        //Tab 2
        spec = host.newTabSpec(context.getString(R.string.criteria_stateelement_ex1_private))
        spec.setContent(view.findViewById<View>(R.id.tab2).id)
        spec.setIndicator(context.getString(R.string.criteria_stateelement_ex1_private))
        host.addTab(spec)
        return host
    }

    private class TabHostListener(
        private val mTabHost: TabHost,
        private val mTabsLabel: Array<String?>
    ) :
        OnTabChangeListener {
        override fun onTabChanged(tabId: String) {
            //     setContentDescription(mTabHost, mTabsLabel)
        }
    }

    private fun setContentDescription(mTabHost: TabHost?, mTabsLabel: Array<String?>) {
        val tab = mTabHost!!.currentTab
        val tabCount = mTabHost!!.tabWidget.tabCount
        for (tabNumber in 0 until tabCount) {
            var contentDescription = mTabsLabel[tabNumber]
            contentDescription =
                contentDescription.toString() + ", onglet " + (tabNumber + 1) + " sur " + tabCount
            if (tabNumber == tab) {
                contentDescription = "$contentDescription, sélectionné"
            }
            mTabHost.tabWidget.getChildAt(tabNumber).contentDescription = contentDescription
        }
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



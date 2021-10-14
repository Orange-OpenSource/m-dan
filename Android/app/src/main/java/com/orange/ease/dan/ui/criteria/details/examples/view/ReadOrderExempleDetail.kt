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
import android.widget.ImageView
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ReadOrderExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.exreadorder_frag, null) as LinearLayout

        val volup = accessibleView.findViewById<ImageView>(R.id.volup)
        val voldown = accessibleView.findViewById<ImageView>(R.id.voldown)
        val chaineplus = accessibleView.findViewById<ImageView>(R.id.chaineplus)
        val chainemoins = accessibleView.findViewById<ImageView>(R.id.chainemoins)
        val remote1 = accessibleView.findViewById<Button>(R.id.remote1)
        val remote2 = accessibleView.findViewById<Button>(R.id.remote2)
        val remote3 = accessibleView.findViewById<Button>(R.id.remote3)
        val remote4 = accessibleView.findViewById<Button>(R.id.remote4)
        val remote5 = accessibleView.findViewById<Button>(R.id.remote5)
        val remote6 = accessibleView.findViewById<Button>(R.id.remote6)
        val remote7 = accessibleView.findViewById<Button>(R.id.remote7)
        val remote8 = accessibleView.findViewById<Button>(R.id.remote8)
        val remote9 = accessibleView.findViewById<Button>(R.id.remote9)
        val remote0 = accessibleView.findViewById<Button>(R.id.remote0)

        volup.contentDescription = context.getString(R.string.criteria_readorder_ex1_volup)
        voldown.contentDescription = context.getString(R.string.criteria_readorder_ex1_voldown)
        chaineplus.contentDescription = context.getString(R.string.criteria_readorder_ex1_canalup)
        chainemoins.contentDescription = context.getString(R.string.criteria_readorder_ex1_canaldown)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            //  remote1.accessibilityTraversalAfter = mTextViewTitleExempleAxsYes.getId()
            remote2.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote1).id
            remote3.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote2).id
            remote4.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote3).id
            remote5.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote4).id
            remote6.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote5).id
            remote7.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote6).id
            remote8.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote7).id
            remote9.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote8).id
            remote0.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote9).id
            volup.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.remote0).id
            voldown.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.volup).id
            chaineplus.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.voldown).id
            chainemoins.accessibilityTraversalAfter = accessibleView.findViewById<View>(R.id.chaineplus).id
        }

        // setNextFocus(mTextViewTitleExempleAxsYes, 0, volup.id, 0, 0, volup.id)
        setNextFocus(volup, 0, voldown.id, chaineplus.id, remote1.id, voldown.id)
        setNextFocus(voldown, volup.id, remote7.id, chainemoins.id, remote4.id, chaineplus.id)
        setNextFocus(remote1, 0, remote4.id, volup.id, remote2.id, remote2.id)
        setNextFocus(remote2, 0, remote5.id, remote1.id, remote3.id, remote3.id)
        setNextFocus(remote3, 0, remote6.id, remote2.id, chaineplus.id, remote4.id)
        setNextFocus(remote4, remote1.id, remote7.id, volup.id, remote5.id, remote5.id)
        setNextFocus(remote5, remote2.id, remote8.id, remote4.id, remote6.id, remote6.id)
        setNextFocus(remote6, remote3.id, remote9.id, remote5.id, chaineplus.id, remote7.id)
        setNextFocus(remote7, remote4.id, remote0.id, voldown.id, remote8.id, remote8.id)
        setNextFocus(remote8, remote5.id, remote0.id, remote7.id, remote9.id, remote9.id)
        setNextFocus(remote9, remote6.id, remote0.id, remote8.id, chainemoins.id, remote0.id)
        //   setNextFocus(remote0, remote8.id, mTextViewTitleExempleAxsNo.getId(), remote7.id, remote9.id, volup.id)
        setNextFocus(chaineplus, 0, chainemoins.id, remote3.id, volup.id, chainemoins.id)
        //  setNextFocus(chainemoins, chaineplus.id, remote9.id, remote6.id, voldown.id, mTextViewTitleExempleAxsNo.getId())

        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.exreadorder_frag, null)
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_readorder_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_readorder_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_readorder_ex1_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    private fun setNextFocus(
        view: View,
        upid: Int,
        downid: Int,
        leftid: Int,
        rightid: Int,
        forwardid: Int
    ) {
        view.nextFocusUpId = upid
        view.nextFocusDownId = downid
        view.nextFocusLeftId = leftid
        view.nextFocusRightId = rightid
        view.nextFocusForwardId = forwardid
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



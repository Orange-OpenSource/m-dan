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
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ImgExample1Detail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
       // Commons params for ImageView
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP

        // Accessible ImageView
        val accessibleImageView = ImageView(context)
        accessibleImageView.adjustViewBounds = true
        accessibleImageView.contentDescription = context.getString(R.string.criteria_img_ex1_cd_image)
        accessibleImageView.layoutParams = params
        accessibleImageView.setImageResource(R.drawable.exampleimg1)

        return accessibleImageView
    }

    override fun getNotAccessibleExample(context: Context): View {
        // Commons params for ImageView
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP


        // Not accessible ImageView
        val notAccessibleImageView = ImageView(context)
        notAccessibleImageView.layoutParams = params
        notAccessibleImageView.adjustViewBounds = true
        notAccessibleImageView.setPaddingRelative(0,0,0,25)
        notAccessibleImageView.setImageResource(R.drawable.exampleimg1)
        return notAccessibleImageView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_img_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_img_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_img_ex1_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



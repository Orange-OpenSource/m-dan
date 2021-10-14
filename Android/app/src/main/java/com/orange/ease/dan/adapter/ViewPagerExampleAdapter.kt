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


package com.orange.ease.dan.adapter

import android.content.Context
import android.os.Build
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.orange.ease.dan.R

class ViewPagerExampleAdapter(mIsAccessible: Boolean, context: Context) : PagerAdapter() {

    val INDICE_START = 0
    val INDICE_END = 2
    val INDICE_END_HUMAN = INDICE_END + 1

    var viewList = SparseArray<View>()
    var isAxs: Boolean = mIsAccessible
    val context = context
    var GalImages = intArrayOf(
        R.drawable.carousel1,
        R.drawable.carousel2,
        R.drawable.carousel3
    )
    var GalTextes = intArrayOf(
        R.string.criteria_contentcontrol_ex_imgcd1,
        R.string.criteria_contentcontrol_ex_imgcd2,
        R.string.criteria_contentcontrol_ex_imgcd3
    )

    fun getContentDescriptionImage(position: Int): String {
        return context.getString(R.string.promotion).toString() + " " + (position + 1) + " " + context.getString(R.string.on) + " " + INDICE_END_HUMAN + " " + context.getString(
            GalTextes[position]
        )
    }

    fun getContentDescriptionPosition(position: Int): String? {
        return context.getString(R.string.image).toString() + " " + (position + 1) + " " + context.getString(R.string.on) + " " + INDICE_END_HUMAN
    }

    override fun getCount(): Int {
        return GalImages.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val newView: View
        val inflater = LayoutInflater.from(context)
        if (viewList[position] == null) {
            viewList.put(position, inflater.inflate(R.layout.carousel_image, null))
            val tmpView = viewList[position]
            val mImageView = tmpView.findViewById<View>(R.id.imgViewLogoAxsOrange) as ImageView
            mImageView.setImageResource(GalImages[position])
            if (isAxs) {
                mImageView.contentDescription = getContentDescriptionImage(position)
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mImageView.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
                }
            }
        }
        newView = viewList[position]
        container.addView(newView)
        return newView
    }
}



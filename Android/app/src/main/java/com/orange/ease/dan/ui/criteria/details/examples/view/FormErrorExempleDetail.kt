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
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class FormErrorExempleDetail: AccessibilityDetailsExample() {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.exform_error_frag, null) as LinearLayout

        val buttonValidate = accessibleView.findViewById<Button>(R.id.validate_form)
        val textField = accessibleView.findViewById<EditText>(R.id.name_textfield)
        buttonValidate.setOnClickListener { v ->
            if (textField.length() == 0) {
                textField.error = "Name is mandatory"
            }
        }
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.exform_error_frag, null)
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_form_ex2_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.getString(R.string.criteria_form_item2)
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_form_ex2_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



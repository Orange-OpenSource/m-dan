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

package com.orange.accessibilitystatementlibrary

import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.orange.accessibilitystatementlibrary.databinding.ViewStatementBinding

class StatementView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    var urlAccessibilityDeclaration: String? = null
    lateinit var binding : ViewStatementBinding

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        binding = ViewStatementBinding.inflate(LayoutInflater.from(context), this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DeclarationView)
        displayResults()
        initMoreDetailsButton(attributes)
    }

    fun initMoreDetailsButton(attributes: TypedArray) {
        try {
            val text = attributes.getString(R.styleable.DeclarationView_declarant)
            urlAccessibilityDeclaration =
                attributes.getString(R.styleable.DeclarationView_details_url)
            binding.declarantTextView.text = text

            binding.buttonSeeMore.setOnClickListener {
                if (urlAccessibilityDeclaration != null) {
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(urlAccessibilityDeclaration))
                    context.startActivity(browserIntent)
                }
            }
        } finally {
            attributes.recycle()
        }
    }

    private fun displayResults() {
        val statementXMLParser = StatementXMLParser(context)
        val accessibilityStatement = statementXMLParser.getAccessibilityStatementFromXML()

        val resultPercentValue = accessibilityStatement.resultScore?.toInt() ?: 0
        binding.resultTextView.text = context.getString(R.string.result, resultPercentValue)
        binding.resultTextView.contentDescription =
            context.getString(R.string.result_content_desc, resultPercentValue)

        binding.resultProgresBar.max = 100
        binding.resultProgresBar.progress = resultPercentValue

        binding.dateTextView.text = accessibilityStatement.getDateddMMyyyyFormat()
        binding.referentialTextView.text = accessibilityStatement.referential
        binding.technologieTextView.text = accessibilityStatement.technologies

        displayComplianceStatus(resultPercentValue, accessibilityStatement.title)
    }

    private fun displayComplianceStatus(percentValue: Int, title: String?) {
        var nameOfApplication = title
        if (nameOfApplication == null || nameOfApplication.length == 0) {
            nameOfApplication = context.getString(R.string.nameOfApp)
        }
        binding.resultDetailTextView.text = context.getString(R.string.conformity_state, nameOfApplication, percentValue)
    }


}
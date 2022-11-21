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

package com.orange.ease.dan.data

import com.orange.ease.dan.R
import com.orange.ease.dan.model.TestColorContrastGuide
import com.orange.ease.dan.model.TestGuide
import com.orange.ease.dan.model.TestTalkbackGuide

object TestGuideDataSource {

    private val generalNavigation = TestGuide(
        resTitle = R.string.general_navigation_test_title,
        resDescription = R.string.general_navigation_test_description,
        optionDescription = null,
        resLink = null,
        option = false
    )

    private val textMagnification = TestGuide(
        resTitle = R.string.magnification_test_title,
        resDescription = R.string.magnification_test_description,
        optionDescription = R.string.magnification_test_description,
        resLink= R.string.magnification_details_button_title,
        option = true
    )

    private val screenReader = TestTalkbackGuide(
        resTitle = R.string.screen_reader_test_title,
        resDescription1 = R.string.screen_Reader_test_description1,
        resDescription2 = R.string.screen_Reader_test_description2,
        resImg = R.drawable.activate_dark_screen
    )

    private val keyboardNavigation = TestGuide(
        resTitle = R.string.keyboard_navigation_test_title,
        resDescription = R.string.keyboard_navigation_test_description,
        optionDescription = null,
        resLink= null,
        option = false
    )

    private val colorContrast = TestColorContrastGuide(
        resTitle = R.string.contrastColor_test_title,
        resDescription1 = R.string.contrastColor_test_description1  ,
        resDescription2 = R.string.contrastColor_test_description2,
        resDescription3 = R.string.contrastColor_test_description3,
        resImg1 = R.drawable.accessibility_scanner_button,
        resImg2 = R.drawable.accessibility_scanner_report
    )

    private val multimedia = TestGuide(
        resTitle = R.string.multimedia_test_title,
        resDescription = R.string.multimedia_test_description,
        optionDescription = null,
        resLink = null,
        option = false
    )


    private val webview = TestGuide(
        resTitle = R.string.webview_test_title,
        resDescription = R.string.webview_test_description,
        optionDescription = null,
        resLink = R.string.webview_details_button_title,
        option = false
    )



    val allManualTests = listOf(
        generalNavigation,
        textMagnification,
        keyboardNavigation
    )

    val allOtherTests = listOf(
        multimedia,
        webview
    )

    val allTalkabackTest = listOf(
        screenReader)

    val allColorContrastTest = listOf(
        colorContrast)



}

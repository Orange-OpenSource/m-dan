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
import com.orange.ease.dan.model.TestGuide

object TestGuideDataSource {

    /**
     * Navigation générale
    Agrandissement de texte
    Lecteur d’écran Voice Over
    Contrôle de sélection */

    private val generalNavigation = TestGuide(
        resTitle = R.string.manual_test_title,
        //general_navigation_test_description
        resDescription = R.string.general_navigation_test_description,
        resImg1= null,
        resImg2 = null


    )

    private val textMagnification = TestGuide(
        resTitle = R.string.magnification_test_title,
        resDescription = R.string.magnification_test_description,
        resImg1= null,
        resImg2 = null

    )



    private val screenReader = TestGuide(
        resTitle = R.string.screen_reader_test_title,
        resDescription = R.string.screen_Reader_test_description,
        resImg1 = R.drawable.activate_dark_screen,
        resImg2 = null

    )

    private val keyboardNavigation = TestGuide(
        resTitle = R.string.keyboard_navigation_test_title,
        resDescription = R.string.keyboard_navigation_test_description,
        resImg1= null,
        resImg2 = null
    )

    private val colorContrast = TestGuide(
        resTitle = R.string.contrastColor_test_title,
        resDescription = R.string.contrastColor_test_description  ,
        resImg1 = R.drawable.scanner_accessibility_report,
        resImg2 = null
    )

    private val multimedia = TestGuide(
        resTitle = R.string.multimedia_test_title,
        resDescription = R.string.multimedia_test_description,
        resImg1 = null,
        resImg2 = null
    )


    private val webview = TestGuide(
        resTitle = R.string.webview_test_title,
        resDescription = R.string.webview_test_description,
        resImg1 = null,
        resImg2 = null
    )



    val allManualTests = listOf(
        generalNavigation,
        textMagnification,
        screenReader,
        keyboardNavigation
    )

    val allOtherTests = listOf(
        colorContrast,
        multimedia,
        webview
    )


}

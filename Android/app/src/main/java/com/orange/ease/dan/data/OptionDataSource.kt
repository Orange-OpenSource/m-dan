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
import com.orange.ease.dan.model.Criteria
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.model.OptionClassic
import com.orange.ease.dan.model.OptionTalkback

object OptionDataSource {

    private val optionColorCorrection = OptionClassic(
        resTitle = R.string.options_colors_correction_title,
        description = R.string.options_content_colors
    )

    private val optionColorInversion = OptionClassic(
        resTitle = R.string.options_colors_inversion_title,
        description = R.string.options_content_colorInversion
    )

    private val optionZoom= OptionClassic(
        resTitle = R.string.options_zoom_title,
        description = R.string.options_content_zoom
    )

    private val optionTextSize = OptionClassic(
        resTitle = R.string.options_magnification_title,
        description = R.string.options_content_txtSize
    )

    private val optionTalkback = OptionTalkback(
        resTitle = R.string.options_talkback_title
    )

    val allOptions = listOf(
        optionTalkback,
        optionTextSize,
        optionZoom,
        optionColorCorrection,
        optionColorInversion
    )
}
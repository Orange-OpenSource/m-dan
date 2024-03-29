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

import android.os.Build
import com.orange.ease.dan.R
import com.orange.ease.dan.model.*
import com.orange.ease.dan.ui.criteria.details.examples.view.*

object ExampleDataSource {

    val exampleChangeContent : Example by lazy {
        Example(resTitle = R.string.criteria_contentchange_item1, detailsExample = ChangeContentExampleDetail())
    }
    val exampleClickZone : Example by lazy {
        Example(resTitle = R.string.criteria_clickarea_item1, detailsExample = ClickZoneExampleDetail())
    }
    val exampleColor1 : Example by lazy {
        Example(resTitle = R.string.criteria_color_item1, detailsExample = ColorExample1Detail())
    }
    val exampleColor2 : Example by lazy {
        Example(resTitle = R.string.criteria_color_item2, detailsExample = ColorExample2Detail())
    }
    val exampleControlContent1 : Example by lazy {
        Example(resTitle = R.string.criteria_contentcontrol_item1, detailsExample = ControlContentExample1Detail())
    }
    val exampleControlContent2 : Example by lazy {
        Example(resTitle = R.string.criteria_contentcontrol_item2, detailsExample = ControlContentExample2Detail())
    }
    val exampleControlContent3 : Example by lazy {
        Example(resTitle = R.string.criteria_timetotakeaction_title, detailsExample = TimeTakeActionExampleDetail(), apiVersion = Build.VERSION_CODES.Q)
    }
    val exampleFocusNav : Example by lazy {
        Example(resTitle = R.string.criteria_focusnav_item1, detailsExample = FocusNavExampleDetail())
    }
    val exampleFocusColor : Example by lazy {
        Example(resTitle = R.string.example_focus_color_title, detailsExample = FocusColorExampleDetail())
    }
    val exampleGhost : Example by lazy {
        Example(resTitle = R.string.criteria_ghostelement_item1, detailsExample = GhostExempleDetail())
    }
    val exampleImage1 : Example by lazy {
        Example(resTitle = R.string.criteria_img_item1, detailsExample = ImgExample1Detail())
    }
    val exampleImage2 : Example by lazy {
        Example(resTitle = R.string.criteria_img_item2, detailsExample = ImgExample2Detail())
    }
    val exampleImage3 : Example by lazy {
        Example(resTitle = R.string.criteria_img_item3, detailsExample = ImgExample3Detail())
    }

    val exampleAlt1 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item1, detailsExample = ImgExample3Detail())
    }
    val exampleAlt2 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item2, detailsExample = StateElementsExampleDetail())
    }

    val exampleReadOrder : Example by lazy {
        Example(resTitle = R.string.criteria_readorder_item1, detailsExample = ReadOrderExampleDetail())
    }
    val exampleScroll : Example by lazy {
        Example(resTitle = R.string.criteria_scroll_item1, detailsExample = ScrollExampleDetail())
    }
    val exampleTextSize : Example by lazy {
        Example(resTitle = R.string.criteria_textsize_item1, detailsExample = TextSizeExampleDetail())
    }
    val exampleTextReadability : Example by lazy {
        Example(resTitle = R.string.criteria_textsize_item2, detailsExample = TextReadabilityExampleDetail())
    }
    val exampleStandardComponent1 : Example by lazy {
        Example(resTitle = R.string.criteria_standardcomponent_title, detailsExample = StandardComponentExampleDetail())
    }
    val exampleStandardComponent2 : Example by lazy {
        Example(resTitle = R.string.criteria_standardcomponent_ex2_title, detailsExample = StandardComponent2ExampleDetail())
    }
    val exampleStateElements1 : Example by lazy {
        Example(resTitle = R.string.criteria_stateelement_item1, detailsExample = StateElementsExampleDetail())
    }
    val exampleStateElements2 : Example by lazy {
        Example(resTitle = R.string.criteria_stateelement_item2, detailsExample = StateElementsExample2Detail())
    }
    val exampleStateElements3 : Example by lazy {
        Example(resTitle = R.string.criteria_stateelement_item3, detailsExample = StateElementsExample3Detail())
    }
    val exampleTitle : Example by lazy {
        Example(resTitle = R.string.criteria_title_item1, detailsExample = TitleExampleDetail())
    }
    val exampleText1 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item4, detailsExample = Text1ExampleDetail())
    }
    val exampleText2 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item5, detailsExample = Text2ExampleDetail())
    }
    val exampleText3 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item6, detailsExample = Text3ExampleDetail())
    }
    val exampleGroup : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item7, detailsExample = GroupExampleDetail())
    }
    val exampleHeading : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item8, detailsExample = HeadingExampleDetail(), apiVersion = Build.VERSION_CODES.P)
    }

    val exampleForm : Example by lazy {
        Example(resTitle = R.string.criteria_form_item1, detailsExample = FormExampleDetail())
    }
    val exampleFormError : Example by lazy {
        Example(resTitle = R.string.criteria_form_item2, detailsExample = FormErrorExampleDetail())
    }

    val exampleAlt3 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item3, detailsExample = FormExampleDetail())
    }
}
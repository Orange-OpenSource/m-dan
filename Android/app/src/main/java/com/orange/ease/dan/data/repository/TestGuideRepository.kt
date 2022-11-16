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

package com.orange.ease.dan.data.repository

import com.orange.ease.dan.data.DevelopmentGuideDataSource
import com.orange.ease.dan.data.TestGuideDataSource
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.model.TestColorContrastGuide
import com.orange.ease.dan.model.TestGuide
import com.orange.ease.dan.model.TestTalkbackGuide

object TestGuideRepository {

    private var currentGuide: AccessibilityEntity? = null

    fun getCurrentGuide(): AccessibilityEntity? {
        return currentGuide
    }

    fun setCurrentGuide(guide: AccessibilityEntity) {
        currentGuide = guide
    }

    fun getListOfGuide(): List<TestGuide> {
        return TestGuideDataSource.allManualTests
    }
   fun getListOfOtherGuide(): List<TestGuide> {
        return TestGuideDataSource.allOtherTests
    }
    fun getTalkbackGuide(): List<TestTalkbackGuide> {
        return TestGuideDataSource.allTalkabackTest
    }

    fun getColorContrastGuide(): List<TestColorContrastGuide> {
        return TestGuideDataSource.allColorContrastTest
    }

}



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

import com.orange.ease.dan.data.ExampleDataSource
import com.orange.ease.dan.model.Example

object ExampleRepository {

    private var currentExample: Example? = null

    fun getCurrentCriteria(): Example? {
        return currentExample
    }

    fun setCurrentExample(example: Example) {
        currentExample = example
    }

    fun getListOfImageExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleImage1,
            ExampleDataSource.exampleImage2,
            ExampleDataSource.exampleImage3
        )
    }

    fun getListOfColorExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleColor1, ExampleDataSource.exampleColor2
        )
    }

    fun getListOfAltExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleAlt1,
            ExampleDataSource.exampleAlt2,
            ExampleDataSource.exampleAlt3,
            ExampleDataSource.exampleText1,
            ExampleDataSource.exampleText2,
            ExampleDataSource.exampleText3,
            ExampleDataSource.exampleGroup,
            ExampleDataSource.exampleHeading
        )
    }

    fun getListOfClickZoneExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleClickZone
        )
    }

    fun getListOfContentChangeExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleChangeContent
        )
    }

    fun getListOfContentControlExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleControlContent1,
            ExampleDataSource.exampleControlContent2,
            ExampleDataSource.exampleControlContent3
        )
    }

    fun getListOfElementStateExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleStateElements1,
            ExampleDataSource.exampleStateElements2,
            ExampleDataSource.exampleStateElements3
        )
    }

    fun getListOfFocusExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleFocusNav, ExampleDataSource.exampleFocusColor
        )
    }

    fun getListOfFormExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleForm, ExampleDataSource.exampleFormError
        )
    }

    fun getListOfGhostExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleGhost
        )
    }

    fun getListOfReadOrderExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleReadOrder
        )
    }

    fun getListOfScrollExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleScroll
        )
    }

    fun getStandardComponentExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleStandardComponent2
        )
    }

    fun getListOfTitleExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleTitle
        )
    }

    fun getListOfTextExample(): List<Example> {
        return listOf<Example>(
            ExampleDataSource.exampleTextSize, ExampleDataSource.exampleTextReadability
        )
    }
}



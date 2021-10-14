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

package com.orange.ease.dan.ui.criteria.details.examples

import android.content.Context
import android.view.View
import kotlin.properties.Delegates

interface AccessibilityDetailsExample {
    fun getAccessibleExample(context: Context) : View
    fun getNotAccessibleExample(context: Context) : View
    fun getTitleRessource(context: Context) : String
    fun getCellNameRessource(context: Context) : String
    fun getDescriptionRessource(context: Context) : String
    fun getOptionRessource(context: Context): String?
    fun useOption(): Boolean
}



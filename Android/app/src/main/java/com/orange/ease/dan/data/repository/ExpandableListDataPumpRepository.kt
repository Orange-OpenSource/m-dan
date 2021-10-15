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

import android.content.Context
import com.orange.ease.dan.R


object ExpandableListDataPumpRepository {

    fun getData(context: Context): HashMap<String, List<String>>? {
        val expandableListDetail: HashMap<String, List<String>> = HashMap()
        val technology: MutableList<String> = ArrayList()
        technology.add(context.getString(R.string.criteria_standardcomponent_ex1_category1_item1))
        technology.add(context.getString(R.string.criteria_standardcomponent_ex1_category1_item2))
        val entertainment: MutableList<String> = ArrayList()
        entertainment.add(context.getString(R.string.criteria_standardcomponent_ex1_category2_item1))
        entertainment.add(context.getString(R.string.criteria_standardcomponent_ex1_category2_item2))
        expandableListDetail[context.getString(R.string.criteria_standardcomponent_ex1_category1_name)] =
            technology
        expandableListDetail[context.getString(R.string.criteria_standardcomponent_ex1_category2_name)] =
            entertainment
        return expandableListDetail
    }
}


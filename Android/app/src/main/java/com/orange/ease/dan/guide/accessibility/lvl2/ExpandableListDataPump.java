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

package com.orange.ease.dan.guide.accessibility.lvl2;

import android.content.Context;

import com.orange.ease.dan.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData(Context context) {
        HashMap<String, List<String>> expandableListDetail = new HashMap<>();

        List<String> technology = new ArrayList<>();
        technology.add(context.getString(R.string.criteria_standardcomponent_ex1_category1_item1));
        technology.add(context.getString(R.string.criteria_standardcomponent_ex1_category1_item2));

        List<String> entertainment = new ArrayList<>();
        entertainment.add(context.getString(R.string.criteria_standardcomponent_ex1_category2_item1));
        entertainment.add(context.getString(R.string.criteria_standardcomponent_ex1_category2_item2));

        expandableListDetail.put(context.getString(R.string.criteria_standardcomponent_ex1_category1_name), technology);
        expandableListDetail.put(context.getString(R.string.criteria_standardcomponent_ex1_category2_name), entertainment);
        return expandableListDetail;
    }
}

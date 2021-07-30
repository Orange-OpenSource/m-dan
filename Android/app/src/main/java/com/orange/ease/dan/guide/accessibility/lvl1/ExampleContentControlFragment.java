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

package com.orange.ease.dan.guide.accessibility.lvl1;

import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.guide.accessibility.lvl2.ExControlContent1Fragment_;
import com.orange.ease.dan.guide.accessibility.lvl2.ExControlContent2Fragment_;

import org.androidannotations.annotations.EFragment;

import static com.orange.ease.dan.R.array.criteria_contentcontrol_list;
import static com.orange.ease.dan.R.string.criteria_contentcontrol_rule_description;
import static com.orange.ease.dan.R.string.criteria_contentcontrol_title;
import static com.orange.ease.dan.R.string.criteria_contentcontrol_why_description;


@EFragment(R.layout.criteria_template)
public class ExampleContentControlFragment extends ABaseCriteriaListFragment {

    @Override
    protected int getWhyDescription() {
        return criteria_contentcontrol_why_description;
    }

    @Override
    protected int getRuleDescription() {
        return criteria_contentcontrol_rule_description;
    }

    @Override
    protected int getListArray() {
        return criteria_contentcontrol_list;
    }

    @Override
    protected int getTitleResource() {
        return criteria_contentcontrol_title;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;

        String mNextTitle = getString(R.string.example) + " " + (position) + "/" + "2";

        switch (position) {
            case 1:
                newFragment = new ExControlContent1Fragment_();
                break;
            case 2:
                newFragment = new ExControlContent2Fragment_();
                break;
            default:
                break;
        }

        if (newFragment != null) {
            mOnNewFragment.onNewFragment(newFragment, mNextTitle, true);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

}

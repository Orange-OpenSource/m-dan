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
import com.orange.ease.dan.guide.accessibility.lvl2.ExForm1Fragment_;
import com.orange.ease.dan.guide.accessibility.lvl2.ExImg3Fragment_;
import com.orange.ease.dan.guide.accessibility.lvl2.ExStateElmts1Fragment_;
import com.orange.ease.dan.guide.accessibility.lvl2.ExTxt1Fragment_;
import com.orange.ease.dan.guide.accessibility.lvl2.ExTxt2Fragment_;
import com.orange.ease.dan.guide.accessibility.lvl2.ExTxt3FootballFragment_;

import org.androidannotations.annotations.EFragment;


@EFragment(R.layout.criteria_template)
public class ExampleAltFragment extends ABaseCriteriaListFragment {

    @Override
    protected int getListArray() {
        return R.array.criteria_alt_list;
    }

    @Override
    protected int getRuleDescription() {
        return R.string.criteria_alt_rule_description;
    }

    @Override
    protected int getWhyDescription() {
        return R.string.criteria_alt_why_description;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;
        String mNextTitle;
        mNextTitle = getString(R.string.example) + " " + (position) + "/6";

        switch (position) {
            case 1:
                newFragment = new ExImg3Fragment_();
                break;
            case 2:
                newFragment = new ExStateElmts1Fragment_();
                break;
            case 3:
                newFragment = new ExForm1Fragment_();
                break;
            case 4:
                newFragment = new ExTxt1Fragment_();
                break;
            case 5:
                newFragment = new ExTxt2Fragment_();
                break;
            case 6:
                newFragment = new ExTxt3FootballFragment_();
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

    @Override
    protected int getTitleResource() {
        return R.string.criteria_alt_title;
    }
}

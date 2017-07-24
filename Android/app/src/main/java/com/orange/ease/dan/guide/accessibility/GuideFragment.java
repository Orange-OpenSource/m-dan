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

package com.orange.ease.dan.navFragments;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.orange.ease.dan.BaseListFragment;
import com.orange.ease.dan.R;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleAltFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleClickZoneFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleColorFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleContentChangeFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleContentControlFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleElementsStateFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleFocusNavigationFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleFormFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleGhostElementFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleImgFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleReadOrderFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleScrollFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleStandardComponentFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleTitlesFragment_;
import com.orange.ease.dan.guide.accessibility.lvl1.ExampleTxtSizeFragment_;

import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_exemple)
public class GuideFragment extends BaseListFragment {

    @Override
    protected void initHeader() {
        mHeaderView = inflateHeader(R.layout.header);
        ((TextView) mHeaderView.findViewById(R.id.headerLabel)).setText(R.string.criteria_description_title);
        ((TextView) mHeaderView.findViewById(R.id.headerDescription)).setText(R.string.criteria_description_content);
        ((TextView) mHeaderView.findViewById(R.id.headerListLabel)).setText(R.string.criteria_sections);
    }

    @Override
    protected int getListArray() {
        return R.array.criteria_list;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.main_menu_group, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;
        String mTitle = "";
        switch (position) {
            case 1:
                mTitle = getString(R.string.criteria_img_title);
                newFragment = new ExampleImgFragment_();
                break;
            case 2:
                mTitle = getString(R.string.criteria_color_title);
                newFragment = new ExampleColorFragment_();
                break;
            case 3:
                mTitle = getString(R.string.criteria_alt_title);
                newFragment = new ExampleAltFragment_();
                break;
            case 4:
                mTitle = getString(R.string.criteria_title_title);
                newFragment = new ExampleTitlesFragment_();
                break;
            case 5:
                mTitle = getString(R.string.criteria_stateelements_title);
                newFragment = new ExampleElementsStateFragment_();
                break;
            case 6:
                mTitle = getString(R.string.criteria_standardcomponent_title);
                newFragment = new ExampleStandardComponentFragment_();
                break;
            case 7:
                mTitle = getString(R.string.criteria_clickarea_title);
                newFragment = new ExampleClickZoneFragment_();
                break;
            case 8:
                mTitle = getString(R.string.criteria_ghostelement_title);
                newFragment = new ExampleGhostElementFragment_();
                break;
            case 9:
                mTitle = getString(R.string.criteria_textsize_title);
                newFragment = new ExampleTxtSizeFragment_();
                break;
            case 10:
                mTitle = getString(R.string.criteria_contentcontrol_title);
                newFragment = new ExampleContentControlFragment_();
                break;
            case 11:
                mTitle = getString(R.string.criteria_title_contentchange);
                newFragment = new ExampleContentChangeFragment_();
                break;
            case 12:
                mTitle = getString(R.string.criteria_horizontalscroll_title);
                newFragment = new ExampleScrollFragment_();
                break;
            case 13:
                mTitle = getString(R.string.criteria_form_title);
                newFragment = new ExampleFormFragment_();
                break;
            case 14:
                mTitle = getString(R.string.criteria_readorder_title);
                newFragment = new ExampleReadOrderFragment_();
                break;
            case 15:
                mTitle = getString(R.string.criteria_focusnav_title);
                newFragment = new ExampleFocusNavigationFragment_();
                break;
            default:
                break;
        }

        if (newFragment != null) {
            mOnNewFragment.onNewFragment(newFragment, mTitle, true);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    protected int getTitleResource() {
        return R.string.section_criteria;
    }
}

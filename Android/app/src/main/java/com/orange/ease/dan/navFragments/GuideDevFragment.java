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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.orange.ease.dan.BaseListFragment;
import com.orange.ease.dan.R;
import com.orange.ease.dan.guide.dev.GuideDevAltFragment_;
import com.orange.ease.dan.guide.dev.GuideDevAxsEvenmentsFragment_;
import com.orange.ease.dan.guide.dev.GuideDevFocusNavFragment_;
import com.orange.ease.dan.guide.dev.GuideDevFormsFragment_;
import com.orange.ease.dan.guide.dev.GuideDevListVocFragment_;
import com.orange.ease.dan.guide.dev.GuideDevLiveFragment_;
import com.orange.ease.dan.guide.dev.GuideDevMaskFragment_;
import com.orange.ease.dan.guide.dev.GuideDevReadOrderFragment_;
import com.orange.ease.dan.guide.dev.GuideDevTalkbackFragment_;
import com.orange.ease.dan.guide.dev.GuideDevTxtSizeFragment_;
import com.orange.ease.dan.guide.dev.GuideDevVocFragment_;
import com.orange.ease.dan.guide.dev.GuideDevWebViewFragment_;
import com.orange.ease.dan.view.HeaderView;
import com.orange.ease.dan.view.HeaderView_;

import org.androidannotations.annotations.EFragment;

import static com.orange.ease.dan.R.drawable.dev_illustration;
import static com.orange.ease.dan.R.string.alert_before_leaving;
import static com.orange.ease.dan.R.string.dev_description_content;
import static com.orange.ease.dan.R.string.dev_description_title;
import static com.orange.ease.dan.R.string.dev_sections;
import static com.orange.ease.dan.R.string.section_dev;


@EFragment(R.layout.fragment_exemple)
public class GuideDevFragment extends BaseListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((HeaderView) mHeaderView).setTexts(dev_description_title, dev_description_content, dev_sections, getString(alert_before_leaving), dev_illustration);
        ((HeaderView) mHeaderView).hideHeaderInformation();
        ((HeaderView) mHeaderView).hideSeparator();
    }

    @Override
    protected int getListArray() {
        return R.array.dev_list;
    }

    @Override
    protected int getTitleResource() {
        return section_dev;
    }

    @Override
    protected void initHeader() {
        mHeaderView = HeaderView_.build(getContext());
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;
        String mTitle = "";
        switch (position) {
            case 1:
                mTitle = adapter.getItem(0);
                newFragment = new GuideDevAltFragment_();
                break;
            case 2:
                mTitle = adapter.getItem(1);
                newFragment = new GuideDevMaskFragment_();
                break;
            case 3:
                mTitle = adapter.getItem(2);
                newFragment = new GuideDevVocFragment_();
                break;
            case 4:
                mTitle = adapter.getItem(3);
                newFragment = new GuideDevTalkbackFragment_();
                break;
            case 5:
                mTitle = adapter.getItem(4);
                newFragment = new GuideDevLiveFragment_();
                break;
            case 6:
                mTitle = adapter.getItem(5);
                newFragment = new GuideDevReadOrderFragment_();
                break;
            case 7:
                mTitle = adapter.getItem(6);
                newFragment = new GuideDevFormsFragment_();
                break;
            case 8:
                mTitle = adapter.getItem(7);
                newFragment = new GuideDevTxtSizeFragment_();
                break;
            case 9:
                mTitle = adapter.getItem(8);
                newFragment = new GuideDevAxsEvenmentsFragment_();
                break;
            case 10:
                mTitle = adapter.getItem(9);
                newFragment = new GuideDevWebViewFragment_();
                break;
            case 11:
                mTitle = adapter.getItem(10);
                ;
                newFragment = new GuideDevListVocFragment_();
                break;
            case 12:
                mTitle = adapter.getItem(11);
                newFragment = new GuideDevFocusNavFragment_();
                break;

        }

        if (newFragment != null) {
            mOnNewFragment.onNewFragment(newFragment, mTitle, true);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

}


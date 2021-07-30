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

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_homepage)
public class HomeFragment extends Fragment {

    private OnNewFragment mOnNewFragment;
    private String mTitle = "";

    @ViewById(R.id.imgViewHomeLogo)
    public ImageView mImgViewHomeLogo;

    @ViewById(R.id.textViewHomeTitle)
    public TextView mTextViewHomeTitle;

    @ViewById(R.id.textViewHomeTitleLabel)
    public TextView mTextViewHomeTitleLabel;

    @ViewById(R.id.textViewHomeTitleAxs)
    public TextView mTextViewHomeTitleAxs;

    @ViewById(R.id.home_options_button)
    public LinearLayout mLinearHomeOptions;

    @ViewById(R.id.home_dev_button)
    public LinearLayout mLinearHomeDev;

    @ViewById(R.id.home_criteria_button)
    public LinearLayout mLinearHomeCriteria;

    @ViewById(R.id.home_talkback_button)
    public LinearLayout mLinearHomeTalkback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mOnNewFragment = (OnNewFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnNewFragment");
        }
    }

    @AfterViews
    public void initViews() {
        mTextViewHomeTitle.setText(R.string.app_name);
        mTextViewHomeTitleLabel.setText(R.string.home_long_mdan);
        mTextViewHomeTitleAxs.setText(R.string.home_content);

        mLinearHomeOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTilesClick(4);
            }
        });

        mLinearHomeDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTilesClick(2);
            }
        });

        mLinearHomeCriteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTilesClick(1);
            }
        });

        mLinearHomeTalkback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTilesClick(3);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(R.string.section_home),true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.main_menu_group, true);
    }

    public void onTilesClick(int position){

        Fragment newFragment = null;

        switch (position) {
            case 1:
                mTitle = getString(R.string.section_criteria);
                newFragment = new com.orange.ease.dan.guide.accessibility.GuideFragment_();
                break;
            case 2:
                mTitle = getString(R.string.section_dev);
                newFragment = new GuideDevFragment_();
                break;
            case 3:
                mTitle = getString(R.string.section_talkback);
                newFragment = new TalkbackFragment_();
                break;
            case 4:
                mTitle = getString(R.string.section_axs_options);
                newFragment = new OptionAxsFragment_();
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
}

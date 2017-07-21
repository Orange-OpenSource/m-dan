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

package com.orange.ease.dan.examplesFragmentsLvl2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.BaseFragment;
import com.orange.ease.dan.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExChangeContent1Fragment extends BaseFragment{

    @ViewById(R.id.textViewTitleExample)
    public TextView mTextViewTitleExample;

    @ViewById(R.id.textViewDescriptionExample)
    public TextView mTextViewDescriptionExample;

    @ViewById(R.id.textViewTitleExempleAxsYes)
    public TextView mTextViewTitleExempleAxsYes;

    @ViewById(R.id.frameLayoutExampleAxsYes)
    public FrameLayout mFrameLayoutExampleAxsYes;

    @ViewById(R.id.textViewTitleExempleAxsNo)
    public TextView mTextViewTitleExempleAxsNo;

    @ViewById(R.id.frameLayoutExampleAxsNo)
    public FrameLayout mFrameLayoutExampleAxsNo;

    @ViewById(R.id.textViewOptionEnabled)
    public TextView mTextViewOptionEnabled;

    private String[] mItemsWifiList;
    private LinearLayout mFakeListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnNewFragment.initAlertDialogOptions(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.example_frag_lvl2, container, false);
    }


    @AfterViews
    void updateView(){

        mTextViewTitleExample.setText(R.string.criteria_contentchange_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_contentchange_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        TextView tv = new TextView(getContext());
        tv.setText(R.string.criteria_contentchange_ex1_list_title);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.btnreload, null);
        final LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.btnreload, null);

        final LinearLayout ly = new LinearLayout(getActivity());
        ly.setOrientation(LinearLayout.VERTICAL);
        ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        mFrameLayoutExampleAxsYes.addView(ly);


        final LinearLayout ly2 = new LinearLayout(getActivity());
        ly2.setOrientation(LinearLayout.VERTICAL);
        ly2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        mFrameLayoutExampleAxsNo.addView(ly2);

        final LayoutInflater myInflater = inflater;

        //
        //ACCESSIBILITY YES
        //
        Button buttonReloadYes = (Button) myView.findViewById(R.id.imgButtonReload);
        buttonReloadYes.setContentDescription(getString(R.string.criteria_contentchange_ex1_majwifireload));
        buttonReloadYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ly.removeAllViewsInLayout();
                mItemsWifiList = getResources().getStringArray(R.array.criteria_contentchange_ex1_list_wifi2);

                for(String network : mItemsWifiList){
                    mFakeListView = (LinearLayout) myInflater.inflate(R.layout.list_item_content_change, null);
                    ((TextView) mFakeListView.findViewById(R.id.textCategory)).setText(network);
                    ly.addView(mFakeListView);
                }
                ly.addView(myView);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    getView().announceForAccessibility(getString(R.string.criteria_contentchange_ex1_announce));
                }
            }
        });

        mItemsWifiList = getResources().getStringArray(R.array.criteria_contentchange_ex1_list_wifi);
        for(String network : mItemsWifiList){
            mFakeListView = (LinearLayout) inflater.inflate(R.layout.list_item_content_change, null);
            ((TextView) mFakeListView.findViewById(R.id.textCategory)).setText(network);
            ly.addView(mFakeListView);
        }
        ly.addView(myView);


        //
        //ACCESSIBILITY NO
        //
        Button buttonReloadNo = (Button) myView2.findViewById(R.id.imgButtonReload);
        buttonReloadNo.setContentDescription(getString(R.string.criteria_contentchange_ex1_majwifireload));
        buttonReloadNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ly2.removeAllViewsInLayout();
                mItemsWifiList = getResources().getStringArray(R.array.criteria_contentchange_ex1_list_wifi2);

                for(String network : mItemsWifiList){
                    mFakeListView = (LinearLayout) myInflater.inflate(R.layout.list_item_content_change, null);
                    ((TextView) mFakeListView.findViewById(R.id.textCategory)).setText(network);
                    ly2.addView(mFakeListView);
                }
                ly2.addView(myView2);
            }
        });

        mItemsWifiList = getResources().getStringArray(R.array.criteria_contentchange_ex1_list_wifi);
        for(String network : mItemsWifiList){
            mFakeListView = (LinearLayout) inflater.inflate(R.layout.list_item_content_change, null);
            ((TextView) mFakeListView.findViewById(R.id.textCategory)).setText(network);
            ly2.addView(mFakeListView);
        }
        ly2.addView(myView2);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}


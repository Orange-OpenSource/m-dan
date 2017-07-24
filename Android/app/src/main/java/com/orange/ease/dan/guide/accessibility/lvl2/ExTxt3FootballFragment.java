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
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;
import com.orange.ease.dan.view.MatchFieldView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Frederic Coudurier on 15/07/2016.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExTxt3FootballFragment extends Fragment {

    private OnNewFragment mOnNewFragment;

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTextViewTitleExample.setText(R.string.criteria_alt_ex3_title);
        mTextViewDescriptionExample.setText(R.string.criteria_alt_ex3_description);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout footballFieldViewAxs = (RelativeLayout) inflater.inflate(R.layout.exalt_football_match_field, null);
        mFrameLayoutExampleAxsYes.addView(footballFieldViewAxs);

        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        RelativeLayout footballFieldViewNotAxs = (RelativeLayout) inflater.inflate(R.layout.exalt_football_match_field, null);
        MatchFieldView mfv = (MatchFieldView) footballFieldViewNotAxs.findViewById(R.id.match_field_view);
        mfv.setAccessible(false);
        mFrameLayoutExampleAxsNo.addView(footballFieldViewNotAxs);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}
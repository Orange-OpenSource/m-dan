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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExControlContent2Fragment extends Fragment {

    private String mTitle = "";
    private OnNewFragment mOnNewFragment;
    private Fragment myfrag = this;

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

        mTextViewTitleExample.setText(R.string.criteria_contentcontrol_ex2_title);
        mTextViewDescriptionExample.setText(R.string.criteria_contentcontrol_ex2_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.buttongeneric, null);
        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.buttongeneric, null);

        //
        // ACCESSIBILITY YES
        //

        Button btnYes = (Button) myView.findViewById(R.id.btngeneric);
        btnYes.setText(getString(R.string.axsactivated));

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment myDiapoFragement = new MyViewPagerDiapo_();
                Bundle args = new Bundle();
                args.putBoolean(MyViewPager.IS_ACCESSIBLE, true);
                myDiapoFragement.setArguments(args);
                mOnNewFragment.onNewFragment(myDiapoFragement, "",true);
            }
        });

        mFrameLayoutExampleAxsYes.addView(myView);

        //
        //ACCESSIBILITY NO
        //

        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        Button btnNo = (Button) myView2.findViewById(R.id.btngeneric);
        btnNo.setText(getString(R.string.axsdisabled));
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment myDiapoFragement = new MyViewPagerDiapo_();
                Bundle args = new Bundle();
                args.putBoolean(MyViewPager.IS_ACCESSIBLE, false);
                myDiapoFragement.setArguments(args);
                mOnNewFragment.onNewFragment(myDiapoFragement, "",true);
            }
        });

        mFrameLayoutExampleAxsNo.addView(myView2);
    }
    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle((getString(R.string.example)+" "+"2/2"),true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}

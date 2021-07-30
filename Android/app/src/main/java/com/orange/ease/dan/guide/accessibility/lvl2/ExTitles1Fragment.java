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
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
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


@EFragment(R.layout.example_frag_lvl2)
public class ExTitles1Fragment extends Fragment {

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

    @ViewById(R.id.linearfrag4)
    public LinearLayout mLinearLayoutTitleAxsNo;

    @ViewById(R.id.viewOptionEnabled)
    public LinearLayout mLyOptionToUse;

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

        mTextViewTitleExample.setText(R.string.criteria_title_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_title_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mLyOptionToUse.setVisibility(View.GONE);

        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (15*scale + 0.5f); //padding de 15dp
        int dpAsPixels2 = (int) (5*scale + 0.5f); //padding de 5dp
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.buttongeneric, null);
        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.buttongeneric, null);

        /* AXS YES */
        TextView exAxsDescription = new TextView(getContext());
        exAxsDescription.setText(getString(R.string.criteria_title_ex1_axsDesc));
        exAxsDescription.setPadding(dpAsPixels, dpAsPixels2, dpAsPixels, dpAsPixels2);

        Button buttonAvessibilityYes = (Button) myView.findViewById(R.id.btngeneric);
        buttonAvessibilityYes.setText(R.string.criteria_title_ex1_axsButton);
        buttonAvessibilityYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnNewFragment.setTemplateTitle(getString(R.string.example) + " 1/1", true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    getView().announceForAccessibility(getString(R.string.criteria_title_ex1_announceaxsyes)+" "+getString(R.string.example)+" 1/1");
                }
            }
        });

        LinearLayout lyAxs = new LinearLayout(getActivity());
        lyAxs.setOrientation(LinearLayout.VERTICAL);
        lyAxs.setLayoutParams(layoutParams);
        lyAxs.addView(exAxsDescription);
        lyAxs.addView(myView);

        /* AXS NO */
        TextView exNotAxsDescription = new TextView(getContext());
        exNotAxsDescription.setText(getString(R.string.criteria_title_ex1_notAxsDesc));
        exNotAxsDescription.setPadding(dpAsPixels, dpAsPixels2, dpAsPixels, dpAsPixels2);

        Button buttonAvessibilityNo = (Button) myView2.findViewById(R.id.btngeneric);
        buttonAvessibilityNo.setText(R.string.criteria_title_ex1_notAxsButton);
        buttonAvessibilityNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnNewFragment.setTemplateTitle(" ", true);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    getView().announceForAccessibility(getString(R.string.criteria_title_ex1_announceaxsno));
                }
            }
        });

        LinearLayout lyNotAxs = new LinearLayout(getActivity());
        lyNotAxs.setOrientation(LinearLayout.VERTICAL);
        lyNotAxs.setLayoutParams(layoutParams);
        lyNotAxs.addView(exNotAxsDescription);
        lyNotAxs.addView(myView2);


        mFrameLayoutExampleAxsYes.addView(lyAxs);
        mFrameLayoutExampleAxsNo.addView(lyNotAxs);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}

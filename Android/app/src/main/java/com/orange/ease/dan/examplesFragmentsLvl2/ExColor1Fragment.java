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
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExColor1Fragment extends Fragment {

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

    @ViewById(R.id.viewOptionEnabled)
    public LinearLayout mLyOptionToUse;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTextViewTitleExample.setText(R.string.criteria_color_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_color_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        mLyOptionToUse.setVisibility(View.GONE);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //
        //ACCESSIBILITY YES
        //
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.excolor1_list, null);
        TextView tv = (TextView) myView.findViewById(R.id.textViewsubtitle);
        tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.functional_greys_2));
        mFrameLayoutExampleAxsYes.addView(myView);

        //
        //ACCESSIBILITY NO
        //
        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.excolor1_list, null);

        TextView tvDescNo = (TextView) myView2.findViewById(R.id.exDesc);
        tvDescNo.setText(getString(R.string.criteria_color_ex1_not_accessible_desc));
        TextView tvTitleNo = (TextView) myView2.findViewById(R.id.textViewlisttitle);
        tvTitleNo.setTextColor(ContextCompat.getColor(getContext(), R.color.functional_greys_3));
        TextView tvNo = (TextView) myView2.findViewById(R.id.textViewsubtitle);
        tvNo.setTextColor(ContextCompat.getColor(getContext(), R.color.functional_greys_4));
        mFrameLayoutExampleAxsNo.addView(myView2);
    }
}


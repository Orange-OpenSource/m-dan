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
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.example_frag_lvl2)
public class ExColor2Fragment extends Fragment {

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


        mTextViewTitleExample.setText(R.string.criteria_color_ex2_title);
        mTextViewDescriptionExample.setText(R.string.criteria_color_ex2_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mLyOptionToUse.setVisibility(View.GONE);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myViewAxsYes = (LinearLayout) inflater.inflate(R.layout.excolor2_frag, null);
        LinearLayout myViewAxsNo = (LinearLayout) inflater.inflate(R.layout.excolor2_frag, null);

        //
        //ACCESSIBILITY YES
        //
        ImageView actif2 = (ImageView) myViewAxsYes.findViewById(R.id.imageView15);
        TextView tvmail = (TextView) myViewAxsYes.findViewById(R.id.textView42);
        tvmail.setContentDescription(getString(R.string.criteria_color_ex2_service)+" "+tvmail.getText().toString());
        actif2.setContentDescription(tvmail.getContentDescription()+" "+getString(R.string.criteria_color_ex2_cd_active));

        ImageView error2 = (ImageView) myViewAxsYes.findViewById(R.id.imageView17);
        TextView tvmusic = (TextView) myViewAxsYes.findViewById(R.id.textView41);
        tvmusic.setContentDescription(getString(R.string.criteria_color_ex2_service)+" "+tvmusic.getText().toString());
        error2.setContentDescription(tvmusic.getContentDescription()+" "+getString(R.string.criteria_color_ex2_cd_error));

        ImageView inactif2 = (ImageView) myViewAxsYes.findViewById(R.id.imageView19);
        TextView tvvideo = (TextView) myViewAxsYes.findViewById(R.id.textView43);
        tvvideo.setContentDescription(getString(R.string.criteria_color_ex2_service)+" "+tvvideo.getText().toString());
        inactif2.setContentDescription(tvvideo.getContentDescription()+" "+getString(R.string.criteria_color_ex2_cd_inactive));

        ImageView error3 = (ImageView) myViewAxsYes.findViewById(R.id.imageView21);
        TextView tvweb = (TextView) myViewAxsYes.findViewById(R.id.textView44);
        tvweb.setContentDescription(getString(R.string.criteria_color_ex2_service)+" "+tvweb.getText().toString());
        error3.setContentDescription(tvweb.getContentDescription()+" "+getString(R.string.criteria_color_ex2_cd_error));

        mFrameLayoutExampleAxsYes.addView(myViewAxsYes);

        //
        // ACCESSIBILITY NO
        //
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);

        myViewAxsNo.removeView(myViewAxsNo.findViewById(R.id.legendlayout));
        myViewAxsNo.removeView(myViewAxsNo.findViewById(R.id.virtualSeparator));

        ImageView ivNo1 = (ImageView) myViewAxsNo.findViewById(R.id.imageView15);
        TextView tv1 = (TextView) myViewAxsNo.findViewById(R.id.textView42);
        ImageView ivNo2 = (ImageView) myViewAxsNo.findViewById(R.id.imageView17);
        TextView tv2 = (TextView) myViewAxsNo.findViewById(R.id.textView41);
        ImageView ivNo3 = (ImageView) myViewAxsNo.findViewById(R.id.imageView19);
        TextView tv3 = (TextView) myViewAxsNo.findViewById(R.id.textView43);
        ImageView ivNo4 = (ImageView) myViewAxsNo.findViewById(R.id.imageView21);
        TextView tv4 = (TextView) myViewAxsNo.findViewById(R.id.textView44);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ivNo1.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            tv1.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            ivNo2.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            ivNo2.setImageDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.icon_circle));
            tv2.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            ivNo3.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            ivNo3.setImageDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.icon_circle));
            tv3.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            ivNo4.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
            ivNo4.setImageDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.icon_circle));
            tv4.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
        }else {
            ivNo2.setImageDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.icon_circle));
            ivNo3.setImageDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.icon_circle));
            ivNo4.setImageDrawable(ContextCompat.getDrawable(getActivity(),  R.drawable.icon_circle));
        }

        mFrameLayoutExampleAxsNo.addView(myViewAxsNo);
    }
}


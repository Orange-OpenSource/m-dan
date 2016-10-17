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

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExClickZone1Fragment extends Fragment{

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

        mTextViewTitleExample.setText(R.string.criteria_clickarea_title);
        mTextViewDescriptionExample.setText(R.string.criteria_clickarea_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        mLyOptionToUse.setVisibility(View.GONE);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myViewAxsYes = (LinearLayout) inflater.inflate(R.layout.exclickzone1_frag_lvl2, null);
        LinearLayout myViewAxsNo = (LinearLayout) inflater.inflate(R.layout.exclickzone1_frag_lvl2, null);
        TableRow tb = (TableRow) myViewAxsYes.findViewById(R.id.tableRow);

        float scale = getResources().getDisplayMetrics().density;

        //
        //Accessibility YES
        //
        ImageButton ibYes = (ImageButton) myViewAxsYes.findViewById(R.id.imageButtonplay);
        TextView titlemusic = (TextView) myViewAxsYes.findViewById(R.id.textView30);
        TextView authormusic = (TextView) myViewAxsYes.findViewById(R.id.textView31);
        ibYes.setContentDescription(getString(R.string.criteria_clickarea_ex1_play) + " " + titlemusic.getText());
        ibYes.setFocusable(false);
        tb.setContentDescription(getString(R.string.criteria_clickarea_ex1_music) + " " + titlemusic.getText() + " "+ getString(R.string.criteria_clickarea_ex1_author) + " " + authormusic.getText());

        ibYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getString(R.string.criteria_clickarea_ex1_success), Toast.LENGTH_SHORT).show();
            }
        });

        mFrameLayoutExampleAxsYes.addView(myViewAxsYes);

        //
        //Accessibility NO
        //
        ImageButton ibNo = (ImageButton) myViewAxsNo.findViewById(R.id.imageButtonplay);
        ibNo.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.play_bad_button_selector));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (12*scale + 0.5f), (int) (12*scale + 0.5f));
        layoutParams.gravity = Gravity.CENTER;
        ibNo.setLayoutParams(layoutParams);
        ibNo.setContentDescription(getString(R.string.criteria_clickarea_ex1_play) + " " + titlemusic.getText());
        ibNo.setFocusable(false);
        TableRow tbNo = (TableRow) myViewAxsNo.findViewById(R.id.tableRow);
        tbNo.setContentDescription(getString(R.string.criteria_clickarea_ex1_music) + " " + titlemusic.getText() + " "+ getString(R.string.criteria_clickarea_ex1_author) + " " + authormusic.getText());
        ibNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), getString(R.string.criteria_clickarea_ex1_success), Toast.LENGTH_SHORT).show();
            }
        });
        mFrameLayoutExampleAxsNo.addView(myViewAxsNo);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}


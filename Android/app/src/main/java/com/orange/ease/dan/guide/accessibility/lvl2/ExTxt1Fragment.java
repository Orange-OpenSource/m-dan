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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExTxt1Fragment extends Fragment {

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

        mTextViewTitleExample.setText(R.string.criteria_alt_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_alt_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.extxt1_frag, null);
        mFrameLayoutExampleAxsYes.addView(myView);

        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);

        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.extxt1_frag, null);
        myView2.removeView(myView2.findViewById(R.id.ex3txt1));
        mFrameLayoutExampleAxsNo.addView(myView2);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.date_format), Locale.getDefault());
        String date = sdf.format(c.getTime());

        String monthName = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

        TextView ex1 = (TextView) mFrameLayoutExampleAxsYes.findViewById(R.id.ex1txt1);
        TextView ex2 = (TextView) mFrameLayoutExampleAxsYes.findViewById(R.id.ex2txt1);
        TextView ex3 = (TextView) mFrameLayoutExampleAxsYes.findViewById(R.id.ex3txt1);
        TextView ex4 = (TextView) mFrameLayoutExampleAxsYes.findViewById(R.id.ex4txt1);

        ex1.setText(date);
        ex1.setContentDescription(c.get(Calendar.DAY_OF_MONTH) + " " + monthName + " " + c.get(Calendar.YEAR) + " , " + (c.get(Calendar.HOUR) + 12) + " " + getString(R.string.heure) + " " + c.get(Calendar.MINUTE));

        ex2.setContentDescription(getString(R.string.criteria_alt_ex1_cd_txt1));
        ex3.setContentDescription(getString(R.string.criteria_alt_ex1_cd_txt2));
        ex4.setContentDescription(getString(R.string.criteria_alt_ex1_cd_txt3));

        TextView ex1AxsNo = (TextView) myView2.findViewById(R.id.ex1txt1);
        ex1AxsNo.setText(date);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}

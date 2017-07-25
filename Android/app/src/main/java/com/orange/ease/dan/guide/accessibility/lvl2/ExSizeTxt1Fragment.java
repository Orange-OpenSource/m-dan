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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
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
public class ExSizeTxt1Fragment extends Fragment {

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
        mOnNewFragment.initAlertDialogOptions(1);
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

        mTextViewTitleExample.setText(R.string.criteria_textsize_title);
        mTextViewDescriptionExample.setText(R.string.criteria_textsize_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_largetext));

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.exsizetxt1_frag, null);

        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.exsizetxt1_frag, null);

        TextView tvNo = (TextView) myView.findViewById(R.id.textView34);
        myView.removeView(tvNo);

        mFrameLayoutExampleAxsYes.addView(myView);
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        myView2.removeView(myView2.findViewById(R.id.textView33));
        mFrameLayoutExampleAxsNo.addView(tvNo);
    }
    public void initAlertDialogStartActivity() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage(getString(R.string.alert_before_leaving));
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Oui",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
                    }
                });
        builder1.setNegativeButton(
                "Non",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
        Button button0 = alert11.getButton(AlertDialog.BUTTON_POSITIVE);
        button0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getActivity(), R.drawable.icon_check_good), null, null, null);
        button0.setContentDescription("Oui");
        button0.setText("");
        Button button1 = alert11.getButton(AlertDialog.BUTTON_NEGATIVE);
        button1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getActivity(), R.drawable.icon_check_bad), null, null, null);
        button1.setContentDescription("Non");
        button1.setText("");
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle((getString(R.string.example)+" "+"1/1"),true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}

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
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
public class ExReadOrder1Fragment extends Fragment {

    private String mTitle = "";
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

    private void setNextFocus(View view, int upid, int downid, int leftid, int rightid, int forwardid) {
        view.setNextFocusUpId(upid);
        view.setNextFocusDownId(downid);
        view.setNextFocusLeftId(leftid);
        view.setNextFocusRightId(rightid);
        view.setNextFocusForwardId(forwardid);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTextViewTitleExample.setText(R.string.criteria_readorder_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_readorder_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.exreadorder_frag, null);

        ImageView volup = (ImageView) myView.findViewById(R.id.volup);
        ImageView voldown = (ImageView) myView.findViewById(R.id.voldown);
        ImageView chaineplus = (ImageView) myView.findViewById(R.id.chaineplus);
        ImageView chainemoins = (ImageView) myView.findViewById(R.id.chainemoins);
        Button remote1 = (Button) myView.findViewById(R.id.remote1);
        Button remote2 = (Button) myView.findViewById(R.id.remote2);
        Button remote3 = (Button) myView.findViewById(R.id.remote3);
        Button remote4 = (Button) myView.findViewById(R.id.remote4);
        Button remote5 = (Button) myView.findViewById(R.id.remote5);
        Button remote6 = (Button) myView.findViewById(R.id.remote6);
        Button remote7 = (Button) myView.findViewById(R.id.remote7);
        Button remote8 = (Button) myView.findViewById(R.id.remote8);
        Button remote9 = (Button) myView.findViewById(R.id.remote9);
        Button remote0 = (Button) myView.findViewById(R.id.remote0);

        volup.setContentDescription(getString(R.string.criteria_readorder_ex1_volup));
        voldown.setContentDescription(getString(R.string.criteria_readorder_ex1_voldown));
        chaineplus.setContentDescription(getString(R.string.criteria_readorder_ex1_canalup));
        chainemoins.setContentDescription(getString(R.string.criteria_readorder_ex1_canaldown));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            remote1.setAccessibilityTraversalAfter(mTextViewTitleExempleAxsYes.getId());
            remote2.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote1).getId());
            remote3.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote2).getId());
            remote4.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote3).getId());
            remote5.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote4).getId());
            remote6.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote5).getId());
            remote7.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote6).getId());
            remote8.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote7).getId());
            remote9.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote8).getId());
            remote0.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote9).getId());
            volup.setAccessibilityTraversalAfter(myView.findViewById(R.id.remote0).getId());
            voldown.setAccessibilityTraversalAfter(myView.findViewById(R.id.volup).getId());
            chaineplus.setAccessibilityTraversalAfter(myView.findViewById(R.id.voldown).getId());
            chainemoins.setAccessibilityTraversalAfter(myView.findViewById(R.id.chaineplus).getId());
        }

        setNextFocus(mTextViewTitleExempleAxsYes, 0, volup.getId(), 0, 0, volup.getId());
        setNextFocus(volup, 0, voldown.getId(), chaineplus.getId(), remote1.getId(), voldown.getId());
        setNextFocus(voldown, volup.getId(), remote7.getId(), chainemoins.getId(), remote4.getId(), chaineplus.getId());
        setNextFocus(remote1, 0, remote4.getId(), volup.getId(), remote2.getId(), remote2.getId());
        setNextFocus(remote2, 0, remote5.getId(), remote1.getId(), remote3.getId(), remote3.getId());
        setNextFocus(remote3, 0, remote6.getId(), remote2.getId(), chaineplus.getId(), remote4.getId());
        setNextFocus(remote4, remote1.getId(), remote7.getId(), volup.getId(), remote5.getId(), remote5.getId());
        setNextFocus(remote5, remote2.getId(), remote8.getId(), remote4.getId(), remote6.getId(), remote6.getId());
        setNextFocus(remote6, remote3.getId(), remote9.getId(), remote5.getId(), chaineplus.getId(), remote7.getId());
        setNextFocus(remote7, remote4.getId(), remote0.getId(), voldown.getId(), remote8.getId(), remote8.getId());
        setNextFocus(remote8, remote5.getId(), remote0.getId(), remote7.getId(), remote9.getId(), remote9.getId());
        setNextFocus(remote9, remote6.getId(), remote0.getId(), remote8.getId(), chainemoins.getId(), remote0.getId());
        setNextFocus(remote0, remote8.getId(), mTextViewTitleExempleAxsNo.getId(), remote7.getId(), remote9.getId(), volup.getId());
        setNextFocus(chaineplus, 0, chainemoins.getId(), remote3.getId(), volup.getId(), chainemoins.getId());
        setNextFocus(chainemoins, chaineplus.getId(), remote9.getId(), remote6.getId(), voldown.getId(), mTextViewTitleExempleAxsNo.getId());

        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.exreadorder_frag, null);
        mFrameLayoutExampleAxsYes.addView(myView);
        mFrameLayoutExampleAxsNo.addView(myView2);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}

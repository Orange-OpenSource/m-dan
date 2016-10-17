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

package com.orange.ease.dan.examplesFragmentsLvl1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.examplesFragmentsLvl2.ExColor1Fragment_;
import com.orange.ease.dan.examplesFragmentsLvl2.ExColor2Fragment_;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.criteria_template)
public class ExampleColorFragment extends ListFragment {

    private String mNextTitle = "";
    private OnNewFragment mOnNewFragment;

    public TextView mHeaderCriteriaWhyLabel;
    public TextView mHeaderCriteriaWhyDescription;
    public TextView mHheaderCriteriaRuleLabel;
    public TextView mHeaderCriteriaRuleDescription;
    public TextView mHeaderCriteriaListLabel;
    public View mHeaderView;

    @ViewById(android.R.id.list)
    public ListView mExampleList;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.criteria_template, container, false);
    }

    @AfterViews
    void initHeaderView(){
        mHeaderView = getActivity().getLayoutInflater().inflate(R.layout.header_criteria, null);

        // init class variable
        mHeaderCriteriaWhyLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaWhyLabel);
        mHeaderCriteriaWhyDescription = (TextView) mHeaderView.findViewById(R.id.headerCriteriaWhyDescription);
        mHheaderCriteriaRuleLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaRuleLabel);
        mHeaderCriteriaRuleDescription = (TextView) mHeaderView.findViewById(R.id.headerCriteriaRuleDescription);
        mHeaderCriteriaListLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaListLabel);

        //for accessibility : force Talckback focus on all element
        mHeaderCriteriaWhyLabel.setFocusable(true);
        mHeaderCriteriaWhyDescription.setFocusable(true);
        mHheaderCriteriaRuleLabel.setFocusable(true);
        mHeaderCriteriaRuleDescription.setFocusable(true);
        mHeaderCriteriaListLabel.setFocusable(true);

        //add the header to the list
        mExampleList.addHeaderView(mHeaderView);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mHeaderCriteriaWhyLabel.setText(R.string.criteria_template_why);
        mHeaderCriteriaWhyDescription.setText(R.string.criteria_color_why_description);
        mHheaderCriteriaRuleLabel.setText(R.string.criteria_template_rule);
        mHeaderCriteriaRuleDescription.setText(R.string.criteria_color_rule_description);
        mHeaderCriteriaListLabel.setText(R.string.criteria_template_example);
        String[] items = getResources().getStringArray(R.array.criteria_color_list);
        mHeaderCriteriaListLabel.setContentDescription(items.length + " " +getString(R.string.example));
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_text, R.id.textCategory, items);
        setListAdapter(aa);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;

        mNextTitle = getString(R.string.example)+" "+(position)+"/"+"2";

        switch (position) {
            case 1:
                newFragment = new ExColor1Fragment_();
                break;
            case 2:
                newFragment = new ExColor2Fragment_();
                break;
            default:
                break;
        }

        if (newFragment != null) {
            mOnNewFragment.onNewFragment(newFragment, mNextTitle, true);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(R.string.criteria_color_title),true);
    }
}

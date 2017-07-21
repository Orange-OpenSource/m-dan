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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.orange.ease.dan.BaseListFragment;
import com.orange.ease.dan.R;
import com.orange.ease.dan.examplesFragmentsLvl2.ExForm1Fragment_;
import com.orange.ease.dan.examplesFragmentsLvl2.ExImg3Fragment_;
import com.orange.ease.dan.examplesFragmentsLvl2.ExStateElmts1Fragment_;
import com.orange.ease.dan.examplesFragmentsLvl2.ExTxt1Fragment_;
import com.orange.ease.dan.examplesFragmentsLvl2.ExTxt2Fragment_;
import com.orange.ease.dan.examplesFragmentsLvl2.ExTxt3FootballFragment_;

import org.androidannotations.annotations.EFragment;

/**
 * Created by Clément Roussillon on 12/02/16.
 *
 * Modified by Frédéric Coudurier on 26/02/16
 */
@EFragment(R.layout.criteria_template)
public class ExampleAltFragment extends BaseListFragment {

    private String mNextTitle = "";

    public TextView mHeaderCriteriaWhyLabel;
    public TextView mHeaderCriteriaWhyDescription;
    public TextView mHheaderCriteriaRuleLabel;
    public TextView mHeaderCriteriaRuleDescription;
    public TextView mHeaderCriteriaListLabel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.criteria_template, container, false);
    }


    @Override
    protected void initHeader() {
        mHeaderView = getActivity().getLayoutInflater().inflate(R.layout.header_criteria, null);

        // init class variable
        mHeaderCriteriaWhyLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaWhyLabel);
        mHeaderCriteriaWhyDescription = (TextView) mHeaderView.findViewById(R.id.headerCriteriaWhyDescription);
        mHheaderCriteriaRuleLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaRuleLabel);
        mHeaderCriteriaRuleDescription = (TextView) mHeaderView.findViewById(R.id.headerCriteriaRuleDescription);
        mHeaderCriteriaListLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaListLabel);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mHeaderCriteriaWhyLabel.setText(R.string.criteria_template_why);
        mHeaderCriteriaWhyDescription.setText(getString(R.string.criteria_alt_why_description));
        mHheaderCriteriaRuleLabel.setText(R.string.criteria_template_rule);
        mHeaderCriteriaRuleDescription.setText(getString(R.string.criteria_alt_rule_description));
        mHeaderCriteriaListLabel.setText(R.string.criteria_template_example);


        String[] items = getResources().getStringArray(R.array.criteria_alt_list);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_text, R.id.textCategory, items);

        setListAdapter(aa);
        mHeaderCriteriaListLabel.setContentDescription(items.length + " " +getString(R.string.example));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;

        mNextTitle = getString(R.string.example)+" "+(position)+"/6";

        switch (position) {
            case 1:
                newFragment = new ExImg3Fragment_();
                break;
            case 2:
                newFragment = new ExStateElmts1Fragment_();
                break;
            case 3:
                newFragment = new ExForm1Fragment_();
                break;
            case 4:
                newFragment = new ExTxt1Fragment_();
                break;
            case 5:
                newFragment = new ExTxt2Fragment_();
                break;
            case 6:
                newFragment = new ExTxt3FootballFragment_();
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
    protected int getTitleResource() {
        return R.string.criteria_alt_title;
    }
}

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

package com.orange.ease.dan.navFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleAltFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleClickZoneFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleColorFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleContentChangeFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleContentControlFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleElementsStateFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleFocusNavigationFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleFormFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleGhostElementFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleImgFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleReadOrderFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleScrollFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleStandardComponentFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleTitlesFragment_;
import com.orange.ease.dan.examplesFragmentsLvl1.ExampleTxtSizeFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_exemple)
public class GuideFragment extends ListFragment {

    private String mTitle = "";
    private OnNewFragment mOnNewFragment;

    public TextView mCriteriaLabel;
    public TextView mCriteriaDescription;
    public TextView mCriteriaListLabel;
    public View mHeaderView;

    @ViewById(android.R.id.list)
    public ListView mCriteriaList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exemple, container, false);
    }

    @AfterViews
    void initHeaderView(){
        mHeaderView = getActivity().getLayoutInflater().inflate(R.layout.header, null);
        mCriteriaList.addHeaderView(mHeaderView);

        mCriteriaLabel = (TextView) mHeaderView.findViewById(R.id.headerLabel);
        mCriteriaDescription = (TextView) mHeaderView.findViewById(R.id.headerDescription);
        mCriteriaListLabel = (TextView) mHeaderView.findViewById(R.id.headerListLabel);
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

        mCriteriaLabel.setText(R.string.criteria_description_title);
        mCriteriaDescription.setText(R.string.criteria_description_content);
        mCriteriaListLabel.setText(R.string.criteria_sections);

        String[] items = getResources().getStringArray(R.array.criteria_list);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_text, R.id.textCategory, items);

        setListAdapter(aa);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.main_menu_group, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;

        switch (position) {
            case 1:
                mTitle = getString(R.string.criteria_img_title);
                newFragment = new ExampleImgFragment_();
                break;
            case 2:
                mTitle = getString(R.string.criteria_color_title);
                newFragment = new ExampleColorFragment_();
                break;
            case 3:
                mTitle = getString(R.string.criteria_alt_title);
                newFragment = new ExampleAltFragment_();
                break;
            case 4:
                mTitle = getString(R.string.criteria_title_title);
                newFragment = new ExampleTitlesFragment_();
                break;
            case 5:
                mTitle = getString(R.string.criteria_stateelements_title);
                newFragment = new ExampleElementsStateFragment_();
                break;
            case 6:
                mTitle = getString(R.string.criteria_standardcomponent_title);
                newFragment = new ExampleStandardComponentFragment_();
                break;
            case 7:
                mTitle = getString(R.string.criteria_clickarea_title);
                newFragment = new ExampleClickZoneFragment_();
                break;
            case 8:
                mTitle = getString(R.string.criteria_ghostelement_title);
                newFragment = new ExampleGhostElementFragment_();
                break;
            case 9:
                mTitle = getString(R.string.criteria_textsize_title);
                newFragment = new ExampleTxtSizeFragment_();
                break;
            case 10:
                mTitle = getString(R.string.criteria_contentcontrol_title);
                newFragment = new ExampleContentControlFragment_();
                break;
            case 11:
                mTitle = getString(R.string.criteria_title_contentchange);
                newFragment = new ExampleContentChangeFragment_();
                break;
            case 12:
                mTitle = getString(R.string.criteria_horizontalscroll_title);
                newFragment = new ExampleScrollFragment_();
                break;
            case 13:
                mTitle = getString(R.string.criteria_form_title);
                newFragment = new ExampleFormFragment_();
                break;
            case 14:
                mTitle = getString(R.string.criteria_readorder_title);
                newFragment = new ExampleReadOrderFragment_();
                break;
            case 15:
                mTitle = getString(R.string.criteria_focusnav_title);
                newFragment = new ExampleFocusNavigationFragment_();
                break;
            default:
                break;
        }

        if (newFragment != null) {
            mOnNewFragment.onNewFragment(newFragment, mTitle, true);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(R.string.section_criteria),true);
    }
}

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
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.orange.ease.dan.GuideDevFragments.GuideDevFocusNavFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevFormsFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevListVocFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevLiveFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevMaskFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevReadOrderFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevTalkbackFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevTxtSizeFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevVocFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevWebViewFragment_;
import com.orange.ease.dan.R;
import com.orange.ease.dan.GuideDevFragments.GuideDevAltFragment_;
import com.orange.ease.dan.GuideDevFragments.GuideDevAxsEvenmentsFragment_;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by ILSA6593 on 09/02/2016.
 */
@EFragment(R.layout.fragment_exemple)
public class GuideDevFragment extends ListFragment {

    private String mTitle = "";
    private OnNewFragment mOnNewFragment;
    private String[] mItems;

    public TextView mDevOptionsLabel;
    public TextView mDevOptionsDescription;
    public TextView mDevOptionsListLabel;
    public ImageView mSplitImage;
    public View mHeaderView;

    @ViewById(android.R.id.list)
    public ListView mDevOptionList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exemple, container, false);
    }

    @AfterViews
    void initHeaderView(){
        mHeaderView = getActivity().getLayoutInflater().inflate(R.layout.header, null);
        mHeaderView.findViewById(R.id.virtualSeparator).setVisibility(View.GONE);
        mHeaderView.findViewById(R.id.headerInformation).setVisibility(View.GONE);
        mDevOptionList.addHeaderView(mHeaderView);

        mDevOptionsLabel = (TextView) mHeaderView.findViewById(R.id.headerLabel);
        mDevOptionsDescription = (TextView) mHeaderView.findViewById(R.id.headerDescription);
        mDevOptionsListLabel = (TextView) mHeaderView.findViewById(R.id.headerListLabel);
        mSplitImage = (ImageView)  mHeaderView.findViewById(R.id.splitImage);
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

        mSplitImage.setBackgroundResource(R.drawable.dev_illustration);
        mDevOptionsLabel.setText(R.string.dev_description_title);
        mDevOptionsDescription.setText(R.string.dev_description_content);
        mDevOptionsListLabel.setText(R.string.dev_sections);
        mDevOptionsListLabel.setContentDescription(getString(R.string.alert_before_leaving));

        mItems = getResources().getStringArray(R.array.dev_list);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_text, R.id.textCategory, mItems);
        setListAdapter(aa);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;

        switch (position) {
            case 1:
                mTitle = mItems[0];
                newFragment = new GuideDevAltFragment_();
                break;
            case 2:
                mTitle = mItems[1];
                newFragment = new GuideDevMaskFragment_();
                break;
            case 3:
                mTitle = mItems[2];
                newFragment = new GuideDevVocFragment_();
                break;
            case 4:
                mTitle = mItems[3];
                newFragment = new GuideDevTalkbackFragment_();
                break;
            case 5:
                mTitle = mItems[4];
                newFragment = new GuideDevLiveFragment_();
                break;
            case 6:
                mTitle = mItems[5];
                newFragment = new GuideDevReadOrderFragment_();
                break;
            case 7:
                mTitle = mItems[6];
                newFragment = new GuideDevFormsFragment_();
                break;
            case 8:
                mTitle = mItems[7];
                newFragment = new GuideDevTxtSizeFragment_();
                break;
            case 9:
                mTitle = mItems[8];
                newFragment = new GuideDevAxsEvenmentsFragment_();
                break;
            case 10:
                mTitle = mItems[9];
                newFragment = new GuideDevWebViewFragment_();
                break;
            case 11:
                mTitle = mItems[10];
                newFragment = new GuideDevListVocFragment_();
                break;
            case 12:
                mTitle = mItems[11];
                newFragment = new GuideDevFocusNavFragment_();
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
        mOnNewFragment.setTemplateTitle(getString(R.string.section_dev),true);
    }
}


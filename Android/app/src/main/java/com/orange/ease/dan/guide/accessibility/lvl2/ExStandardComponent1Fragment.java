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
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter;
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.*;
import com.orange.ease.dan.navFragments.OnNewFragment;
import com.orange.ease.dan.utils.Utils;
import com.orange.ease.idunnololz.widgets.AnimatedExpandableListView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExStandardComponent1Fragment extends Fragment {

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

    @ViewById(R.id.imageView9)
    public ImageView mImageViewCheckYes;

    @ViewById(R.id.textViewOptionEnabled)
    public TextView mTextViewOptionEnabled;

    public ExpandableListView mExpandableListViewAxsMore;
    public AnimatedExpandableListView mExpandableListView;
    private ExpandableListAdapter mExpandableListAdapterMore;
    private CustomExpandableListViewAdapter mExpandableListAdapter;
    private List<String> mExpandableListTitle;
    private HashMap<String, List<String>> mExpandableListDetail;

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

        mTextViewTitleExample.setText(R.string.criteria_standardcomponent_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_standardcomponent_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example_more);
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));
        mImageViewCheckYes.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.icon_check_good));

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        /* Standard expandable list view augmented with accessibility */
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.exstandardcomponent1_frag, null);
        mExpandableListViewAxsMore = (ExpandableListView) myView.findViewById(R.id.expandableListView);
        mExpandableListDetail = ExpandableListDataPump.getData(getContext());
        mExpandableListTitle = new ArrayList<>(mExpandableListDetail.keySet());
        mExpandableListAdapterMore = new com.orange.ease.dan.adapter.ExpandableListAdapter(getContext(), mExpandableListTitle, mExpandableListDetail, true);
        mExpandableListViewAxsMore.setAdapter(mExpandableListAdapterMore);
        Utils.setListViewHeightBasedOnItems(mExpandableListViewAxsMore);
        mExpandableListViewAxsMore.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Utils.setListViewHeightBasedOnItems(mExpandableListViewAxsMore);
            }
        });

        mExpandableListViewAxsMore.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Utils.setListViewHeightBasedOnItems(mExpandableListViewAxsMore);
            }
        });

        mFrameLayoutExampleAxsYes.addView(myView);


        /* Custom expandable list view augmented with accessibility */
        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.exstateelmts3_frag, null);
        List<GroupItem> items = new ArrayList<>();

        // Populate our list with groups and it's children
        for(int i = 1; i < 3; i++) {
            GroupItem item = new GroupItem();

            item.setTitle(getString(R.string.criteria_stateelement_ex3_grp) + i);

            for(int j = 0; j < i; j++) {
                ChildItem child = new ChildItem();
                child.setTitle(getString(R.string.criteria_stateelement_ex3_item) + j);
                child.setHint("lorem ipsum");

                item.addItem(child);
            }

            items.add(item);
        }

        mExpandableListAdapter = new CustomExpandableListViewAdapter(getActivity());
        mExpandableListAdapter.setData(items);

        mExpandableListView = (AnimatedExpandableListView) myView2.findViewById(R.id.expandableListView);
        mExpandableListView.setAdapter(mExpandableListAdapter);

        Utils.setListViewHeightBasedOnItems(mExpandableListView);

        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (mExpandableListView.isGroupExpanded(groupPosition)) {
                    mExpandableListView.collapseGroupWithAnimation(groupPosition);
                    Utils.setListViewHeightBasedOnItems(mExpandableListView);
                } else {
                    mExpandableListView.expandGroupWithAnimation(groupPosition);
                    Utils.setListViewHeightBasedOnItems(mExpandableListView);
                }
                return true;
            }

        });

        mFrameLayoutExampleAxsNo.addView(myView2);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}

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
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExStateElmts1Fragment extends Fragment {

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTextViewTitleExample.setText(R.string.criteria_stateelement_ex1_title);
        mTextViewDescriptionExample.setText(R.string.criteria_stateelement_ex1_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout myView = (LinearLayout) inflater.inflate(R.layout.exstateelmts1_frag, null);
        mFrameLayoutExampleAxsYes.addView(myView);

        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);

        LinearLayout myView2 = (LinearLayout) inflater.inflate(R.layout.exstateelmts1_frag, null);

        mFrameLayoutExampleAxsNo.addView(myView2);

        //HostYesAxs
        String[] tabslabs = new String[2];
        tabslabs[0] = getString(R.string.criteria_stateelement_ex1_public);
        tabslabs[1] = getString(R.string.criteria_stateelement_ex1_private);
        TabHost hostYes = initTabHost(myView);
        hostYes.setOnTabChangedListener(new TabHostListener(hostYes, tabslabs));
       setContentDescription(hostYes, tabslabs);

        for (int i = 0; i < hostYes.getTabWidget().getChildCount(); i++)
            hostYes.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_selector);

        //HostNoAxs
        TabHost hostNo = initTabHost(myView2);
        for (int i = 0; i < hostNo.getTabWidget().getChildCount(); i++)
            hostNo.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_selector);

    }

    private TabHost initTabHost(LinearLayout view) {
        TabHost host = (TabHost) view.findViewById(R.id.tabHost);
        host.setup();
        //Tab 1
        TabHost.TabSpec spec ;
        spec = host.newTabSpec(getString(R.string.criteria_stateelement_ex1_public));
        spec.setContent(view.findViewById(R.id.tab1).getId());
        spec.setIndicator(getString(R.string.criteria_stateelement_ex1_public));
        host.addTab(spec);
        //Tab 2
        spec = host.newTabSpec(getString(R.string.criteria_stateelement_ex1_private));
        spec.setContent(view.findViewById(R.id.tab2).getId());
        spec.setIndicator(getString(R.string.criteria_stateelement_ex1_private));
        host.addTab(spec);

        return host;
    }

    private class TabHostListener implements TabHost.OnTabChangeListener {

        private TabHost mTabHost;
        private String[] mTabsLabel;

        public TabHostListener(TabHost tabHost, String[] tabsLabel) {
            mTabHost = tabHost;
            mTabsLabel = tabsLabel;
        }

        public void onTabChanged(String tabId) {
            setContentDescription(mTabHost, mTabsLabel);
        }
    }

    private void setContentDescription(TabHost mTabHost, String[] mTabsLabel) {

        int tab = mTabHost.getCurrentTab();
        int tabCount = mTabHost.getTabWidget().getTabCount();

        for (int tabNumber = 0; tabNumber < tabCount; tabNumber++) {
            CharSequence contentDescription = mTabsLabel[tabNumber];

            contentDescription = contentDescription + ", onglet " + (tabNumber + 1) + " sur " + tabCount;
            if (tabNumber == tab) {
                contentDescription = contentDescription + ", sélectionné";
            }
            mTabHost.getTabWidget().getChildAt(tabNumber).setContentDescription(contentDescription);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}
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

package com.orange.ease.dan.guide.talkback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.orange.ease.dan.R;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class GestureActivity extends AppCompatActivity {

    @ViewById(R.id.my_toolbar)
    protected Toolbar mToolbar;

    @AfterViews
    void init() {
        setSupportActionBar(mToolbar);

        // init the default fragment showed
        Fragment fragment = new GestureFragment_();
        Bundle bundle = new Bundle();
        bundle.putInt("nbStep", 11);
        bundle.putInt("currentStep", 1);
        fragment.setArguments(bundle);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        final FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.container, fragment);
        ft.commit();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.tb_tuto_title));
            actionBar.setDisplayShowTitleEnabled(true);
            //init close button
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.icon_popin_close);
        }
        mToolbar.setNavigationContentDescription(getString(R.string.tb_tuto_close));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}

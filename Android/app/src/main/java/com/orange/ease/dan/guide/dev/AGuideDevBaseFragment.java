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

package com.orange.ease.dan.guide.dev;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.orange.ease.dan.BaseFragment;
import com.orange.ease.dan.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;



@EFragment(R.layout.guidedev_helps_template)
public abstract class AGuideDevBaseFragment extends BaseFragment {

    @StringRes
    abstract protected int getDescription();

    @StringRes
    abstract protected int getLink();

    @StringRes
    abstract protected int getTitle() ;

    @ViewById(R.id.textViewTitleDescriptionGuideDev)
    public TextView mTextViewTitleDescriptionGuideDev;

    @ViewById(R.id.textViewDescriptionContentGuideDev)
    public TextView mTextViewDescriptionContentGuideDev;

    @ViewById(R.id.textViewTitleLinksGuideDev)
    public TextView mTextViewTitleLinksGuideDev;

    @ViewById(R.id.textViewContentLinksGuideDev)
    public TextView mTextViewContentLinksGuideDev;

    @AfterViews
    void updateViews() {
        mTextViewTitleDescriptionGuideDev.setText(R.string.dev_description);
        mTextViewDescriptionContentGuideDev.setText(getDescription());
        setLink();
    }

    protected void setLink() {
        mTextViewTitleLinksGuideDev.setText(R.string.dev_link);
        mTextViewContentLinksGuideDev.setText(getLink());
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getTitle());
    }
}


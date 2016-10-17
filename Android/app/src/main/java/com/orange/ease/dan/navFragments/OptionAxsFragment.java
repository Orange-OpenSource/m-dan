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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.optionsFragments.ColorCorrectionFragment_;
import com.orange.ease.dan.optionsFragments.ColorInversionFragment_;
import com.orange.ease.dan.optionsFragments.TextSizeFragment_;
import com.orange.ease.dan.optionsFragments.ZoomFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by NQDW8882 on 10/02/2016.
 */
@EFragment(R.layout.fragment_options)
public class OptionAxsFragment extends ListFragment {

    private OnNewFragment mOnNewFragment;
    private String mTitle = "";
    private String[] items;

    public View mHeaderView;
    public TextView mTextViewDescriptionOptAxs;
    public Button mButtonOptAxs;

    @ViewById(android.R.id.list)
    public ListView mListOptionsAxs;

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
        return inflater.inflate(R.layout.fragment_options, container, false);
    }

    @AfterViews
    void initHeaderView(){
        //mHeaderView = getActivity().getLayoutInflater().inflate(R.layout.fragment_options, null);
        //mListOptionsAxs.addHeaderView(mHeaderView);
        mTextViewDescriptionOptAxs = (TextView) getView().findViewById(R.id.textViewDescriptionOptAxs);
        mButtonOptAxs = (Button) getView().findViewById(R.id.buttonOptionsAxs);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTextViewDescriptionOptAxs.setText(R.string.options_content);

        mButtonOptAxs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAlertDialogStartActivity();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            items = getResources().getStringArray(R.array.options_list);
        }else {
            items = getResources().getStringArray(R.array.options_list2);
        }
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_text, R.id.textCategory, items);

        setListAdapter(aa);
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(R.string.section_axs_options),true);
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
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Fragment newFragment = null;
        mTitle = items[position];

        switch (position) {
            case 0:
                newFragment = new TextSizeFragment_();
                break;
            case 1:
                newFragment = new ZoomFragment_();
                break;
            case 2:
                newFragment = new ColorCorrectionFragment_();
                break;
            case 3:
                newFragment = new ColorInversionFragment_();
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
}
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
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 10/02/16.
 */
@EFragment(R.layout.fragment_axsorange)
public class AxsOrangeFragment extends Fragment {

    private OnNewFragment mOnNewFragment;

    @ViewById(R.id.imgViewLogoAxsOrange)
    public ImageView mImgViewLogoAxsOrange;

    @ViewById(R.id.textViewTitleAxsOrange)
    public TextView mTextViewTitleAxsOrange;

    @ViewById(R.id.textViewContentAxsOrange)
    public TextView mTextViewContentAxsOrange;

    @ViewById(R.id.textViewTitleApplicationsAxsOrange)
    public TextView mTextViewTitleApplicationsAxsOrange;

    @ViewById(R.id.gridLayoutApplicationsAxsOrange)
    public GridLayout mGridLayoutApplicationsAxsOrange;

    @ViewById(R.id.imgButtonMyBoutiquesOrange)
    public ImageButton mImgButtonMyBoutiquesOrange;

    @ViewById(R.id.imgButtonOrangeTV)
    public ImageButton mImgButtonOrangeTV;

    @ViewById(R.id.imgButtonMyOrange)
    public ImageButton mImgButtonMyOrange;

    @ViewById(R.id.imgButtonFootballClub)
    public ImageButton mImgButtonFootballClub;

    @ViewById(R.id.textViewMyBoutiquesOrange)
    public TextView mTextViewMyReseauOrange;

    @ViewById(R.id.textViewMyOrange)
    public TextView mTextViewMyOrange;

    @ViewById(R.id.textViewOrangeTV)
    public TextView mTextViewMyLivebox;

    @ViewById(R.id.textViewFootballClub)
    public TextView mTextViewFootballClub;

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

        mTextViewTitleAxsOrange.setText(R.string.orange_title);
        mTextViewContentAxsOrange.setText(R.string.orange_content);
        mTextViewTitleApplicationsAxsOrange.setText(R.string.orange_accessible_app);

        mTextViewMyReseauOrange.setText(getString(R.string.orange_monreseau));
        mTextViewMyOrange.setText(getString(R.string.orange_orangeetmoi));
        mTextViewMyLivebox.setText(getString(R.string.orange_malivebox));
        mTextViewFootballClub.setText(getString(R.string.orange_orangefootballclub));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mImgButtonMyBoutiquesOrange.setLabelFor(R.id.textViewMyBoutiquesOrange);
            mImgButtonOrangeTV.setLabelFor(R.id.textViewMyOrange);
            mImgButtonMyOrange.setLabelFor(R.id.textViewOrangeTV);
            mImgButtonFootballClub.setLabelFor(R.id.textViewFootballClub);
        }
        mImgButtonMyBoutiquesOrange.setOnClickListener(new OnClicklistener());
        mImgButtonOrangeTV.setOnClickListener(new OnClicklistener());
        mImgButtonMyOrange.setOnClickListener(new OnClicklistener());
        mImgButtonFootballClub.setOnClickListener(new OnClicklistener());
        mImgButtonMyBoutiquesOrange.setContentDescription(getString(R.string.orange_cd_app)+" "+ mTextViewMyReseauOrange.getText());
        mImgButtonOrangeTV.setContentDescription(getString(R.string.orange_cd_app)+" "+ mTextViewMyLivebox.getText());
        mImgButtonMyOrange.setContentDescription(getString(R.string.orange_cd_app)+" "+ mTextViewMyOrange.getText());
        mImgButtonFootballClub.setContentDescription(getString(R.string.orange_cd_app)+" "+ mTextViewFootballClub.getText());
    }

    public class OnClicklistener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String packageName="";
            if(v.getId()==R.id.imgButtonMyBoutiquesOrange){
                packageName = "com.orange.wifiorange";
            }
            if (v.getId() == R.id.imgButtonMyOrange) {
                packageName="com.orange.orangeetmoi";
            }
            if (v.getId() == R.id.imgButtonOrangeTV) {
                packageName = "com.orange.mylivebox.fr";
            }
            if(v.getId()==R.id.imgButtonFootballClub){
                packageName="com.orange.ofc";
            }
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
            builder1.setMessage(getString(R.string.alert_before_leaving));
            builder1.setCancelable(true);

            final String finalPackageName = packageName;
            builder1.setPositiveButton(
                    "Oui",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            startNewActivity(getActivity(), finalPackageName);
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
    }

    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(R.string.section_axs_orange),true);
    }
}

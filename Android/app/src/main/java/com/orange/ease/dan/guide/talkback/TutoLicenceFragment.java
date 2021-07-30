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

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_tuto_end)
public class TutoLicenceFragment extends Fragment {

    private int mNbStep;
    private int mCurrentStep;

    @ViewById(R.id.textViewInfosDescription)
    public TextView mTxtViewInfosDescritpion;

    @ViewById(R.id.textViewLicence)
    public TextView mTxtViewLicence;

    @ViewById(R.id.textViewStep)
    public TextView mTxtViewStep;

    @ViewById(R.id.buttonNext)
    public Button mButtonNext;

    @ViewById(R.id.buttonPrevious)
    public Button mButtonPrevious;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        mNbStep = bundle.getInt("nbStep", 11); //11 steps in this tuto
        mCurrentStep = bundle.getInt("currentStep", 1); //From 1 to nbStep
        return inflater.inflate(R.layout.fragment_tuto_end, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new GestureFragment_();
                Bundle bundle = new Bundle();
                bundle.putInt("nbStep", mNbStep);
                bundle.putInt("currentStep", mCurrentStep-1);
                newFragment.setArguments(bundle);


                FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                final FragmentTransaction ft = mFragmentManager.beginTransaction();
                ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right , R.anim.slide_in_right, R.anim.slide_out_left);
                ft.replace(R.id.container, newFragment);
                ft.commit();

            }
        });

        mButtonNext.setEnabled(false);
    }

    @AfterViews
    public void initView() {

        mTxtViewStep.setText(mCurrentStep + "/" + mNbStep);
        mTxtViewStep.setContentDescription(getString(R.string.step) + " " + mCurrentStep + " " + getString(R.string.on) + " " + mNbStep);

        mTxtViewLicence.setClickable(true);
        mTxtViewLicence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.flickr.com/people/27512715@N02/";
                initAlertDialogStartActivity(getContext(), url, "web");
            }
        });

        mTxtViewInfosDescritpion.setClickable(true);
        mTxtViewInfosDescritpion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://support.google.com/accessibility/android/answer/6283677?hl=fr&ref_topic=3529932/";
                initAlertDialogStartActivity(getContext(), url, "web");
            }
        });
        mTxtViewInfosDescritpion.announceForAccessibility(mTxtViewInfosDescritpion.getText());
        mTxtViewInfosDescritpion.requestFocus(); //Not recommended in most case but its useful here

    }

    public void initAlertDialogStartActivity(final Context context, String url, String type) {
        final Intent intent;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage(getString(R.string.alert_before_leaving));
        builder1.setCancelable(true);
        if(type.equals("mail")){
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, url);

        }else{
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
        }

        builder1.setPositiveButton(
                "Oui",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        context.startActivity(intent);
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

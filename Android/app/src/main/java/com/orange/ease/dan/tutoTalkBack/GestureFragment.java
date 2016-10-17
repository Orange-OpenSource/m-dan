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

package com.orange.ease.dan.tutoTalkBack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.tutoTalkBack.TutoLicenceFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Frederic Coudurier on 22/08/2016.
 */
@EFragment(R.layout.fragment_tuto)
public class GestureFragment extends Fragment {

    private int mNbStep;
    private int mCurrentStep;

    @ViewById(R.id.imgViewGesture)
    public ImageView mImgViewGesture;

    @ViewById(R.id.textViewGestureDescritpion)
    public TextView mTxtViewGestureDescritpion;

    @ViewById(R.id.textViewGestureSubDescription)
    public TextView mTxtViewGestureSubDescription;

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
        return inflater.inflate(R.layout.fragment_tuto, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (mCurrentStep == 1) {
            mButtonPrevious.setEnabled(false);
        } else {
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
        }

        if (mCurrentStep == mNbStep) {
            mButtonNext.setEnabled(false); //useless
        } else if(mCurrentStep == mNbStep-1) {
            mButtonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment newFragment = new TutoLicenceFragment_();
                    Bundle bundle = new Bundle();
                    bundle.putInt("nbStep", mNbStep);
                    bundle.putInt("currentStep", mCurrentStep+1);
                    newFragment.setArguments(bundle);

                    FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                    final FragmentTransaction ft = mFragmentManager.beginTransaction();
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    ft.replace(R.id.container, newFragment);
                    ft.commit();
                }
            });
        } else{
            mButtonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment newFragment = new GestureFragment_();
                    Bundle bundle = new Bundle();
                    bundle.putInt("nbStep", mNbStep);
                    bundle.putInt("currentStep", mCurrentStep+1);
                    newFragment.setArguments(bundle);

                    FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                    final FragmentTransaction ft = mFragmentManager.beginTransaction();
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    ft.replace(R.id.container, newFragment);
                    ft.commit();
                }
            });
        }
    }

    @AfterViews
    public void initView() {

        mTxtViewStep.setText(mCurrentStep + "/" + mNbStep);
        mTxtViewStep.setContentDescription(getString(R.string.step) + " " + mCurrentStep + " " + getString(R.string.on) + " " + mNbStep);

        switch (mCurrentStep){
           case 1:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture1));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture1));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture1_sub));
               break;
           case 2:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture2));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture2));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture2_sub));
               break;
           case 3:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture3_1));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture3));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture3_sub));
               break;
           case 4:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture3_2));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture4));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture4_sub));
               break;
           case 5:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture4_1));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture5));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture5_sub));
               break;
           case 6:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture4_2));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture6));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture6_sub));
               break;
           case 7:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture5));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture7));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture7_sub));
               break;
           case 8:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture6));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture8));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture8_sub));
               break;
           case 9:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture7));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture9));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture9_sub));
               break;
           case 10:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture8));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture10));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture10_sub));
               break;
           default:
               mImgViewGesture.setImageDrawable(getResources().getDrawable(R.drawable.talkbackgesture1));
               mTxtViewGestureDescritpion.setText(getString(R.string.tb_talkbackgesture1));
               mTxtViewGestureSubDescription.setText(getString(R.string.tb_talkbackgesture1_sub));
               break;
       }

        if(mCurrentStep != 1){
            mTxtViewGestureDescritpion.announceForAccessibility(mTxtViewGestureDescritpion.getText());
            mTxtViewGestureDescritpion.requestFocus(); //Not recommended in most case but its usefull here
        }

    }
}

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
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import static com.orange.ease.dan.R.string.tb_talkbackgesture1_sub;
import static com.orange.ease.dan.R.string.tb_talkbackgesture2_sub;

@EFragment(R.layout.fragment_tuto)
public class GestureFragment extends Fragment {

    private int mNbStep;
    private int mCurrentStep;

    @ViewById(R.id.imgViewGesture)
    public ImageView mImgViewGesture;

    @ViewById(R.id.textViewGestureDescritpion)
    public TextView mTxtViewGestureDescription;

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
        Bundle bundle = getArguments();
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
                    bundle.putInt("currentStep", mCurrentStep - 1);
                    newFragment.setArguments(bundle);


                    FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                    final FragmentTransaction ft = mFragmentManager.beginTransaction();
                    ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left);
                    ft.replace(R.id.container, newFragment);
                    ft.commit();

                }
            });
        }

        if (mCurrentStep == mNbStep) {
            mButtonNext.setEnabled(false); //useless
        } else if (mCurrentStep == mNbStep - 1) {
            mButtonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment newFragment = new TutoLicenceFragment_();
                    Bundle bundle = new Bundle();
                    bundle.putInt("nbStep", mNbStep);
                    bundle.putInt("currentStep", mCurrentStep + 1);
                    newFragment.setArguments(bundle);

                    FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
                    final FragmentTransaction ft = mFragmentManager.beginTransaction();
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    ft.replace(R.id.container, newFragment);
                    ft.commit();
                }
            });
        } else {
            mButtonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment newFragment = new GestureFragment_();
                    Bundle bundle = new Bundle();
                    bundle.putInt("nbStep", mNbStep);
                    bundle.putInt("currentStep", mCurrentStep + 1);
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

        switch (mCurrentStep) {
            case 1:
                setTutorialScreen(R.drawable.talkbackgesture1, R.string.tb_talkbackgesture1, tb_talkbackgesture1_sub);
                break;
            case 2:
                setTutorialScreen(R.drawable.talkbackgesture2, R.string.tb_talkbackgesture2, tb_talkbackgesture2_sub);
                break;
            case 3:
                setTutorialScreen(R.drawable.talkbackgesture3_1, R.string.tb_talkbackgesture3, R.string.tb_talkbackgesture3_sub);
                break;
            case 4:
                setTutorialScreen(R.drawable.talkbackgesture3_2, R.string.tb_talkbackgesture4, R.string.tb_talkbackgesture4_sub);
                break;
            case 5:
                setTutorialScreen(R.drawable.talkbackgesture4_1, R.string.tb_talkbackgesture5, R.string.tb_talkbackgesture5_sub);
                break;
            case 6:
                setTutorialScreen(R.drawable.talkbackgesture4_2, R.string.tb_talkbackgesture6, R.string.tb_talkbackgesture6_sub);
                break;
            case 7:
                setTutorialScreen(R.drawable.talkbackgesture5, R.string.tb_talkbackgesture7, R.string.tb_talkbackgesture7_sub);
                break;
            case 8:
                setTutorialScreen(R.drawable.talkbackgesture6, R.string.tb_talkbackgesture8, R.string.tb_talkbackgesture8_sub);
                break;
            case 9:
                setTutorialScreen(R.drawable.talkbackgesture7, R.string.tb_talkbackgesture9, R.string.tb_talkbackgesture9_sub);
                break;
            case 10:
                setTutorialScreen(R.drawable.talkbackgesture8, R.string.tb_talkbackgesture10, R.string.tb_talkbackgesture10_sub);
                break;
            default:
                setTutorialScreen(R.drawable.talkbackgesture1, R.string.tb_talkbackgesture1, tb_talkbackgesture1_sub);
                break;
        }

        if (mCurrentStep != 1) {
            mTxtViewGestureDescription.announceForAccessibility(mTxtViewGestureDescription.getText());
            mTxtViewGestureDescription.requestFocus(); //Not recommended in most case but its useful here
        }
    }

    private void setTutorialScreen(int dr, int text, int subText) {
        mImgViewGesture.setImageDrawable(ResourcesCompat.getDrawable(getResources(),dr,null));
        mTxtViewGestureDescription.setText(getString(text));
        mTxtViewGestureSubDescription.setText(getString(subText));
    }
}

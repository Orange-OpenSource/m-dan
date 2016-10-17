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

package com.orange.ease.dan.examplesFragmentsLvl2;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Clément Roussillon on 22/02/16.
 */

@EFragment(R.layout.excontrolcontent2_frag)
public class MyViewPagerDiapo extends Fragment {

    @ViewById(R.id.imgButtonPrevious)
    ImageButton mImgButtonPrevious;

    @ViewById(R.id.imgButtonNext)
    ImageButton mImgButtonNext;

    @ViewById(R.id.imgButtonPlay)
    ImageButton mImgButtonPlay;

    @ViewById(R.id.view_pager)
    AutoScrollViewPager mViewPager;

    final int INDICE_START = 0;
    final int INDICE_END = 2;
    final int INDICE_END_HUMAN = INDICE_END + 1;

    public static final String IS_ACCESSIBLE = "isAccessible";
    public static final String IS_SCROLLEX = "isScrollEx";
    public boolean mIsAccessible;
    public boolean mIsScrollEx;
    private OnNewFragment mOnNewFragment;
    private ImageAdapter adapter;


    @UiThread(delay = 1500)
    void doInUiThreadAfterTwoSeconds() {
        mImgButtonPrevious.setVisibility(View.GONE);
        mImgButtonNext.setVisibility(View.GONE);
        mImgButtonPlay.setVisibility(View.GONE);
    }


    @AfterViews
    void updateViews() {
        Bundle args = getArguments();
        mIsAccessible = args == null || args.getBoolean(IS_ACCESSIBLE, false);

        mViewPager = (AutoScrollViewPager) getView().findViewById(R.id.view_pager);
        adapter = new ImageAdapter();
        mViewPager.setAdapter(adapter);

        mImgButtonPrevious = (ImageButton) getView().findViewById(R.id.imgButtonPrevious);
        mImgButtonNext = (ImageButton) getView().findViewById(R.id.imgButtonNext);
        mImgButtonPlay = (ImageButton) getView().findViewById(R.id.imgButtonPlay);


        if (!mIsAccessible) {
            mImgButtonPrevious.setContentDescription("");
            mImgButtonNext.setContentDescription("");
            mImgButtonPlay.setContentDescription("");
            doInUiThreadAfterTwoSeconds();

        }

        mImgButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() == INDICE_START) {
                    mViewPager.setCurrentItem(INDICE_END, true);
                } else {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mViewPager.announceForAccessibility(adapter.getContentDescriptionImage(mViewPager.getCurrentItem()));
                }
            }
        });
        mImgButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mViewPager.getCurrentItem() == INDICE_END) {
                    mViewPager.setCurrentItem(INDICE_START, true);
                } else {
                    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mViewPager.announceForAccessibility(adapter.getContentDescriptionImage(mViewPager.getCurrentItem()));
                }
            }
        });
        mImgButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mImgButtonPrevious.setVisibility(View.GONE);
                mImgButtonNext.setVisibility(View.GONE);
                mImgButtonPlay.setVisibility(View.GONE);
                mViewPager.startAutoScroll(4000);
                mViewPager.setCycle(true);
                if (mIsAccessible) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        getView().announceForAccessibility(getString(R.string.criteria_contentcontrol_ex2_announceForAxs));
                    }
                }
            }
        });
        mImgButtonPrevious.setVisibility(View.VISIBLE);
        mImgButtonNext.setVisibility(View.VISIBLE);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                SystemClock.sleep(2000);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mViewPager.announceForAccessibility(adapter.getContentDescriptionPosition(position));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mImgButtonPrevious.setVisibility(View.VISIBLE);
                    mImgButtonNext.setVisibility(View.VISIBLE);
                    mImgButtonPlay.setVisibility(View.VISIBLE);
                    mViewPager.stopAutoScroll();
                    if (mIsAccessible) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            getView().announceForAccessibility(getString(R.string.criteria_contentcontrol_ex2_announceForAxs2));
                        }
                    }
                }
                return false;
            }
        });
    }


    private class ImageAdapter extends PagerAdapter {

        SparseArray<View> viewList = new SparseArray<View>();
        boolean isAxs = mIsAccessible;

        int[] GalImages = new int[]{
                R.drawable.carousel1,
                R.drawable.carousel2,
                R.drawable.carousel3
        };

        int[] GalTextes = new int[]{
                R.string.criteria_contentcontrol_ex_imgcd1,
                R.string.criteria_contentcontrol_ex_imgcd2,
                R.string.criteria_contentcontrol_ex_imgcd3
        };


        public SparseArray<View> getViewList() {
            return viewList;
        }

        public String getContentDescriptionImage(int position) {
            return getString(R.string.image) + " " + (position + 1) + " " + getString(R.string.on) + " " + (INDICE_END_HUMAN) + " " + getString(GalTextes[position]);
        }

        public String getContentDescriptionPosition(int position) {
            return getString(R.string.image) + " " + (position + 1) + " " + getString(R.string.on) + " " + (INDICE_END_HUMAN);
        }

        @Override
        public int getCount() {
            return GalImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View newView = null;
            LayoutInflater inflater = LayoutInflater.from(getActivity());


            if (position >= INDICE_START) {
                if (viewList.get(position) == null) {
                    viewList.put(position, inflater.inflate(R.layout.carousel_image, null));
                    View tmpView = viewList.get(position);

                    ImageView mImageView = (ImageView) tmpView.findViewById(R.id.imgViewLogoAxsOrange);
                    mImageView.setImageResource(GalImages[position]);

                    if (isAxs) {
                        mImageView.setContentDescription(getContentDescriptionImage(position));
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            mImageView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
                        }
                    }
                }
                newView = viewList.get(position);
                container.addView(newView);
                return newView;
            } else {
                return null;
            }
        }


    }

    private boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = getActivity().getPackageName() + "/" + AccessibilityService.class.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {

        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    mContext.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);
                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();
                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
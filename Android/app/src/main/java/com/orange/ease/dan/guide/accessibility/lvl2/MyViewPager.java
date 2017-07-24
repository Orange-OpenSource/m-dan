
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

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.orange.ease.dan.R;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * Created by Clément Roussillon on 22/02/16.
 */
@EFragment(R.layout.excontrolcontent1_frag)
public class MyViewPager extends Fragment {

    final int INDICE_START = 0;
    final int INDICE_END = 2;
    final int INDICE_END_HUMAN = INDICE_END+1;

    public static final String IS_ACCESSIBLE = "isAccessible";
    public static final String IS_SCROLLEX = "isScrollEx";
    public boolean mIsAccessible;
    public boolean mIsScrollEx;
    private OnNewFragment mOnNewFragment;
    private ImageAdapter adapter;


    @ColorRes(R.color.core_orange_dark)
    int colorSelected;

    @ColorRes(R.color.core_white)
    int colorUnselected;

    @ViewById(R.id.imgButtonPrevious)
    ImageButton mLeft;

    @ViewById(R.id.imgButtonNext)
    ImageButton mRight;

    @ViewById(R.id.view_pager)
    AutoScrollViewPager mViewPager;

    @ViewById(R.id.linearLayout)
    LinearLayout mStripButtons;

    ImageButton[] mButtons = new ImageButton[INDICE_END + 1];


    View.OnClickListener mOnSelectPageClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mViewPager.setCurrentItem(v.getId(), true);
        }
    };

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

    @AfterViews
    void updateViews() {
        Bundle args = getArguments();
        if (args != null) {
            mIsAccessible = args.getBoolean(IS_ACCESSIBLE, false);
            mIsScrollEx = args.getBoolean(IS_SCROLLEX);
        } else {
            mIsAccessible = true;
            mIsScrollEx = false;
        }

        adapter = new ImageAdapter();
        mViewPager.setAdapter(adapter);

        if (mIsAccessible) {
            if (!isAccessibilitySettingsOn(getActivity().getApplicationContext())) {
                mLeft.setVisibility(View.VISIBLE);
                mRight.setVisibility(View.VISIBLE);
            } else {
                mLeft.setVisibility(View.GONE);
                mRight.setVisibility(View.GONE);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                mStripButtons.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS);
            }
            mStripButtons.setContentDescription(getString(R.string.promotion) + " " + 1 + "sur" + (INDICE_END + 1));
        } else {
            mLeft.setVisibility(View.GONE);
            mRight.setVisibility(View.GONE);
            mViewPager.startAutoScroll(2000);
        }
        if (mIsScrollEx) {
            mLeft.setVisibility(View.GONE);
            mRight.setVisibility(View.GONE);
            mViewPager.stopAutoScroll();
            mStripButtons.setVisibility(View.GONE);
        }

        for (int i = INDICE_START; i <= INDICE_END; i++) {
            ImageButton button = new ImageButton(getContext());
            button.setId(i);
            if (mIsAccessible) {
                button.setContentDescription(getString(R.string.promotion) + " " + (i + 1) + " sur " + (INDICE_END + 1));
            }
            button.setImageResource(R.drawable.ic_radio_button_checked_white_24dp);
            button.setBackgroundResource(R.color.core_black);
            if (i == INDICE_START) {
                button.setColorFilter(colorSelected);
            } else {
                button.setColorFilter(colorUnselected);
            }
            button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setOnClickListener(mOnSelectPageClickListener);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
            }
            button.setFocusable(true);
            mButtons[i] = button;

            mStripButtons.addView(button, i);
        }

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (mIsAccessible) {
                    mStripButtons.setContentDescription(getString(R.string.promotion) + " " + (position + 1) + " " + getString(R.string.on) + " " + (INDICE_END + 1));
                }
                for (int i = INDICE_START; i <= INDICE_END; i++) {
                    ImageButton button = (ImageButton) mStripButtons.getChildAt(i);
                    if (i == position) {
                        button.setColorFilter(colorSelected);
                    } else {
                        button.setColorFilter(colorUnselected);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(INDICE_START, true);
        mViewPager.setScrollDurationFactor(10);

    }


    @Click(R.id.linearLayout)
    void selectViewClicked(View view) {
    }

    @Click(R.id.imgButtonPrevious)
    void leftClicked(View view) {
        if (mViewPager.getCurrentItem() == INDICE_START) {
            mViewPager.setCurrentItem(INDICE_END, true);
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mViewPager.announceForAccessibility(adapter.getContentDescriptionImage(mViewPager.getCurrentItem()));
        }
    }

    @Click(R.id.imgButtonNext)
    void rightClicked(View view) {
        if (mViewPager.getCurrentItem() == INDICE_END) {
            mViewPager.setCurrentItem(INDICE_START, true);
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mViewPager.announceForAccessibility(adapter.getContentDescriptionImage(mViewPager.getCurrentItem()));
        }
    }

    private boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        final String service = getActivity().getPackageName() + "/" + AccessibilityService.class.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    mContext.getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
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
            return getString(R.string.promotion) + " " + (position+1) + " " + getString(R.string.on) + " " + (INDICE_END_HUMAN) + " " + getString(GalTextes[position]);
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
}




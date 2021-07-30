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
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EFragment;

/**
 * Created by Clément Roussillon on 22/02/16.
 */

@EFragment(R.layout.excontrolcontent1_frag)
public class MyViewPagerAxsNo extends Fragment {

    private ImageButton mImgButtonPrevious;
    private ImageButton mImgButtonNext;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ViewPager viewPager = (ViewPager) getView().findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(getContext());
        viewPager.setAdapter(adapter);

        mImgButtonPrevious = (ImageButton) getView().findViewById(R.id.imgButtonPrevious);
        mImgButtonNext = (ImageButton) getView().findViewById(R.id.imgButtonNext);
        mImgButtonPrevious.setVisibility(View.GONE);
        mImgButtonNext.setVisibility(View.GONE);
    }

    public class ImageAdapter extends PagerAdapter {
        Context context;
        private int[] GalImages = new int[]{
                R.drawable.carousel1,
                R.drawable.carousel2,
                R.drawable.carousel3
        };

        ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return GalImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(context);
            int padding = context.getResources().getDimensionPixelSize(R.dimen.medium_margin);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(GalImages[position]);

            container.addView(imageView, 0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }
    }
}




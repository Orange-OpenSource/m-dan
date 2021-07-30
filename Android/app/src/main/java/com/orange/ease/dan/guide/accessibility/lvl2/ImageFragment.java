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

import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Laurent Souchet on 24/02/2016.
 */
@EFragment(R.layout.carousel_image)
public class ImageFragment extends Fragment {
    public final static String ID_IMAGE = "idImage";
    public final static String MESSAGE_IMAGE = "messageImage";

    @ViewById(R.id.imgViewLogoAxsOrange)
    ImageView mImageView;

    @AfterViews
    void updateView() {
        Bundle args = getArguments();
        if (args != null) {
            int resId = args.getInt(ID_IMAGE, 0);
            if (resId >= 0) {
                mImageView.setImageResource(resId);
            }

            String message = args.getString(MESSAGE_IMAGE, "");
            if (!message.isEmpty()) {
                mImageView.setContentDescription(message);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    mImageView.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
                }
            }
        }
    }

}

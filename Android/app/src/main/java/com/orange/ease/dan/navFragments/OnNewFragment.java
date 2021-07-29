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

import androidx.fragment.app.Fragment;
import android.widget.TextView;

/**
 * Created by Laurent Souchet on 12/02/2016.
 */
public interface OnNewFragment {
    void onNewFragment(Fragment fragment, String name, boolean withBackstack);
    void onNewFragmentAdd(Fragment fragment, String name, boolean withBackstack);
    void setTemplateTitle(String title, boolean restoreActionBar);
    void removeFrag(Fragment fragment, String title);
    TextView getToolbarTitleTextView();
    void showOverflowMenu(int group, boolean showMenu);
    void initAlertDialogOptions(int option);
}

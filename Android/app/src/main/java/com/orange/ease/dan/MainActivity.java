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

package com.orange.ease.dan;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.orange.ease.dan.navFragments.AboutFragment_;
import com.orange.ease.dan.navFragments.AxsOrangeFragment_;
import com.orange.ease.dan.navFragments.HomeFragment_;
import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements OnNewFragment {

    private String mFragmentTitle;
    private boolean mIsBack = false;
    private Menu mMenu;
    private Dialog mDialog;

    @ViewById(R.id.my_toolbar)
    public Toolbar mToolbar;

    @AfterViews
    void init() {
        setSupportActionBar(mToolbar);

        // init the default fragment showed
        mFragmentTitle = getString(R.string.section_home);
        Fragment launchFragment = new HomeFragment_();
        onNewFragment(launchFragment, mFragmentTitle, false);

        restoreActionBar();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE || newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            restoreActionBar();
        }
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            System.exit(0); //Leave the application
        } else if(count == 1) { //homepage
            getSupportFragmentManager().popBackStack();
            mIsBack = false;
            restoreActionBar();
        } else { //other pages
            getSupportFragmentManager().popBackStack();
            setTemplateTitle(mFragmentTitle, false);
            restoreActionBar();
        }
    }

    private void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(mFragmentTitle);
            actionBar.setDisplayShowTitleEnabled(true);

            if (mIsBack) {
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
                mToolbar.setNavigationContentDescription(getString(R.string.navigation_return));
                actionBar.setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_material);
            } else {
                //mToolbar.setNavigationContentDescription(getString(R.string.navigation_home));
                actionBar.setHomeButtonEnabled(false);
                actionBar.setDisplayHomeAsUpEnabled(false);
                //actionBar.setHomeAsUpIndicator(R.drawable.icon_home);
            }
            if(getToolbarTitleTextView()!=null) {
                getToolbarTitleTextView().setContentDescription(mToolbar.getTitle().toString().replace("/", (" " + getString(R.string.on) + " ")));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.mMenu = menu;
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            MenuItem favoriteItem = menu.findItem(R.id.action_option);
            Drawable newIcon = favoriteItem.getIcon();
            newIcon.mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
            favoriteItem.setIcon(newIcon);
        }
        showOverflowMenu(R.id.main_menu_group, false);
        showOverflowMenu(R.id.option_menu_group, false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Fragment newFragment = null;
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mIsBack) {
                    onBackPressed();
                    return true;
                } else {
                    return super.onOptionsItemSelected(item);
                }
            case R.id.action_axs_orange:
                mFragmentTitle = getString(R.string.section_criteria);
                newFragment = new AxsOrangeFragment_();
                break;
            case R.id.action_about:
                newFragment = new AboutFragment_();
                break;
            case R.id.action_option:
                initAlertDialogStartActivity();
                break;
            default:
                break;
        }

        if (newFragment != null) {
            onNewFragment(newFragment, mFragmentTitle, true);
        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }

        return true;
    }

    @Override
    public void onNewFragment(Fragment fragment, String title, boolean withBackstack) {
        mIsBack = withBackstack;
        FragmentManager mFragmentManager = getSupportFragmentManager();
        final FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.replace(R.id.container, fragment);
        if (withBackstack) {
            ft.addToBackStack(title);
        }
        ft.commit();
        setTemplateTitle(title, true);
    }

    @Override
    public void onNewFragmentAdd(Fragment fragment, String title, boolean withBackstack) {
        mIsBack = withBackstack;
        FragmentManager mFragmentManager = getSupportFragmentManager();
        final FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        ft.add(R.id.container, fragment);
        if (withBackstack) {
            ft.addToBackStack(title);
        }
        ft.commit();
        setTemplateTitle(title, true);
    }

    @Override
    public void removeFrag(Fragment fragment,String title){
        FragmentManager mFragmentManager = getSupportFragmentManager();
        final FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ft.remove(fragment);
        ft.commit();
        setTemplateTitle(title, true);
    }

    @Override
    public void setTemplateTitle(String title, boolean restoreActionBar){
        mFragmentTitle = title;
        if(restoreActionBar){
            restoreActionBar();
        }
    }

    @Override
    public TextView getToolbarTitleTextView(){
        TextView toolbarTitle = null;
        for (int i = 0; i < mToolbar.getChildCount(); ++i) {
            View child = mToolbar.getChildAt(i);
            // assuming that the title is the first instance of TextView
            // you can also check if the title string matches
            if (child instanceof TextView) {
                toolbarTitle = (TextView)child;
                break;
            }
        }
        return toolbarTitle;
    }

    @Override
    public void showOverflowMenu(int group, boolean showMenu){
        if(mMenu == null)
            return;
        mMenu.setGroupVisible(group, showMenu);
    }

    private void initAlertDialogStartActivity() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
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
        button0.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.icon_check_good), null, null, null);
        button0.setContentDescription("Oui");
        button0.setText("");
        Button button1 = alert11.getButton(AlertDialog.BUTTON_NEGATIVE);
        button1.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.icon_check_bad), null, null, null);
        button1.setContentDescription("Non");
        button1.setText("");
    }

    @Override
    public void initAlertDialogOptions(int option) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean showDialog = prefs.getBoolean("showDialogAgain", true);
        if(showDialog) {

            boolean accessibilityOptionEnabled = false;
            switch (option){
                case 0: //TalkBack
                    AccessibilityManager am = (AccessibilityManager) getSystemService(ACCESSIBILITY_SERVICE);
                    accessibilityOptionEnabled = am.isEnabled();
                    break;
                case 1: //Large text
                    Configuration c = getResources().getConfiguration();
                    float scale = c.fontScale;
                    accessibilityOptionEnabled = (scale > 1);
                    break;
                default:
                    break;
            }

            if(!accessibilityOptionEnabled) {

                mDialog = new Dialog(this);
                mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                mDialog.setContentView(R.layout.custom_alert);
                mDialog.setTitle(getString(R.string.alert_title));

                TextView contentTextView = (TextView) mDialog.findViewById(R.id.text);
                String[] options = getResources().getStringArray(R.array.alert_options);
                String text;
                try {
                    text = String.format(getResources().getString(R.string.alert_content), options[option]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    text = String.format(getResources().getString(R.string.alert_content), options[0]);
                }
                contentTextView.setText(text);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ImageButton closeDialogButton = (ImageButton) mDialog.findViewById(R.id.close);
                    closeDialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CheckBox choice = (CheckBox) mDialog.findViewById(R.id.choice);
                            if (choice.isChecked()) {
                                doNotShowDialogAgain();
                            }
                            mDialog.dismiss();
                        }
                    });
                }

                Button okDialogButton = (Button) mDialog.findViewById(R.id.dialogButtonOK);
                okDialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox choice = (CheckBox) mDialog.findViewById(R.id.choice);
                        if (choice.isChecked()) {
                            doNotShowDialogAgain();
                        }
                        startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
                    }
                });

                Button cancelDialogButton = (Button) mDialog.findViewById(R.id.dialogButtonCancel);
                cancelDialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox choice = (CheckBox) mDialog.findViewById(R.id.choice);
                        if (choice.isChecked()) {
                            doNotShowDialogAgain();
                        }
                        mDialog.dismiss();
                    }
                });

                mDialog.show();
            }
        }
    }

    private void doNotShowDialogAgain() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("showDialogAgain", false).apply();
    }
}

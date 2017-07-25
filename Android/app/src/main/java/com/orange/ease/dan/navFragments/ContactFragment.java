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
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 11/02/16.
 */
@EFragment(R.layout.fragment_contact)
public class ContactFragment extends Fragment {

    private OnNewFragment mOnNewFragment;

    @ViewById(R.id.imgViewLogoContact)
    public ImageView mImgViewLogoContact;

    @ViewById(R.id.textViewTitleContact)
    public TextView mTextViewTitleContact;

    @ViewById(R.id.textViewLabelContact)
    public TextView mTextViewLabelContact;

    @ViewById(R.id.textViewLienContact)
    public TextView mTextViewLienContact;

    @ViewById(R.id.textViewLabelSupport)
    public TextView mTextViewLabelSupport;

    @ViewById(R.id.textViewLienSupport)
    public TextView mTextViewLienSupport;

    @ViewById(R.id.textViewLabelMail)
    public TextView mTextViewLabelMail;

    @ViewById(R.id.textViewLienMail)
    public TextView mTextViewLienMail;


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


        mTextViewTitleContact.setText(R.string.contact_title);
        mTextViewLabelContact.setText(R.string.contact_website);

        mTextViewLienContact.setClickable(true);
        mTextViewLienContact.setText(Html.fromHtml(getString(R.string.contact_website_link)));
        mTextViewLienContact.setPaintFlags(mTextViewLienContact.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTextViewLienContact.setMovementMethod(LinkMovementMethod.getInstance());
        mTextViewLienContact.setTextColor(ContextCompat.getColor(getContext(),R.color.core_orange_dark));
        mTextViewLienContact.setContentDescription(getString(R.string.contact_cd_website_link));
        mTextViewLienContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://webidea.si.francetelecom.fr/spip/spip.php?rubrique119";
                initAlertDialogStartActivity(getContext(),url,"web");
            }
        });

        mTextViewLabelSupport.setText(R.string.contact_support);
        mTextViewLienSupport.setClickable(true);
        mTextViewLienSupport.setText(Html.fromHtml(getString(R.string.contact_support_link)));
        mTextViewLienSupport.setPaintFlags(mTextViewLienContact.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTextViewLienSupport.setMovementMethod(LinkMovementMethod.getInstance());
        mTextViewLienSupport.setContentDescription(getString(R.string.contact_cd_support_link));
        mTextViewLienSupport.setTextColor(ContextCompat.getColor(getContext(),R.color.core_orange_dark));
        mTextViewLienSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://isf.idea.rd.francetelecom.fr/issue.html?applicationId=4453&amp;projectName=";
                initAlertDialogStartActivity(getContext(),url,"web");
            }
        });

        mTextViewLabelMail.setText(R.string.contact_team);
        mTextViewLienMail.setClickable(true);
        mTextViewLienMail.setText(Html.fromHtml(getString(R.string.contact_team_mail)));
        mTextViewLienMail.setPaintFlags(mTextViewLienContact.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTextViewLienMail.setContentDescription(getString(R.string.contact_cd_team_mail));
        mTextViewLienMail.setTextColor(ContextCompat.getColor(getContext(),R.color.core_orange_dark));
        mTextViewLienMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "accessibility.support@orange.com";
                initAlertDialogStartActivity(getContext(),url,"mail");

            }
        });
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

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(R.string.section_contact),true);
    }
}
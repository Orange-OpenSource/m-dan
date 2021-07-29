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
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;
import com.orange.ease.dan.adapter.ArrayAdapterWithCD;
import com.orange.ease.dan.navFragments.OnNewFragment;
import com.orange.ease.dan.view.NonScrollableListView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Clément Roussillon on 12/02/16.
 */
@EFragment(R.layout.example_frag_lvl2)
public class ExStateElmts2Fragment extends Fragment {

    private OnNewFragment mOnNewFragment;

    @ViewById(R.id.textViewTitleExample)
    public TextView mTextViewTitleExample;

    @ViewById(R.id.textViewDescriptionExample)
    public TextView mTextViewDescriptionExample;

    @ViewById(R.id.textViewTitleExempleAxsYes)
    public TextView mTextViewTitleExempleAxsYes;

    @ViewById(R.id.frameLayoutExampleAxsYes)
    public FrameLayout mFrameLayoutExampleAxsYes;

    @ViewById(R.id.textViewTitleExempleAxsNo)
    public TextView mTextViewTitleExempleAxsNo;

    @ViewById(R.id.frameLayoutExampleAxsNo)
    public FrameLayout mFrameLayoutExampleAxsNo;

    @ViewById(R.id.textViewOptionEnabled)
    public TextView mTextViewOptionEnabled;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnNewFragment.initAlertDialogOptions(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.example_frag_lvl2, container, false);
    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTextViewTitleExample.setText(R.string.criteria_stateelement_ex2_title);
        mTextViewDescriptionExample.setText(R.string.criteria_stateelement_ex2_description);
        mTextViewTitleExempleAxsYes.setText(R.string.criteria_accessible_example);
        mTextViewTitleExempleAxsNo.setText(R.string.criteria_not_accessible_example);
        mTextViewOptionEnabled.setText(getString(R.string.criteria_template_option_tb));

        float scale = getResources().getDisplayMetrics().density;
        int dpAsPixels = (int) (15*scale + 0.5f); //padding de 15dp
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        String[] items = getResources().getStringArray(R.array.criteria_stateelement_ex2_list);
        ArrayAdapterWithCD<String> aaAxs = new ArrayAdapterWithCD<>(getActivity(),
                R.layout.simple_list_item_text,
                R.id.textCategory,
                items);

        ArrayAdapter<String> aaNotAxs = new ArrayAdapter<>(getActivity(),
                R.layout.simple_list_item_text,
                R.id.textCategory,
                items);

        /* AXS YES */
        ListView lvaxsYes = (NonScrollableListView) inflater.inflate(R.layout.exstateelements2_frag, null);
        lvaxsYes.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lvaxsYes.setAdapter(aaAxs);
        lvaxsYes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!view.isSelected()) {

                    view.setSelected(true);
                    for (int i = 0; i < parent.getCount(); i++) {
                        RelativeLayout parentView = (RelativeLayout) parent.getChildAt(i);
                        TextView descTextView = (TextView) parentView.findViewById(R.id.textCategory);
                        descTextView.setContentDescription(descTextView.getText() + ", " + getString(R.string.not) + " " + getString(R.string.selected));
                    }

                    RelativeLayout parentViewSelected = (RelativeLayout) parent.getChildAt(position);
                    TextView myTextViewSelected = (TextView) parentViewSelected.findViewById(R.id.textCategory);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        myTextViewSelected.setContentDescription(myTextViewSelected.getText());
                    }else{ //LOLLIPOP_MR1 -
                        myTextViewSelected.setContentDescription(myTextViewSelected.getText() + " " + getString(R.string.selected));
                    }
                } else {
                    view.setSelected(false);
                    RelativeLayout parentViewSelected = (RelativeLayout) parent.getChildAt(position);
                    TextView myTextViewSelected = (TextView) parentViewSelected.findViewById(R.id.textCategory);
                    myTextViewSelected.setContentDescription(myTextViewSelected.getText() + ", " + getString(R.string.not) + " " + getString(R.string.selected));
                }
            }
        });

        TextView exAxsDescription = new TextView(getContext());
        exAxsDescription.setText(getString(R.string.criteria_stateelement_ex2_axsDesc));
        exAxsDescription.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);


        /* AXS NO */
        ListView lvaxsNo = (NonScrollableListView) inflater.inflate(R.layout.exstateelements2_frag, null);
        lvaxsNo.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        lvaxsNo.setAdapter(aaNotAxs);

        TextView exNotAxsDescription = new TextView(getContext());
        exNotAxsDescription.setText(getString(R.string.criteria_stateelement_ex2_notAxsDesc));
        exNotAxsDescription.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout lyAxs = new LinearLayout(getActivity());
        lyAxs.setOrientation(LinearLayout.VERTICAL);
        lyAxs.setLayoutParams(layoutParams);
        lyAxs.addView(exAxsDescription);
        lyAxs.addView(lvaxsYes);
        mFrameLayoutExampleAxsYes.addView(lyAxs);

        LinearLayout lyNotAxs = new LinearLayout(getActivity());
        lyNotAxs.setOrientation(LinearLayout.VERTICAL);
        lyNotAxs.setLayoutParams(layoutParams);
        lyNotAxs.addView(exNotAxsDescription);
        lyNotAxs.addView(lvaxsNo);
        mFrameLayoutExampleAxsNo.addView(lyNotAxs);
    }

    public class ListAxsAdapter extends ArrayAdapter<String> {

        public ListAxsAdapter(Context context, String[] stringArrayList) {
            super(context, 0, stringArrayList);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            // Get the data item for this position
            String string = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView;
            tvName.setContentDescription(string + " Non " + " séléctionné ");
            // Populate the data into the template view using the data object
            tvName.setText(string);
            // Return the completed view to render on screen
            return convertView;
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mOnNewFragment.showOverflowMenu(R.id.option_menu_group, true);
    }
}
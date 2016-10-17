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

package com.orange.ease.dan.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.orange.ease.dan.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> mExpandableListTitle;
    private HashMap<String, List<String>> mExpandableListDetail;
    private boolean mAxs = true;

    public ExpandableListAdapter(Context context, List<String> expandableListTitle,
                                 HashMap<String, List<String>> expandableListDetail, boolean axs) {
        this.mContext = context;
        this.mExpandableListTitle = expandableListTitle;
        this.mExpandableListDetail = expandableListDetail;
        this.mAxs = axs;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.mExpandableListDetail.get(this.mExpandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        String expandedListText = (String) getChild(listPosition, expandedListPosition);
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        if(mAxs){
            convertView.setContentDescription(expandedListText + ", " + mContext.getString(R.string.criteria_stateelement_ex3_item) + " " + (expandedListPosition+1) +
                    " " + mContext.getString(R.string.on) + " " + (getChildrenCount(listPosition)) + ", " + listTitle);
        }
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.mExpandableListDetail.get(this.mExpandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.mExpandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.mExpandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        if(mAxs){
            if(isExpanded){
                convertView.setContentDescription(listTitle + ", " + mContext.getString(R.string.criteria_stateelement_ex3_grp) + " " + (listPosition+1) +
                        " " + mContext.getString(R.string.on) + " " + (getGroupCount()) + mContext.getString(R.string.criteria_stateelement_ex3_cd_open));
            }else{
                convertView.setContentDescription(listTitle + ", " +  mContext.getString(R.string.criteria_stateelement_ex3_grp) + " " + (listPosition+1) +
                        " " + mContext.getString(R.string.on) + " " + (getGroupCount()) + mContext.getString(R.string.criteria_stateelement_ex3_cd_closed));
            }
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orange.ease.dan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frederic Coudurier on 22/04/2016.
 */
public class CustomExpandableListViewAdapter extends com.orange.ease.idunnololz.widgets.AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private LayoutInflater inflater;
    private List<GroupItem> items;
    private Context context;
    private boolean accessible = true;

    public CustomExpandableListViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setData(List<GroupItem> items) {
        this.items = items;
    }

    @Override
    public ChildItem getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).items.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder holder;
        ChildItem item = getChild(groupPosition, childPosition);
        if (convertView == null) {
            holder = new ChildHolder();
            convertView = inflater.inflate(R.layout.list_itemelv, parent, false);
            holder.title = (TextView) convertView.findViewById(R.id.textTitle);
            holder.hint = (TextView) convertView.findViewById(R.id.textHint);
            convertView.setTag(holder);
        } else {
            holder = (ChildHolder) convertView.getTag();
        }

        if(isAccessible()) {
            convertView.setContentDescription(context.getString(R.string.criteria_stateelement_ex3_grp) + (groupPosition + 1) + ", " + item.title + ", " + item.hint);
        }
        holder.title.setText(item.title);
        holder.hint.setText(item.hint);

        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return items.get(groupPosition).items.size();
    }

    @Override
    public GroupItem getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder holder;
        GroupItem item = getGroup(groupPosition);
        parent=parent;
        if (convertView == null) {
            holder = new GroupHolder();
            convertView = inflater.inflate(R.layout.group_itemelv, parent, false);
            holder.title = (TextView) convertView.findViewById(R.id.textTitle);
            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }

        holder.title.setText(item.title);

        if(isAccessible()) {
            if (isExpanded == true) {
                convertView.setContentDescription(context.getString(R.string.criteria_stateelement_ex3_grp) + " " + (groupPosition + 1) + " " + context.getString(R.string.criteria_stateelement_ex3_cd_open));
            } else {
                convertView.setContentDescription(context.getString(R.string.criteria_stateelement_ex3_grp) + (groupPosition + 1) + context.getString(R.string.criteria_stateelement_ex3_cd_closed));
            }
        }


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean isAccessible) {
        this.accessible = isAccessible;
    }


    /* DATA & HOLDER */
    public static class GroupItem {
        String title;
        List<ChildItem> items = new ArrayList<ChildItem>();

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ChildItem> getItems() {
            return items;
        }

        public void addItem(ChildItem item){
            items.add(item);
        }
    }

    public static class ChildItem {
        String title;
        String hint;

        public String getHint() {
            return hint;
        }

        public String getTitle() {
            return title;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class ChildHolder {
        TextView title;
        TextView hint;

        public void setHint(TextView hint) {
            this.hint = hint;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getHint() {
            return hint;
        }

        public TextView getTitle() {
            return title;
        }
    }

    public static class GroupHolder {
        TextView title;

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getTitle() {
            return title;
        }
    }
}

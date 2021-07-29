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
import android.os.Build;
import androidx.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.orange.ease.dan.R;

public class ArrayAdapterWithCD<S> extends ArrayAdapter {

    public ArrayAdapterWithCD(Context context, int resource, int textViewResourceId, S[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        if(convertView != null){
            TextView tv = convertView.findViewById(R.id.textCategory);
            if(convertView.isSelected()){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    tv.setContentDescription(tv.getText());
                }else{ //LOLLIPOP_MR1 -
                    tv.setContentDescription(tv.getText() + " " + getContext().getString(R.string.selected));
                }
            }else{
                tv.setContentDescription(tv.getText() + ", " + getContext().getString(R.string.not) + " " + getContext().getString(R.string.selected));
            }

        }

        return super.getView(position, convertView, parent);
    }
}

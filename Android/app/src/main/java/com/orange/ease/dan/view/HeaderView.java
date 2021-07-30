package com.orange.ease.dan.view;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.header)
public class HeaderView extends RelativeLayout {

    @ViewById((R.id.headerLabel))
    protected TextView labelTextView;

    @ViewById(R.id.headerDescription)
    protected TextView descriptionTextView;

    @ViewById(R.id.headerListLabel)
    protected TextView listLabelTextView;

    @ViewById(R.id.virtualSeparator)
    protected View separator;

    @ViewById(R.id.splitImage)
    protected ImageView imageView;

    @ViewById(R.id.headerInformation)
    protected TextView headerInformation;

    public HeaderView(Context context) {
        super(context);
    }

    public void setTexts(@StringRes int label, @StringRes int description, @StringRes int listLabel, String listLabelContentDescription, @DrawableRes int background) {

        labelTextView.setText(label);
        descriptionTextView.setText(description);
        listLabelTextView.setText(listLabel);
        listLabelTextView.setContentDescription(listLabelContentDescription);
        imageView.setBackgroundResource(background);

        //for accessibility : force talkback focus on all element
        descriptionTextView.setFocusable(true);
        labelTextView.setFocusable(true);
        listLabelTextView.setFocusable(true);
    }

    public void hideHeaderInformation() {
        headerInformation.setVisibility(View.GONE);
    }

    public void hideSeparator() {
        separator.setVisibility(View.GONE);
    }
}
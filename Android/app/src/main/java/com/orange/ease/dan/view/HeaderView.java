package com.orange.ease.dan.view;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import static com.orange.ease.dan.R.id.headerCriteriaListLabel;
import static com.orange.ease.dan.R.id.headerCriteriaRuleDescription;
import static com.orange.ease.dan.R.id.headerCriteriaRuleLabel;
import static com.orange.ease.dan.R.id.headerCriteriaWhyDescription;
import static com.orange.ease.dan.R.id.headerCriteriaWhyLabel;

@EViewGroup(R.layout.header_criteria)
public class HeaderView extends RelativeLayout {


    @ViewById(headerCriteriaWhyLabel)
    public TextView mHeaderCriteriaWhyLabel;

    @ViewById(headerCriteriaWhyDescription)
    public TextView mHeaderCriteriaWhyDescription;

    @ViewById(headerCriteriaRuleLabel)
    public TextView mHeaderCriteriaRuleLabel;

    @ViewById(headerCriteriaRuleDescription)
    public TextView mHeaderCriteriaRuleDescription;

    @ViewById(headerCriteriaListLabel)
    public TextView mHeaderCriteriaListLabel;

    public HeaderView(Context context) {
        super(context);
    }

    public void setTexts(String whyDescription, String ruleDescription) {

        mHeaderCriteriaWhyLabel.setText(R.string.criteria_template_why);
        mHeaderCriteriaWhyDescription.setText(whyDescription);
        mHeaderCriteriaRuleLabel.setText(R.string.criteria_template_rule);
        mHeaderCriteriaRuleDescription.setText(ruleDescription);
        mHeaderCriteriaListLabel.setText(R.string.criteria_template_example);

        //for accessibility : force talkback focus on all element
        mHeaderCriteriaWhyLabel.setFocusable(true);
        mHeaderCriteriaWhyDescription.setFocusable(true);
        mHeaderCriteriaRuleLabel.setFocusable(true);
        mHeaderCriteriaRuleDescription.setFocusable(true);
        mHeaderCriteriaListLabel.setFocusable(true);
    }

}
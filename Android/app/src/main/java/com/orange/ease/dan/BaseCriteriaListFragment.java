package com.orange.ease.dan;


import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.criteria_template)
public abstract class BaseCriteriaListFragment extends BaseListFragment {

    public TextView mHeaderCriteriaWhyLabel;
    public TextView mHeaderCriteriaWhyDescription;
    public TextView mHeaderCriteriaRuleLabel;
    public TextView mHeaderCriteriaRuleDescription;
    public TextView mHeaderCriteriaListLabel;

    @Override
    protected void initHeader() {
        mHeaderView = inflateHeader(R.layout.header_criteria);

        // init class variable
        mHeaderCriteriaWhyLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaWhyLabel);
        mHeaderCriteriaWhyDescription = (TextView) mHeaderView.findViewById(R.id.headerCriteriaWhyDescription);
        mHeaderCriteriaRuleLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaRuleLabel);
        mHeaderCriteriaRuleDescription = (TextView) mHeaderView.findViewById(R.id.headerCriteriaRuleDescription);
        mHeaderCriteriaListLabel = (TextView) mHeaderView.findViewById(R.id.headerCriteriaListLabel);

        //for accessibility : force Talckback focus on all element
        mHeaderCriteriaWhyLabel.setFocusable(true);
        mHeaderCriteriaWhyDescription.setFocusable(true);
        mHeaderCriteriaRuleLabel.setFocusable(true);
        mHeaderCriteriaRuleDescription.setFocusable(true);
        mHeaderCriteriaListLabel.setFocusable(true);

        mHeaderCriteriaWhyLabel.setText(R.string.criteria_template_why);
        mHeaderCriteriaWhyDescription.setText(getWhyDescription());
        mHeaderCriteriaRuleLabel.setText(R.string.criteria_template_rule);
        mHeaderCriteriaRuleDescription.setText(getRuleDescription());
        mHeaderCriteriaListLabel.setText(R.string.criteria_template_example);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mHeaderCriteriaListLabel.setContentDescription(adapter.getCount() + " " + getString(R.string.example));
    }

    protected abstract int getWhyDescription();

    protected abstract int getRuleDescription();

}

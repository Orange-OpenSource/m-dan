package com.orange.ease.dan;

import android.os.Bundle;
import android.support.annotation.StringRes;

import com.orange.ease.dan.view.HeaderView;
import com.orange.ease.dan.view.HeaderView_;

import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.criteria_template)
public abstract class BaseCriteriaListFragment extends BaseListFragment {

    @Override
    protected void initHeader() {
        mHeaderView = HeaderView_.build(getContext());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((HeaderView) mHeaderView).mHeaderCriteriaListLabel.setContentDescription(adapter.getCount() + " " + getString(R.string.example));
    }

    protected abstract
    @StringRes
    int getWhyDescription();

    protected abstract
    @StringRes
    int getRuleDescription();

}

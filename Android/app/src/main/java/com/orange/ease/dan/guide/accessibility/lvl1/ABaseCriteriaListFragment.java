package com.orange.ease.dan.guide.accessibility.lvl1;

import android.os.Bundle;
import android.support.annotation.StringRes;

import com.orange.ease.dan.BaseListFragment;
import com.orange.ease.dan.R;
import com.orange.ease.dan.view.CriteriaHeaderView;
import com.orange.ease.dan.view.CriteriaHeaderView_;

import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.criteria_template)
public abstract class ABaseCriteriaListFragment extends BaseListFragment {

    @Override
    protected void initHeader() {
        mHeaderView = CriteriaHeaderView_.build(getContext());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((CriteriaHeaderView) mHeaderView).setTexts(getWhyDescription(),getRuleDescription(),adapter.getCount() + " " + getString(R.string.example));
    }

    protected abstract
    @StringRes
    int getWhyDescription();

    protected abstract
    @StringRes
    int getRuleDescription();

}

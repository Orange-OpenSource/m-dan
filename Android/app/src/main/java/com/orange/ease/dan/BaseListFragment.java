package com.orange.ease.dan;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment
public abstract class BaseListFragment extends ListFragment{

    public View mHeaderView;

    @ViewById(android.R.id.list)
    public ListView listView;

    protected OnNewFragment mOnNewFragment;

    protected ArrayAdapter<String> adapter;

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
        String[] items = getResources().getStringArray(getListArray());
        adapter = new ArrayAdapter<>(getActivity(), R.layout.simple_list_item_text, R.id.textCategory, items);
        setListAdapter(adapter);
    }

    protected abstract int getListArray();
    protected abstract void initHeader();

    protected abstract int getTitleResource();

    protected View inflateHeader(int layout){
        return getActivity().getLayoutInflater().inflate(layout, null);
    }

    @AfterViews
    protected void initHeaderView(){
        initHeader();
        listView.addHeaderView(mHeaderView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mOnNewFragment.setTemplateTitle(getString(getTitleResource()),true);
    }


}

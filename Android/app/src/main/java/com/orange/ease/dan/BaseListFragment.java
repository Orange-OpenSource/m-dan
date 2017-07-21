package com.orange.ease.dan;


import android.content.Context;
import android.support.v4.app.ListFragment;
import android.widget.ListView;

import com.orange.ease.dan.navFragments.OnNewFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment
public abstract class BaseListFragment extends ListFragment{

    @ViewById(android.R.id.list)
    public ListView listView;

    protected OnNewFragment mOnNewFragment;

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

}

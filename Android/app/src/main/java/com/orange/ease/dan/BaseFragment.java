package com.orange.ease.dan;


import android.content.Context;
import androidx.fragment.app.Fragment;

import com.orange.ease.dan.navFragments.OnNewFragment;

public class BaseFragment extends Fragment{

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

package com.orange.ease.dan.navigation

import androidx.fragment.app.Fragment

public interface FragmentManagerActivity {
    fun updateFragmentWithExample()
    fun updateSpecificFragment(fragment: Fragment)
    fun addSpecificFragment(fragment: Fragment)
    fun back()
    fun setMenuActionVisibility(isVisible: Boolean)
}
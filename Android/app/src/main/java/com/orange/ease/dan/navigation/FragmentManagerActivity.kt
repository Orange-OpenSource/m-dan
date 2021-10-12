package com.orange.ease.dan.navigation

import androidx.fragment.app.Fragment

interface FragmentManagerActivity {
    public fun updateFragmentWithExample()
    public fun updateSpecificFragment(fragment: Fragment)
    public fun addSpecificFragment(fragment: Fragment)
    public fun back()
}
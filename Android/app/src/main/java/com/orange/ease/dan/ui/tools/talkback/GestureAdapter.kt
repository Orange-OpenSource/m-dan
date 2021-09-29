package com.orange.ease.dan.ui.tools.talkback

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.orange.ease.dan.model.Gesture

class GestureAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private var gestures: List<Gesture> = listOf()

    override fun getItemCount(): Int = gestures.size

    override fun createFragment(position: Int): Fragment {
        val fragment = GestureFragment()
        fragment.setGestureValues(gestures[position], position+1, gestures.size)
        return fragment
    }

    public fun setGestures(gestures: List<Gesture>) {
        this.gestures = gestures
    }
}
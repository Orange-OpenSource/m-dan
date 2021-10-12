package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class FocusColorExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.buttongeneric, null)
        accessibleView.findViewById<Button>(R.id.btngeneric).text = context.getString(R.string.criteria_accessible_example)
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.button_no_focused, null)
        notAccessibleView.findViewById<Button>(R.id.btngeneric).text = context.getString(R.string.criteria_not_accessible_example)
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.example_focus_color_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.getString(R.string.example_focus_color_title)
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.example_focus_color_desc)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



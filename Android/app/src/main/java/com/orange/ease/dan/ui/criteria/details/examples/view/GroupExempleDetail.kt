package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class GroupExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.grouped_elements, null)
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.ungrouped_elements, null)
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.example_group_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.getString(R.string.example_group_title)
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.example_group_desc)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



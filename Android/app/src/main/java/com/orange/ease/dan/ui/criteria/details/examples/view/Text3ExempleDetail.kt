package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.view.MatchFieldView
import java.text.SimpleDateFormat
import java.util.*

class Text3ExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.exalt_football_match_field, null) as RelativeLayout

        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.exalt_football_match_field, null) as RelativeLayout

        val matchField = myView2.findViewById<View>(R.id.match_field_view) as MatchFieldView
        matchField.setAccessible(false)

        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex3_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_alt_list)[2]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex3_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



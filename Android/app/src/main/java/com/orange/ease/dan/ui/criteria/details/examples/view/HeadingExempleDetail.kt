package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class HeadingExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(R.layout.headings_example, null)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.headings_example, null)
        notAccessibleView.findViewById<TextView>(R.id.section1).isAccessibilityHeading = false
        notAccessibleView.findViewById<TextView>(R.id.section2).isAccessibilityHeading = false
        notAccessibleView.findViewById<TextView>(R.id.section3).isAccessibilityHeading = false
        return inflater.inflate(R.layout.headings_example, null)
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.example_headings_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.getString(R.string.example_headings_title)
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.example_headings_desc)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ColorExemple1Detail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.excolor1_list, null) as LinearLayout
        val tv = accessibleView.findViewById<TextView>(R.id.textViewsubtitle)
        tv.setTextColor(ContextCompat.getColor(context, R.color.functional_greys_2))
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.excolor1_list, null) as LinearLayout

        val tvDescNo = notAccessibleView.findViewById<TextView>(R.id.exDesc)
        tvDescNo.text = context.getString(R.string.criteria_color_ex1_not_accessible_desc)
        val tvTitleNo = notAccessibleView.findViewById<TextView>(R.id.textViewlisttitle)
        tvTitleNo.setTextColor(ContextCompat.getColor(context, R.color.functional_greys_3))
        val tvNo = notAccessibleView.findViewById<TextView>(R.id.textViewsubtitle)
        tvNo.setTextColor(ContextCompat.getColor(context, R.color.functional_greys_4))
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_color_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_color_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_color_ex1_description)
    }

    override fun useOption(): Boolean {
        return false
    }

    override fun getOptionRessource(context: Context): String? {
        return null
    }
}



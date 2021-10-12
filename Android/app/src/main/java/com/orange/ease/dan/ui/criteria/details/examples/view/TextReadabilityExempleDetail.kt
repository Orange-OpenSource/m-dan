package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class TextReadabilityExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.ex_texte_readability_frag, null) as LinearLayout
        accessibleView.findViewById<TextView>(R.id.notReadableTextItalic).visibility = View.GONE
        accessibleView.findViewById<TextView>(R.id.notReadableTextSerif).visibility = View.GONE
        accessibleView.findViewById<TextView>(R.id.notReadableTextSmall).visibility = View.GONE
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.ex_texte_readability_frag, null) as LinearLayout

        notAccessibleView.findViewById<TextView>(R.id.readableText).visibility = View.GONE
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_text_readability_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_textsize_list)[1]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_text_readability_description)
    }

    override fun hasUseOption(): Boolean {
        return false
    }
}



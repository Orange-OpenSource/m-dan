package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class TextSizeExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.exsizetxt1_frag, null) as LinearLayout

        val tvNo = myView.findViewById<View>(R.id.textView34) as TextView
        myView.removeView(tvNo)
        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.exsizetxt1_frag, null) as LinearLayout

        //  val tvNo = myView2.findViewById<View>(R.id.textView34) as TextView
        myView2.removeView(myView2.findViewById(R.id.textView33))
        // myView2.addView(tvNo)
        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_textsize_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_textsize_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_textsize_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



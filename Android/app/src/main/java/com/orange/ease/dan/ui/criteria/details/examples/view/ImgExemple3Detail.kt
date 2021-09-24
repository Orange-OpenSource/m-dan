package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ImgExemple3Detail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.eximg3_frag, null) as LinearLayout

        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.eximg3_frag, null) as LinearLayout

        myView2.findViewById<View>(R.id.imageView7).contentDescription = ""

        myView2.findViewById<View>(R.id.imageButtonedit).contentDescription =
            context.getString(R.string.criteria_img_ex3_cd_btn_edit)

        myView2.findViewById<View>(R.id.imageButtonsettings).contentDescription =
            context.getString(R.string.criteria_img_ex3_cd_btn_parameters)

        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_img_ex3_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_img_list)[2]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_img_ex3_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



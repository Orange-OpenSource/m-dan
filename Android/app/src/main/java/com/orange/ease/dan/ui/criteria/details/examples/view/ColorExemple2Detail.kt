package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ColorExemple2Detail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myViewAxsYes = inflater.inflate(R.layout.excolor2_frag, null) as LinearLayout

        val tvmail = myViewAxsYes.findViewById<View>(R.id.textView42) as TextView
        tvmail.contentDescription =
            context.getString(R.string.criteria_color_ex2_service).toString() + " " + tvmail.text.toString()
        myViewAxsYes.findViewById<View>(R.id.imageView15).contentDescription =
            tvmail.contentDescription.toString() + " " + context.getString(R.string.criteria_color_ex2_cd_active)

        val tvmusic = myViewAxsYes.findViewById<View>(R.id.textView41) as TextView
        tvmusic.contentDescription =
            context.getString(R.string.criteria_color_ex2_service).toString() + " " + tvmusic.text.toString()
        myViewAxsYes.findViewById<View>(R.id.imageView17).contentDescription =
            tvmusic.contentDescription.toString() + " " + context.getString(R.string.criteria_color_ex2_cd_error)

        val tvvideo = myViewAxsYes.findViewById<View>(R.id.textView43) as TextView
        tvvideo.contentDescription =
            context.getString(R.string.criteria_color_ex2_service).toString() + " " + tvvideo.text.toString()
        myViewAxsYes.findViewById<View>(R.id.imageView19).contentDescription =
            tvvideo.contentDescription.toString() + " " + context.getString(R.string.criteria_color_ex2_cd_inactive)

        val tvweb: TextView = myViewAxsYes.findViewById<View>(R.id.textView44) as TextView
        tvweb.contentDescription =
            context.getString(R.string.criteria_color_ex2_service).toString() + " " + tvweb.text.toString()
        myViewAxsYes.findViewById<View>(R.id.imageView21).contentDescription =
            tvweb.contentDescription.toString() + " " + context.getString(R.string.criteria_color_ex2_cd_error)

        return myViewAxsYes
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val myViewAxsNo = inflater.inflate(R.layout.excolor2_frag, null) as LinearLayout
        myViewAxsNo.removeView(myViewAxsNo.findViewById(R.id.legendlayout))
        myViewAxsNo.removeView(myViewAxsNo.findViewById(R.id.virtualSeparator))

        val ivNo1 = myViewAxsNo.findViewById<View>(R.id.imageView15) as ImageView
        val tv1 = myViewAxsNo.findViewById<View>(R.id.textView42) as TextView
        val ivNo2 = myViewAxsNo.findViewById<View>(R.id.imageView17) as ImageView
        val tv2 = myViewAxsNo.findViewById<View>(R.id.textView41) as TextView
        val ivNo3 = myViewAxsNo.findViewById<View>(R.id.imageView19) as ImageView
        val tv3 = myViewAxsNo.findViewById<View>(R.id.textView43) as TextView
        val ivNo4 = myViewAxsNo.findViewById<View>(R.id.imageView21) as ImageView
        val tv4 = myViewAxsNo.findViewById<View>(R.id.textView44) as TextView

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ivNo1.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            tv1.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            ivNo2.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            ivNo2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_circle))
            tv2.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            ivNo3.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            ivNo3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_circle))
            tv3.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            ivNo4.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
            ivNo4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_circle))
            tv4.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
        } else {
            ivNo2.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_circle))
            ivNo3.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_circle))
            ivNo4.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.icon_circle))
        }
        return myViewAxsNo
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_color_ex2_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_color_list)[1]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_color_ex2_description)
    }

    override fun hasUseOption(): Boolean {
        return false
    }
}



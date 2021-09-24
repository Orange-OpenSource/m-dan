package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.readystatesoftware.viewbadger.BadgeView
import java.util.*

class Text2ExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.extxt2_frag, null) as LinearLayout

        val btn = myView.findViewById<View>(R.id.imageButton10) as ImageButton
        val badge = BadgeView(context, btn)
        badge.text = "3"
        badge.show()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            badge.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        btn.contentDescription =
            badge.text.toString() + " " + context.getString(R.string.criteria_alt_ex2_cd_btn)

        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.extxt2_frag, null) as LinearLayout

        val btnNo = myView2.findViewById<View>(R.id.imageButton10) as ImageButton
        val badgeNo = BadgeView(context, btnNo)
        badgeNo.text = "3"
        badgeNo.show()
        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex2_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_alt_list)[1]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex2_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



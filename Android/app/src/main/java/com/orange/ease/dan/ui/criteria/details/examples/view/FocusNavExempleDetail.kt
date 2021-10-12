package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class FocusNavExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val texteExempleAccessible = TextView(context)
        texteExempleAccessible.text = context.getString(R.string.criteria_focusnav_ex1_axs)
        val lyaxs = LinearLayout(context)
        val scale: Float = context.resources.displayMetrics.density
        lyaxs.setPadding((15 * scale + 0.5f).toInt(), 0, (15 * scale + 0.5f).toInt(), 0)
        lyaxs.orientation = LinearLayout.VERTICAL
        lyaxs.addView(texteExempleAccessible)
        return lyaxs
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.exfocusnav1_frag, null) as LinearLayout

        val ly = notAccessibleView.findViewById<LinearLayout>(R.id.listViewAxsNoFocusNav)
        val items: Array<String> = context.resources.getStringArray(R.array.criteria_focusnav_ex1_list)
        var mFakeListView: LinearLayout
        for (item in items) {
            mFakeListView =
                inflater.inflate(R.layout.list_item_content_change, null) as LinearLayout
            (mFakeListView.findViewById<View>(R.id.textCategory) as TextView).text =
                item
            ly.addView(mFakeListView)
        }
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_focusnav_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_focusnav_ex1_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_focusnav_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return false
    }
}



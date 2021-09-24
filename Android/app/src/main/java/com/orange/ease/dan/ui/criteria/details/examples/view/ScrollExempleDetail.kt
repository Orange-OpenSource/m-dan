package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.orange.ease.dan.R
import com.orange.ease.dan.guide.accessibility.lvl2.MyViewPager
import com.orange.ease.dan.ui.criteria.details.DetailsCriteriaActivity
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.ui.criteria.details.examples.pager.ViewPagerFragment

class ScrollExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnYes = myView.findViewById<View>(R.id.btngeneric) as Button
        btnYes.setText(context.getString(R.string.axsactivated))
        btnYes.setOnClickListener {
            val myPagerFragement: Fragment = ViewPagerFragment()
            val args = Bundle()
            args.putBoolean(MyViewPager.IS_ACCESSIBLE, true)
            myPagerFragement.arguments = args
            (context as DetailsCriteriaActivity?)?.let {
                it.updateSpecificFragment(myPagerFragement)
            }
        }
        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnNo = myView2.findViewById<View>(R.id.btngeneric) as Button
        btnNo.setText(context.getString(R.string.axsdisabled))

        btnNo.setOnClickListener {
            val myPagerFragement: Fragment = ViewPagerFragment()
            val args = Bundle()
            args.putBoolean(MyViewPager.IS_ACCESSIBLE, false)
            args.putBoolean(MyViewPager.IS_SCROLLEX, true)
            myPagerFragement.arguments = args
            (context as DetailsCriteriaActivity?)?.let {
                it.updateSpecificFragment(myPagerFragement)
            }
        }
        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_scroll_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_scroll_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_scroll_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



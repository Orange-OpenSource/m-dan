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
import com.orange.ease.dan.guide.accessibility.lvl2.MyViewPagerDiapo
import com.orange.ease.dan.ui.criteria.details.DetailsCriteriaActivity
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.ui.criteria.details.examples.pager.ViewPagerDiapoFragment

class ControlContentExemple2Detail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnYes = accessibleView.findViewById<Button>(R.id.btngeneric)
        btnYes.text = context.getString(R.string.axsactivated)

        btnYes.setOnClickListener {
            val myDiapoFragement: Fragment = ViewPagerDiapoFragment()
            val args = Bundle()
            args.putBoolean(MyViewPager.IS_ACCESSIBLE, true)
            myDiapoFragement.arguments = args
            (context as DetailsCriteriaActivity?)?.let {
                it.updateSpecificFragment(myDiapoFragement)
            }
        }
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnNo = notAccessibleView.findViewById<Button>(R.id.btngeneric)
        btnNo.text = context.getString(R.string.axsdisabled)
        btnNo.setOnClickListener {
            val myDiapoFragement: Fragment = ViewPagerDiapoFragment()
            val args = Bundle()
            args.putBoolean(MyViewPager.IS_ACCESSIBLE, false)
            myDiapoFragement.arguments = args
            (context as DetailsCriteriaActivity?)?.let {
                it.updateSpecificFragment(myDiapoFragement)
            }
        }
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_contentcontrol_ex2_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_contentcontrol_list)[1]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_contentcontrol_ex2_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }

}



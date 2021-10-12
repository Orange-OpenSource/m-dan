package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.navigation.FragmentManagerActivity

class GhostExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnYes = accessibleView.findViewById<Button>(R.id.btngeneric)
        btnYes.text = context.getString(R.string.axsactivated)
        btnYes.setOnClickListener {
            val accessibleGhostFragment = GhostExemple2Detail()
            val accessibleGhostFragmentBundle = Bundle()
            accessibleGhostFragmentBundle.putString(
                "content",
                context.getString(R.string.criteria_ghostelement_ex1_ghost)
            )
            accessibleGhostFragment.arguments = accessibleGhostFragmentBundle
            (context as FragmentManagerActivity?)?.let {
                it.updateSpecificFragment(accessibleGhostFragment)
            }
        }
        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.buttongeneric, null) as LinearLayout

        val btnNo = notAccessibleView.findViewById<Button>(R.id.btngeneric)
        btnNo.text = context.getString(R.string.axsdisabled)
        btnNo.setOnClickListener {
            val notAccessibleGhostFragment = GhostExemple2Detail()
            val notAccessibleGhostFragmentBundle = Bundle()
            notAccessibleGhostFragmentBundle.putString(
                "content",
                context.getString(R.string.criteria_ghostelement_ex1_noghost)
            )
            notAccessibleGhostFragment.arguments = notAccessibleGhostFragmentBundle
            (context as FragmentManagerActivity?)?.let {
                it.addSpecificFragment(notAccessibleGhostFragment)
            }
        }
        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_ghostelement_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_ghostelement_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_ghostelement_ex1_description)
    }

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



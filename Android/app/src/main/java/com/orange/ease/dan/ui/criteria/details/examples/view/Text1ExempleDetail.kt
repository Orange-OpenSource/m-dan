package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import java.text.SimpleDateFormat
import java.util.*

class Text1ExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.extxt1_frag, null) as LinearLayout

        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(context.getString(R.string.date_format), Locale.getDefault())
        val date = sdf.format(c.time)

        val monthName = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())

        val ex1 = myView.findViewById<View>(R.id.ex1txt1) as TextView

        ex1.text = date
        ex1.contentDescription =
            c[Calendar.DAY_OF_MONTH].toString() + " " + monthName + " " + c[Calendar.YEAR] + " , " + (c[Calendar.HOUR] + 12) + " " + context.getString(
                R.string.heure
            ) + " " + c[Calendar.MINUTE]

        myView.findViewById<View>(R.id.ex2txt1).contentDescription =
            context.getString(R.string.criteria_alt_ex1_cd_txt1)
        myView.findViewById<View>(R.id.ex3txt1).contentDescription =
            context.getString(R.string.criteria_alt_ex1_cd_txt2)
        myView.findViewById<View>(R.id.ex4txt1).contentDescription =
            context.getString(R.string.criteria_alt_ex1_cd_txt3)

        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.extxt1_frag, null) as LinearLayout
        myView2.removeView(myView2.findViewById(R.id.ex3txt1))

        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(context.getString(R.string.date_format), Locale.getDefault())
        val date = sdf.format(c.time)

        val ex1AxsNo = myView2.findViewById<View>(R.id.ex1txt1) as TextView
        ex1AxsNo.setText(date)
        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_alt_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_alt_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



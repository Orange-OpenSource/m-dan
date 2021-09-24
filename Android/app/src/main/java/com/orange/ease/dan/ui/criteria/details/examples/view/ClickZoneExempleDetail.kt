package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ClickZoneExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val myViewAxsYes = inflater.inflate(R.layout.exclickzone1_frag_lvl2, null) as LinearLayout

        val tb = myViewAxsYes.findViewById<View>(R.id.tableRow) as TableRow

        val ibYes = myViewAxsYes.findViewById<View>(R.id.imageButtonplay)
        val titlemusic = myViewAxsYes.findViewById<View>(R.id.textView30) as TextView
        ibYes.contentDescription =
            context.getString(R.string.criteria_clickarea_ex1_play).toString() + " " + titlemusic.text
        ibYes.isFocusable = false
        tb.setContentDescription(
            context.getString(R.string.criteria_clickarea_ex1_music).toString() + " " + titlemusic.text + " " + context.getString(
                R.string.criteria_clickarea_ex1_author
            ) + " " + (myViewAxsYes.findViewById<View>(R.id.textView31) as TextView).text
        )

        ibYes.setOnClickListener {
            Toast.makeText(
                context,
                context.getString(R.string.criteria_clickarea_ex1_success),
                Toast.LENGTH_SHORT
            ).show()
        }

        return myViewAxsYes
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val myViewAxsNo = inflater.inflate(R.layout.exclickzone1_frag_lvl2, null) as LinearLayout
        val scale: Float = context.getResources().getDisplayMetrics().density

        val titlemusic = myViewAxsNo.findViewById<View>(R.id.textView30) as TextView
        val authormusic = myViewAxsNo.findViewById<View>(R.id.textView31) as TextView

        val ibNo = myViewAxsNo.findViewById<View>(R.id.imageButtonplay) as ImageButton
        ibNo.background =
            ContextCompat.getDrawable(context, R.drawable.play_bad_button_selector)
        val layoutParams =
            LinearLayout.LayoutParams((12 * scale + 0.5f).toInt(), (12 * scale + 0.5f).toInt())
        layoutParams.gravity = Gravity.CENTER
        ibNo.layoutParams = layoutParams
        ibNo.contentDescription =
            context.getString(R.string.criteria_clickarea_ex1_play).toString() + " " + titlemusic.getText()
        ibNo.isFocusable = false
        val tbNo = myViewAxsNo.findViewById<View>(R.id.tableRow) as TableRow
        tbNo.contentDescription =
            context.getString(R.string.criteria_clickarea_ex1_music).toString() + " " + titlemusic.getText() + " " + context.getString(
                R.string.criteria_clickarea_ex1_author
            ) + " " + authormusic.getText()
        ibNo.setOnClickListener {
            Toast.makeText(
                context,
                context.getString(R.string.criteria_clickarea_ex1_success),
                Toast.LENGTH_SHORT
            ).show()
        }
        return myViewAxsNo
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_clickarea_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_clickarea_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_clickarea_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



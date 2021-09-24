package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ImgExemple1Detail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.exform1_frag, null) as LinearLayout


        // Commons params for ImageView
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP

        // Accessible ImageView
        val accessibileImageView = ImageView(context)
        accessibileImageView.adjustViewBounds = true
        accessibileImageView.contentDescription = context.getString(R.string.criteria_img_ex1_cd_image)
        accessibileImageView.layoutParams = params
        accessibileImageView.setImageResource(R.drawable.exampleimg)

        return accessibileImageView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // Commons params for ImageView
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP


        // Not accessible ImageView
        val notAccessibileImageView = ImageView(context)
        notAccessibileImageView.layoutParams = params
        notAccessibileImageView.adjustViewBounds = true
        notAccessibileImageView.setImageResource(R.drawable.exampleimg)
        return notAccessibileImageView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_img_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_img_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_img_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



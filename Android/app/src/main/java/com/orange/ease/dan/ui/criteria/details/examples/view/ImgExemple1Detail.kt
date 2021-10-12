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
       // Commons params for ImageView
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP

        // Accessible ImageView
        val accessibleImageView = ImageView(context)
        accessibleImageView.adjustViewBounds = true
        accessibleImageView.contentDescription = context.getString(R.string.criteria_img_ex1_cd_image)
        accessibleImageView.layoutParams = params
        accessibleImageView.setImageResource(R.drawable.exampleimg)

        return accessibleImageView
    }

    override fun getNotAccessibleExample(context: Context): View {
        // Commons params for ImageView
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP


        // Not accessible ImageView
        val notAccessibleImageView = ImageView(context)
        notAccessibleImageView.layoutParams = params
        notAccessibleImageView.adjustViewBounds = true
        notAccessibleImageView.setImageResource(R.drawable.exampleimg)
        return notAccessibleImageView
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

    override fun useOption(): Boolean {
        return true
    }

    override fun getOptionRessource(context: Context): String? {
        return context.getString(R.string.criteria_template_option_tb)
    }
}



package com.orange.ease.dan.data

import com.orange.ease.dan.R
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.model.Option
import com.orange.ease.dan.model.OptionClassic
import com.orange.ease.dan.model.OptionTalkback

object OptionRepository {

    private val optionColorCorrection = OptionClassic(
        resTitle = R.string.options_colors_correction_title,
        description = R.string.options_content_colors
    )

    private val optionColorInversion = OptionClassic(
        resTitle = R.string.options_colors_inversion_title,
        description = R.string.options_content_colorInversion
    )

    private val optionZoom= OptionClassic(
        resTitle = R.string.options_zoom_title,
        description = R.string.options_content_zoom
    )

    private val optionTextSize = OptionClassic(
        resTitle = R.string.options_magnification_title,
        description = R.string.options_content_txtSize
    )

    private val optionTalkback = OptionTalkback(
        resTitle = R.string.options_talkback_title
    )

    private var currentOption: AccessibilityEntity? = null

    fun getCurrentOption(): AccessibilityEntity? {
        return currentOption
    }

    fun setCurrentOption(option: AccessibilityEntity) {
        currentOption = option
    }

    fun getListOfOption(): List<AccessibilityEntity> {
        return listOf<AccessibilityEntity>(
            optionTalkback,
            optionTextSize,
            optionZoom,
            optionColorCorrection,
            optionColorInversion
        )
    }
}


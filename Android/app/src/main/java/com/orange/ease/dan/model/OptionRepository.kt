package com.orange.ease.dan.model

import com.orange.ease.dan.R

object OptionRepository {

    private val optionColorCorrection = OptionClassic(
        title = R.string.options_colors_correction_title,
        description = R.string.options_content_colors
    )

    private val optionColorInversion = OptionClassic(
        title = R.string.options_colors_inversion_title,
        description = R.string.options_content_colorInversion
    )

    private val optionZoom= OptionClassic(
        title = R.string.options_zoom_title,
        description = R.string.options_content_zoom
    )

    private val optionTextSize = OptionClassic(
        title = R.string.options_magnification_title,
        description = R.string.options_content_txtSize
    )

    private val optionTalkback = OptionTalkback(
        title = R.string.options_talkback_title
    )

    private var currentOption: Option? = null

    fun getCurrentOption(): Option? {
        return currentOption
    }

    fun setCurrentOption(option: Option) {
        currentOption = option
    }

    fun getListOfOption(): List<Option> {
        return listOf<Option>(optionTalkback,
            optionTextSize,
            optionZoom,
            optionColorCorrection,
            optionColorInversion
        )
    }
}


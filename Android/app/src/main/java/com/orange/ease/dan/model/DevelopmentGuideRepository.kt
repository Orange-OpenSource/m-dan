package com.orange.ease.dan.model

import com.orange.ease.dan.R

object DevelopmentGuideRepository {

    private val guideAlt = DevelopmentGuide(
        titleRes = R.string.dev_title_alt,
        descriptionRes = R.string.dev_description_alt,
        linkRes = R.string.dev_lien_alt
    )

    private val guideAxsEvents = DevelopmentGuide(
        titleRes = R.string.dev_title_axsevents,
        descriptionRes = R.string.dev_description_axsevents,
        linkRes = R.string.dev_lien_axsevents
    )

    private val guideFocusNav = DevelopmentGuide(
        titleRes = R.string.dev_title_focusnav,
        descriptionRes = R.string.dev_description_focusnav,
        linkRes = R.string.dev_lien_focusnav
    )

    private val guideForms = DevelopmentGuide(
        titleRes = R.string.dev_title_form,
        descriptionRes = R.string.dev_description_form,
        linkRes = R.string.dev_lien_form
    )

    private val guideListVoc = DevelopmentGuide(
        titleRes = R.string.dev_title_listvoc,
        descriptionRes = R.string.dev_description_listvoc,
        linkRes = null
    )

    private val guideLive = DevelopmentGuide(
        titleRes = R.string.dev_title_liveregion,
        descriptionRes = R.string.dev_description_liveregion,
        linkRes = R.string.dev_lien_liveregion
    )

    private val guideHide = DevelopmentGuide(
        titleRes = R.string.dev_title_hideaxs,
        descriptionRes = R.string.dev_description_hideaxs,
        linkRes = R.string.dev_lien_hideaxs
    )

    private val guideReadOrder = DevelopmentGuide(
        titleRes = R.string.dev_title_talkbackreadorder,
        descriptionRes = R.string.dev_description_talkbackreadorder,
        linkRes = R.string.dev_lien_talkbackreadorder
    )

    private val guideTalkback = DevelopmentGuide(
        titleRes = R.string.dev_title_detect,
        descriptionRes = R.string.dev_description_detect,
        linkRes = null
    )

    private val guideTxtSize = DevelopmentGuide(
        titleRes = R.string.dev_title_textsize,
        descriptionRes = R.string.dev_description_txtsize,
        linkRes = R.string.dev_lien_txtsize
    )

    private val guideVoc = DevelopmentGuide(
        titleRes = R.string.dev_title_voc,
        descriptionRes = R.string.dev_description_voc,
        linkRes = R.string.dev_lien_voc
    )

    private val guideWebView = DevelopmentGuide(
        titleRes = R.string.dev_title_webview,
        descriptionRes = R.string.dev_description_webview,
        linkRes = null
    )

    private var currentGuide: DevelopmentGuide? = null

    fun getCurrentGuide(): DevelopmentGuide? {
        return currentGuide
    }

    fun setCurrentGuide(guide: DevelopmentGuide) {
        currentGuide = guide
    }

    fun getListOfGuide(): List<DevelopmentGuide> {
        return listOf<DevelopmentGuide>(
            guideAlt,
            guideAxsEvents,
            guideFocusNav,
            guideForms,
            guideListVoc,
            guideLive,
            guideHide,
            guideReadOrder,
            guideTalkback,
            guideTxtSize,
            guideVoc,
            guideWebView
        )
    }
}



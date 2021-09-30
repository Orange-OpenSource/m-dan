package com.orange.ease.dan.data

import com.orange.ease.dan.R
import com.orange.ease.dan.model.DevelopmentGuide

object DevelopmentGuideRepository {

    private val guideAlt = DevelopmentGuide(
        resTitle = R.string.dev_title_alt,
        resDescription = R.string.dev_description_alt,
        resLink = R.string.dev_lien_alt
    )

    private val guideAxsEvents = DevelopmentGuide(
        resTitle = R.string.dev_title_axsevents,
        resDescription = R.string.dev_description_axsevents,
        resLink = R.string.dev_lien_axsevents
    )

    private val guideFocusNav = DevelopmentGuide(
        resTitle = R.string.dev_title_focusnav,
        resDescription = R.string.dev_description_focusnav,
        resLink = R.string.dev_lien_focusnav
    )

    private val guideForms = DevelopmentGuide(
        resTitle = R.string.dev_title_form,
        resDescription = R.string.dev_description_form,
        resLink = R.string.dev_lien_form
    )

    private val guideListVoc = DevelopmentGuide(
        resTitle = R.string.dev_title_listvoc,
        resDescription = R.string.dev_description_listvoc,
        resLink = null
    )

    private val guideLive = DevelopmentGuide(
        resTitle = R.string.dev_title_liveregion,
        resDescription = R.string.dev_description_liveregion,
        resLink = R.string.dev_lien_liveregion
    )

    private val guideHide = DevelopmentGuide(
        resTitle = R.string.dev_title_hideaxs,
        resDescription = R.string.dev_description_hideaxs,
        resLink = R.string.dev_lien_hideaxs
    )

    private val guideReadOrder = DevelopmentGuide(
        resTitle = R.string.dev_title_talkbackreadorder,
        resDescription = R.string.dev_description_talkbackreadorder,
        resLink = R.string.dev_lien_talkbackreadorder
    )

    private val guideTalkback = DevelopmentGuide(
        resTitle = R.string.dev_title_detect,
        resDescription = R.string.dev_description_detect,
        resLink = null
    )

    private val guideTxtSize = DevelopmentGuide(
        resTitle = R.string.dev_title_textsize,
        resDescription = R.string.dev_description_txtsize,
        resLink = R.string.dev_lien_txtsize
    )

    private val guideVoc = DevelopmentGuide(
        resTitle = R.string.dev_title_voc,
        resDescription = R.string.dev_description_voc,
        resLink = R.string.dev_lien_voc
    )

    private val guideWebView = DevelopmentGuide(
        resTitle = R.string.dev_title_webview,
        resDescription = R.string.dev_description_webview,
        resLink = null
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



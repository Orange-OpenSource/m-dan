package com.orange.ease.dan.model

import com.orange.ease.dan.R

object CriteriaRepository {

    private val criteriaImage = Criteria(
        resTitle = R.string.criteria_img_title,
        resRuleDescription = R.string.criteria_img_rule_description,
        resWhyDescription = R.string.criteria_img_why_description,
        ExampleRepository.getListOfImageExample()
    )
    private val criteriaColor = Criteria(
        resTitle = R.string.criteria_color_title,
        resRuleDescription = R.string.criteria_color_rule_description,
        resWhyDescription = R.string.criteria_color_why_description,
        ExampleRepository.getListOfColorExample()
    )
    private val criteriaAlt = Criteria(
        resTitle = R.string.criteria_alt_title,
        resRuleDescription = R.string.criteria_alt_rule_description,
        resWhyDescription = R.string.criteria_alt_why_description,
        ExampleRepository.getListOfAltExample()
    )
    private val criteriaClickArea = Criteria(
        resTitle = R.string.criteria_clickarea_title,
        resRuleDescription = R.string.criteria_clickarea_rule_description,
        resWhyDescription = R.string.criteria_clickarea_why_description,
        ExampleRepository.getListOfClickZoneExample()
    )
    private val criteriaContentChange = Criteria(
        resTitle = R.string.criteria_title_contentchange,
        resRuleDescription = R.string.criteria_rule_description_contentchange,
        resWhyDescription = R.string.criteria_why_description_contentchange,
        ExampleRepository.getListOfContentChangeExample()
    )
    private val criteriaContentControl = Criteria(
        resTitle = R.string.criteria_contentcontrol_title,
        resRuleDescription = R.string.criteria_contentcontrol_rule_description,
        resWhyDescription = R.string.criteria_contentcontrol_why_description,
        ExampleRepository.getListOfContentControlExample()
    )
    private val criteriaElementsState = Criteria(
        resTitle = R.string.criteria_stateelements_title,
        resRuleDescription = R.string.criteria_stateelements_rule_description,
        resWhyDescription = R.string.criteria_stateelements_why_description,
        ExampleRepository.getListOfElementStateExample()
    )
    private val criteriaFocusNavigation = Criteria(
        resTitle = R.string.criteria_focusnav_title,
        resRuleDescription = R.string.criteria_focusnav_rule_description,
        resWhyDescription = R.string.criteria_focusnav_why_description,
        ExampleRepository.getListOfFocusExample()
    )
    private val criteriaGhost = Criteria(
        resTitle = R.string.criteria_ghostelement_title,
        resRuleDescription = R.string.criteria_ghostelement_rule_description,
        resWhyDescription = R.string.criteria_ghostelement_why_description,
        ExampleRepository.getListOfGhostExample()
    )
    private val criteriaReadOrder = Criteria(
        resTitle = R.string.criteria_readorder_title,
        resRuleDescription = R.string.criteria_readorder_rule_description,
        resWhyDescription = R.string.criteria_readorder_why_description,
        ExampleRepository.getListOfReadOrderExample()
    )
    private val criteriaScroll = Criteria(
        resTitle = R.string.criteria_horizontalscroll_title,
        resRuleDescription = R.string.criteria_horizontalscroll_rule_description,
        resWhyDescription = R.string.criteria_horizontalscroll_why_description,
        ExampleRepository.getListOfScrollExample()
    )
    private val criteriaStandardComponent = Criteria(
        resTitle = R.string.criteria_standardcomponent_title,
        resRuleDescription = R.string.criteria_standardcomponent_rule_description,
        resWhyDescription = R.string.criteria_standardcomponent_why_description,
        ExampleRepository.getStandardComponentExample()
    )
    private val criteriaTitles = Criteria(
        resTitle = R.string.criteria_title_title,
        resRuleDescription = R.string.criteria_title_rule_description,
        resWhyDescription = R.string.criteria_title_why_description,
        ExampleRepository.getListOfTitleExample()
    )
    private val criteriaTextSize = Criteria(
        resTitle = R.string.criteria_textsize_title,
        resRuleDescription = R.string.criteria_textsize_rule_description,
        resWhyDescription = R.string.criteria_textsize_why_description,
        ExampleRepository.getListOfTextSizeExample()
    )
    private val criteriaForm = Criteria(
        resTitle = R.string.criteria_form_title,
        resRuleDescription = R.string.criteria_form_rule_description,
        resWhyDescription = R.string.criteria_form_why_description,
        ExampleRepository.getListOfFormExample()
    )

    private var currentCriteria: Criteria? = null

    fun getCurrentCriteria(): Criteria? {
        return currentCriteria
    }

    fun setCurrentCriteria(criteria: Criteria) {
        currentCriteria = criteria
    }

    fun getListOfCriteria(): List<Criteria> {
        return listOf<Criteria>(criteriaImage,
            criteriaColor,
            criteriaAlt,
            criteriaTitles,
            criteriaElementsState,
            criteriaStandardComponent,
            criteriaClickArea,
            criteriaGhost,
            criteriaTextSize,
            criteriaContentControl,
            criteriaContentChange,
            criteriaScroll,
            criteriaForm,
            criteriaReadOrder,
            criteriaFocusNavigation
        )
    }
}


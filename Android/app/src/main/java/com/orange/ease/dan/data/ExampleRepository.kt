package com.orange.ease.dan.data

import android.os.Build
import com.orange.ease.dan.R
import com.orange.ease.dan.model.Example
import com.orange.ease.dan.ui.criteria.details.examples.view.*

object ExampleRepository {

    private val exampleChangeContent : Example by lazy {
        Example(resTitle = R.string.criteria_contentchange_item1, detailsExample = ChangeContentExempleDetail())
    }
    private val exampleClickZone : Example by lazy {
        Example(resTitle = R.string.criteria_clickarea_item1, detailsExample = ClickZoneExempleDetail())
    }
    private val exampleColor1 : Example by lazy {
        Example(resTitle = R.string.criteria_color_item1, detailsExample = ColorExemple1Detail())
    }
    private val exampleColor2 : Example by lazy {
        Example(resTitle = R.string.criteria_color_item2, detailsExample = ColorExemple2Detail())
    }
    private val exampleControlContent1 : Example by lazy {
        Example(resTitle = R.string.criteria_contentcontrol_item1, detailsExample = ControlContentExemple1Detail())
    }
    private val exampleControlContent2 : Example by lazy {
        Example(resTitle = R.string.criteria_contentcontrol_item2, detailsExample = ControlContentExemple2Detail())
    }
    private val exampleControlContent3 : Example by lazy {
        Example(resTitle = R.string.criteria_timetotakeaction_title, detailsExample = TimeTakeActionExempleDetail(), apiVersion = Build.VERSION_CODES.Q)
    }
    private val exampleFocusNav : Example by lazy {
        Example(resTitle = R.string.criteria_focusnav_item1, detailsExample = FocusNavExempleDetail())
    }
    private val exampleFocusColor : Example by lazy {
        Example(resTitle = R.string.example_focus_color_title, detailsExample = FocusColorExempleDetail())
    }
    private val exampleGhost : Example by lazy {
        Example(resTitle = R.string.criteria_ghostelement_item1, detailsExample = GhostExempleDetail())
    }
    private val exampleImage1 : Example by lazy {
        Example(resTitle = R.string.criteria_img_item1, detailsExample = ImgExemple1Detail())
    }
    private val exampleImage2 : Example by lazy {
        Example(resTitle = R.string.criteria_img_item2, detailsExample = ImgExemple2Detail())
    }
    private val exampleImage3 : Example by lazy {
        Example(resTitle = R.string.criteria_img_item3, detailsExample = ImgExemple3Detail())
    }

    private val exampleAlt1 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item1, detailsExample = ImgExemple3Detail())
    }
    private val exampleAlt2 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item2, detailsExample = ColorExemple1Detail())
    }

    private val exampleReadOrder : Example by lazy {
        Example(resTitle = R.string.criteria_readorder_item1, detailsExample = ReadOrderExempleDetail())
    }
    private val exampleScroll : Example by lazy {
        Example(resTitle = R.string.criteria_scroll_item1, detailsExample = ScrollExempleDetail())
    }
    private val exampleTextSize : Example by lazy {
        Example(resTitle = R.string.criteria_textsize_item1, detailsExample = TextSizeExempleDetail())
    }
    private val exampleTextReadability : Example by lazy {
        Example(resTitle = R.string.criteria_textsize_item2, detailsExample = TextReadabilityExempleDetail())
    }
    private val exampleStandardComponent1 : Example by lazy {
        Example(resTitle = R.string.criteria_standardcomponent_title, detailsExample = StandardComponentExempleDetail())
    }
    private val exampleStandardComponent2 : Example by lazy {
        Example(resTitle = R.string.criteria_standardcomponent_ex2_title, detailsExample = StandardComponent2ExempleDetail())
    }
    private val exampleStateElements1 : Example by lazy {
        Example(resTitle = R.string.criteria_stateelement_item1, detailsExample = StateElementsExempleDetail())
    }
    private val exampleStateElements2 : Example by lazy {
        Example(resTitle = R.string.criteria_stateelement_item2, detailsExample = StateElementsExemple2Detail())
    }
    private val exampleStateElements3 : Example by lazy {
        Example(resTitle = R.string.criteria_stateelement_item3, detailsExample = StateElementsExemple3Detail())
    }
    private val exampleTitle : Example by lazy {
        Example(resTitle = R.string.criteria_title_item1, detailsExample = TitleExempleDetail())
    }
    private val exampleText1 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item4, detailsExample = Text1ExempleDetail())
    }
    private val exampleText2 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item5, detailsExample = Text2ExempleDetail())
    }
    private val exampleText3 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item6, detailsExample = Text3ExempleDetail())
    }
    private val exampleGroup : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item7, detailsExample = GroupExempleDetail())
    }
    private val exampleHeading : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item8, detailsExample = HeadingExempleDetail(), apiVersion = Build.VERSION_CODES.P)
    }

    private val exampleForm : Example by lazy {
        Example(resTitle = R.string.criteria_form_item1, detailsExample = FormExempleDetail())
    }
    private val exampleFormError : Example by lazy {
        Example(resTitle = R.string.criteria_form_item2, detailsExample = FormErrorExempleDetail())
    }

    private val exampleAlt3 : Example by lazy {
        Example(resTitle = R.string.criteria_alt_item3, detailsExample = FormExempleDetail())
    }


    private var currentExample: Example? = null

    fun getCurrentCriteria(): Example? {
        return currentExample
    }

    fun setCurrentExample(example: Example) {
        currentExample = example
    }

    fun getListOfImageExample(): List<Example> {
        return listOf<Example>(
            exampleImage1, exampleImage2, exampleImage3
        )
    }

    fun getListOfColorExample(): List<Example> {
        return listOf<Example>(
            exampleColor1, exampleColor2
        )
    }

    fun getListOfAltExample(): List<Example> {
        return listOf<Example>(
            exampleAlt1, exampleAlt2, exampleAlt3, exampleText1, exampleText2,
            exampleText3, exampleGroup, exampleHeading
        )
    }

    fun getListOfClickZoneExample(): List<Example> {
        return listOf<Example>(
            exampleClickZone
        )
    }

    fun getListOfContentChangeExample(): List<Example> {
        return listOf<Example>(
            exampleChangeContent
        )
    }

    fun getListOfContentControlExample(): List<Example> {
        return listOf<Example>(
            exampleControlContent1, exampleControlContent2, exampleControlContent3
        )
    }

    fun getListOfElementStateExample(): List<Example> {
        return listOf<Example>(
            exampleStateElements1, exampleStateElements2, exampleStateElements3
        )
    }

    fun getListOfFocusExample(): List<Example> {
        return listOf<Example>(
            exampleFocusNav, exampleFocusColor
        )
    }

    fun getListOfFormExample(): List<Example> {
        return listOf<Example>(
            exampleForm, exampleFormError
        )
    }

    fun getListOfGhostExample(): List<Example> {
        return listOf<Example>(
            exampleGhost
        )
    }

    fun getListOfReadOrderExample(): List<Example> {
        return listOf<Example>(
            exampleReadOrder
        )
    }

    fun getListOfScrollExample(): List<Example> {
        return listOf<Example>(
            exampleScroll
        )
    }

    fun getStandardComponentExample(): List<Example> {
        return listOf<Example>(
            exampleStandardComponent1, exampleStandardComponent2
        )
    }

    fun getListOfTitleExample(): List<Example> {
        return listOf<Example>(
            exampleTitle
        )
    }

    fun getListOfTextExample(): List<Example> {
        return listOf<Example>(
            exampleTextSize, exampleTextReadability
        )
    }
}



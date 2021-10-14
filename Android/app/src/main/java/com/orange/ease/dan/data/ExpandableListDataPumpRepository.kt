package com.orange.ease.dan.data

import android.content.Context
import com.orange.ease.dan.R


object ExpandableListDataPumpRepository {

    fun getData(context: Context): HashMap<String, List<String>>? {
        val expandableListDetail: HashMap<String, List<String>> = HashMap()
        val technology: MutableList<String> = ArrayList()
        technology.add(context.getString(R.string.criteria_standardcomponent_ex1_category1_item1))
        technology.add(context.getString(R.string.criteria_standardcomponent_ex1_category1_item2))
        val entertainment: MutableList<String> = ArrayList()
        entertainment.add(context.getString(R.string.criteria_standardcomponent_ex1_category2_item1))
        entertainment.add(context.getString(R.string.criteria_standardcomponent_ex1_category2_item2))
        expandableListDetail[context.getString(R.string.criteria_standardcomponent_ex1_category1_name)] =
            technology
        expandableListDetail[context.getString(R.string.criteria_standardcomponent_ex1_category2_name)] =
            entertainment
        return expandableListDetail
    }
}


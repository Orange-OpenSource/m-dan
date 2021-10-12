package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.ChildItem
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.GroupItem
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.utils.Utils
import com.orange.ease.idunnololz.widgets.AnimatedExpandableListView
import java.util.*

class StandardComponent2ExempleDetail: AccessibilityDetailsExample {

    var mListView: AnimatedExpandableListView? = null
    var mListViewNo: AnimatedExpandableListView? = null
    var adapter: CustomExpandableListViewAdapter? = null
    var adapter2: CustomExpandableListViewAdapter? = null

    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val accessibleView = inflater.inflate(R.layout.exstateelmts3_frag, null) as LinearLayout

        val items: MutableList<GroupItem> = ArrayList()

        for (i in 1..2) {
            val item = GroupItem()
            item.title = context.getString(R.string.criteria_stateelement_ex3_grp) + i
            for (j in 0 until i) {
                val child = ChildItem()
                child.title = context.getString(R.string.criteria_stateelement_ex3_item) + j
                child.hint = "lorem ipsum"
                item.addItem(child)
            }
            items.add(item)
        }

        adapter = CustomExpandableListViewAdapter(context)
        adapter!!.setData(items)

        mListView = accessibleView.findViewById<AnimatedExpandableListView>(R.id.expandableListView)
        mListView!!.setAdapter(adapter)
        Utils.setListViewHeightBasedOnItems(mListView)

        mListView!!.setOnGroupClickListener { _, _, groupPosition, _ ->
            if (mListView!!.isGroupExpanded(groupPosition)) {
                mListView!!.collapseGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mListView)
            } else {
                mListView!!.expandGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mListView)
            }
            true
        }

        return accessibleView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val notAccessibleView = inflater.inflate(R.layout.exstateelmts3_frag, null) as LinearLayout

        val items: MutableList<GroupItem> = ArrayList()

        for (i in 1..2) {
            val item = GroupItem()
            item.title = context.getString(R.string.criteria_stateelement_ex3_grp) + i
            for (j in 0 until i) {
                val child = ChildItem()
                child.title = context.getString(R.string.criteria_stateelement_ex3_item) + j
                child.hint = "lorem ipsum"
                item.addItem(child)
            }
            items.add(item)
        }

        adapter2 = CustomExpandableListViewAdapter(context)
        adapter2!!.setData(items)
        adapter2!!.isAccessible = false

        mListViewNo = notAccessibleView.findViewById<AnimatedExpandableListView>(R.id.expandableListView)
        mListViewNo!!.setAdapter(adapter2)
        Utils.setListViewHeightBasedOnItems(mListViewNo)

        mListViewNo!!.setOnGroupClickListener { _, _, groupPosition, _ ->
            if (mListViewNo!!.isGroupExpanded(groupPosition)) {
                mListViewNo!!.collapseGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mListViewNo)
            } else {
                mListViewNo!!.expandGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mListViewNo)
            }
            true
        }

        return notAccessibleView
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_standardcomponent_ex2_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_scroll_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_standardcomponent_ex2_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.ChildItem
import com.orange.ease.dan.adapter.CustomExpandableListViewAdapter.GroupItem
import com.orange.ease.dan.guide.accessibility.lvl2.ExpandableListDataPump
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample
import com.orange.ease.dan.utils.Utils
import com.orange.ease.idunnololz.widgets.AnimatedExpandableListView
import java.util.*

class StandardComponentExempleDetail: AccessibilityDetailsExample {


    var mExpandableListViewAxsMore: ExpandableListView? = null
    var mExpandableListView: AnimatedExpandableListView? = null
    private var mExpandableListAdapterMore: ExpandableListAdapter? = null
    private var mExpandableListAdapter: CustomExpandableListViewAdapter? = null
    private var mExpandableListTitle: List<String>? = null
    private var mExpandableListDetail: HashMap<String, List<String>>? = null

    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.exstandardcomponent1_frag, null) as LinearLayout

        mExpandableListViewAxsMore =
            myView.findViewById<View>(R.id.expandableListView) as ExpandableListView
        mExpandableListDetail = ExpandableListDataPump.getData(context)
        mExpandableListTitle = (mExpandableListDetail as HashMap<String, MutableList<String>>?)?.keys?.toList()
        mExpandableListAdapterMore = com.orange.ease.dan.adapter.ExpandableListAdapter(
            context,
            mExpandableListTitle,
            mExpandableListDetail,
            true
        )
        mExpandableListViewAxsMore!!.setAdapter(mExpandableListAdapterMore)
        Utils.setListViewHeightBasedOnItems(mExpandableListViewAxsMore)
        mExpandableListViewAxsMore!!.setOnGroupExpandListener {
            Utils.setListViewHeightBasedOnItems(
                mExpandableListViewAxsMore
            )
        }

        mExpandableListViewAxsMore!!.setOnGroupCollapseListener {
            Utils.setListViewHeightBasedOnItems(
                mExpandableListViewAxsMore
            )
        }
        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.exstateelmts3_frag, null) as LinearLayout

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

        mExpandableListAdapter = CustomExpandableListViewAdapter(context)
        mExpandableListAdapter!!.setData(items)

        mExpandableListView =
            myView2.findViewById<View>(R.id.expandableListView) as AnimatedExpandableListView
        mExpandableListView!!.setAdapter(mExpandableListAdapter)

        Utils.setListViewHeightBasedOnItems(mExpandableListView)

        mExpandableListView!!.setOnGroupClickListener { parent, v, groupPosition, id ->
            if (mExpandableListView!!.isGroupExpanded(groupPosition)) {
                mExpandableListView!!.collapseGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mExpandableListView)
            } else {
                mExpandableListView!!.expandGroupWithAnimation(groupPosition)
                Utils.setListViewHeightBasedOnItems(mExpandableListView)
            }
            true
        }
        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_standardcomponent_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_scroll_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_standardcomponent_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }
}



package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.orange.ease.dan.R
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class ReadOrderExempleDetail: AccessibilityDetailsExample {
    override fun getAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView = inflater.inflate(R.layout.exreadorder_frag, null) as LinearLayout

        val volup = myView.findViewById<View>(R.id.volup) as ImageView
        val voldown = myView.findViewById<View>(R.id.voldown) as ImageView
        val chaineplus = myView.findViewById<View>(R.id.chaineplus) as ImageView
        val chainemoins = myView.findViewById<View>(R.id.chainemoins) as ImageView
        val remote1 = myView.findViewById<View>(R.id.remote1) as Button
        val remote2 = myView.findViewById<View>(R.id.remote2) as Button
        val remote3 = myView.findViewById<View>(R.id.remote3) as Button
        val remote4 = myView.findViewById<View>(R.id.remote4) as Button
        val remote5 = myView.findViewById<View>(R.id.remote5) as Button
        val remote6 = myView.findViewById<View>(R.id.remote6) as Button
        val remote7 = myView.findViewById<View>(R.id.remote7) as Button
        val remote8 = myView.findViewById<View>(R.id.remote8) as Button
        val remote9 = myView.findViewById<View>(R.id.remote9) as Button
        val remote0 = myView.findViewById<View>(R.id.remote0) as Button

        volup.contentDescription = context.getString(R.string.criteria_readorder_ex1_volup)
        voldown.contentDescription = context.getString(R.string.criteria_readorder_ex1_voldown)
        chaineplus.contentDescription = context.getString(R.string.criteria_readorder_ex1_canalup)
        chainemoins.contentDescription = context.getString(R.string.criteria_readorder_ex1_canaldown)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            //  remote1.accessibilityTraversalAfter = mTextViewTitleExempleAxsYes.getId()
            remote2.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote1).id
            remote3.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote2).id
            remote4.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote3).id
            remote5.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote4).id
            remote6.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote5).id
            remote7.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote6).id
            remote8.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote7).id
            remote9.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote8).id
            remote0.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote9).id
            volup.accessibilityTraversalAfter = myView.findViewById<View>(R.id.remote0).id
            voldown.accessibilityTraversalAfter = myView.findViewById<View>(R.id.volup).id
            chaineplus.accessibilityTraversalAfter = myView.findViewById<View>(R.id.voldown).id
            chainemoins.accessibilityTraversalAfter = myView.findViewById<View>(R.id.chaineplus).id
        }

        // setNextFocus(mTextViewTitleExempleAxsYes, 0, volup.id, 0, 0, volup.id)
        setNextFocus(volup, 0, voldown.id, chaineplus.id, remote1.id, voldown.id)
        setNextFocus(voldown, volup.id, remote7.id, chainemoins.id, remote4.id, chaineplus.id)
        setNextFocus(remote1, 0, remote4.id, volup.id, remote2.id, remote2.id)
        setNextFocus(remote2, 0, remote5.id, remote1.id, remote3.id, remote3.id)
        setNextFocus(remote3, 0, remote6.id, remote2.id, chaineplus.id, remote4.id)
        setNextFocus(remote4, remote1.id, remote7.id, volup.id, remote5.id, remote5.id)
        setNextFocus(remote5, remote2.id, remote8.id, remote4.id, remote6.id, remote6.id)
        setNextFocus(remote6, remote3.id, remote9.id, remote5.id, chaineplus.id, remote7.id)
        setNextFocus(remote7, remote4.id, remote0.id, voldown.id, remote8.id, remote8.id)
        setNextFocus(remote8, remote5.id, remote0.id, remote7.id, remote9.id, remote9.id)
        setNextFocus(remote9, remote6.id, remote0.id, remote8.id, chainemoins.id, remote0.id)
        //   setNextFocus(remote0, remote8.id, mTextViewTitleExempleAxsNo.getId(), remote7.id, remote9.id, volup.id)
        setNextFocus(chaineplus, 0, chainemoins.id, remote3.id, volup.id, chainemoins.id)
        //  setNextFocus(chainemoins, chaineplus.id, remote9.id, remote6.id, voldown.id, mTextViewTitleExempleAxsNo.getId())

        return myView
    }

    override fun getNotAccessibleExample(context: Context): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView2 = inflater.inflate(R.layout.exreadorder_frag, null) as LinearLayout

        return myView2
    }

    override fun getTitleRessource(context: Context): String {
        return context.getString(R.string.criteria_readorder_ex1_title)
    }

    override fun getCellNameRessource(context: Context): String {
        return context.resources.getStringArray(R.array.criteria_readorder_list)[0]
    }

    override fun getDescriptionRessource(context: Context): String {
        return context.getString(R.string.criteria_readorder_ex1_description)
    }

    override fun hasUseOption(): Boolean {
        return true
    }

    private fun setNextFocus(
        view: View,
        upid: Int,
        downid: Int,
        leftid: Int,
        rightid: Int,
        forwardid: Int
    ) {
        view.nextFocusUpId = upid
        view.nextFocusDownId = downid
        view.nextFocusLeftId = leftid
        view.nextFocusRightId = rightid
        view.nextFocusForwardId = forwardid
    }
}



package com.orange.ease.dan.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.orange.ease.idunnololz.widgets.AnimatedExpandableListView;

public class Utils {

    /**
     * Sets ExpandableListView height dynamically based on the height of the items.
     *
     * @param expandablelistView to be resized
     * @return true if the expandablelistView is successfully resized, false otherwise
     */
    public static boolean setListViewHeightBasedOnItems(ExpandableListView expandablelistView) {

        ExpandableListAdapter expandableListAdapter = expandablelistView.getExpandableListAdapter();
        if (expandableListAdapter != null) {

            int numberOfGroups = expandableListAdapter.getGroupCount();
            int numberOfDividers = numberOfGroups;

            // Get total height of all items of all group expanded
            int totalItemsHeight = 0;

            for (int groupPos = 0; groupPos < numberOfGroups; groupPos++) {

                View item = expandableListAdapter.getGroupView(groupPos, expandablelistView.isGroupExpanded(groupPos), null, expandablelistView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();

                if(expandablelistView.isGroupExpanded(groupPos)) {
                    totalItemsHeight += calculateHeightOfOneGroup(groupPos, expandableListAdapter, expandablelistView);
                    numberOfDividers += expandableListAdapter.getChildrenCount(groupPos);
                }
            }

            // Get total height of all item dividers.
            int totalDividersHeight = expandablelistView.getDividerHeight() * numberOfDividers;

            // Set list height.
            ViewGroup.LayoutParams params = expandablelistView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight + 5;
            expandablelistView.setLayoutParams(params);
            expandablelistView.requestLayout();

            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculate the height of an expanded group dynamically based on the height of the items.
     *
     * @param groupPos position of the current group
     * @param expandableListAdapter adapter of the expandableList
     * @param parent the parent that this view will eventually be attached to
     * @return true if the listView is successfully resized, false otherwise
     */
    public static int calculateHeightOfOneGroup(int groupPos, ExpandableListAdapter expandableListAdapter, ViewGroup parent) {

        int numberOfItems = expandableListAdapter.getChildrenCount(groupPos);

        // Get total height of all items in the group
        int totalItemsHeight = 0;

        for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {

            boolean lastItem = false;
            if(itemPos == numberOfItems-1){
                lastItem = true;
            }

            // Supprimer le if si on veut garder un truc générique. Ici, le if sert à gérer la cutom expandable en plus des expandables classiques
            View item;
            if(expandableListAdapter instanceof com.orange.ease.idunnololz.widgets.AnimatedExpandableListView.AnimatedExpandableListAdapter){
                item = ((AnimatedExpandableListView.AnimatedExpandableListAdapter) expandableListAdapter).getRealChildView(groupPos, itemPos, lastItem, null, parent);
            }else{
                item = expandableListAdapter.getChildView(groupPos, itemPos, lastItem, null, parent);
            }


            item.measure(0, 0);
            totalItemsHeight += item.getMeasuredHeight();
        }

        return totalItemsHeight;
    }
}

package com.bib.ems.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bib.ems.R
import com.bib.ems.activities.ExpandableList

class ExpandableListAdapter(
    val context: Context,
    val titleList: List<ExpandableList>,
    val dataList: LinkedHashMap<ExpandableList, List<ExpandableList>>
) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): Any {
        return this.titleList[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val listTitle = getGroup(groupPosition) as ExpandableList

        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_list_header, null)
        }
        val listTitleTextView = convertView!!.findViewById<TextView>(R.id.listHeader)

        listTitleTextView.text = listTitle.menu_title

        convertView.isEnabled = true
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return this.dataList[this.titleList[groupPosition]]!!.count()
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return this.dataList[this.titleList[groupPosition]]!![childPosition]

    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val expandedListText = getChild(groupPosition, childPosition) as ExpandableList
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_litst_item, null)
        }
        val expandedListTextView = convertView!!.findViewById<TextView>(R.id.listItem)

        expandedListTextView.text = expandedListText.menu_title

        convertView.isEnabled = true

        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return this.titleList.count()
    }
}
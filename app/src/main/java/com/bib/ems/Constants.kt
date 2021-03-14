package com.bib.ems

import com.bib.ems.activities.ExpandableList

class Constants {
    companion object{
        val leaveReportItem: LinkedHashMap<ExpandableList, List<ExpandableList>>
            get() {
                val listData = LinkedHashMap<ExpandableList, List<ExpandableList>>()
                //attendance
                val attendance = ArrayList<ExpandableList>()
                attendance.add(ExpandableList("Single Leave Report", R.drawable.ic_add_box_24dp))
                attendance.add(ExpandableList(" Long Term Leave History", R.drawable.ic_add_box_24dp))
                listData[ExpandableList("Leave Report", R.drawable.ic_baseline_calendar_today_24)] = attendance
                return listData
            }

        val addressItem: LinkedHashMap<ExpandableList, List<ExpandableList>>
            get() {
                val listData = LinkedHashMap<ExpandableList, List<ExpandableList>>()

                //Transportation
                val addressChanges=ArrayList<ExpandableList>()
                addressChanges.add(ExpandableList("Address Change Report",0))
                addressChanges.add(ExpandableList("Address Change History",0))
                listData[ExpandableList("Address Changes", 0)] = addressChanges

                return listData


            }
        val profileItem: LinkedHashMap<ExpandableList, List<ExpandableList>>
            get() {
                val listData = LinkedHashMap<ExpandableList, List<ExpandableList>>()
                //Transportation
                val profileChanges=ArrayList<ExpandableList>()
                profileChanges.add(ExpandableList("Profile Changes Report", 0))
                profileChanges.add(ExpandableList("Profile Changes History", 0))
                listData[ExpandableList("Profile Changes", 0)] = profileChanges
                return listData
            }
    }

}
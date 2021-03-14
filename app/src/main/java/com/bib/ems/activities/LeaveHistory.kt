package com.bib.ems.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bib.ems.R
import com.bib.ems.adapter.RecyclerViewAdapterLeaveHistory
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_leave_history.*

class LeaveHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_history)
        rcv_leave_history.layoutManager=LinearLayoutManager(this)
        rcv_leave_history.adapter=RecyclerViewAdapterLeaveHistory()
        backButton.setOnClickListener{
            val intent= Intent(this,Home::class.java)
            startActivity(intent)
        }
    }
}
class TotalLeaveList(val leaveItems:List<LeaveHistoryItem>)
class LeaveHistoryItem(val leave_day:Int,val reason:String,val date:String,val status:String)
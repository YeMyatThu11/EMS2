package com.bib.ems.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bib.ems.R
import kotlinx.android.synthetic.main.leave_history_item.view.*

class RecyclerViewAdapterLeaveHistory:RecyclerView.Adapter<RecyclerViewAdapterLeaveHistory.ViewHolder>() {
    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(parent?.context)
        val leave_item=layoutInflater.inflate(R.layout.leave_history_item,parent,false)
        return  ViewHolder(leave_item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
}
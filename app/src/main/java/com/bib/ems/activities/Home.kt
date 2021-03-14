
package com.bib.ems.activities

import android.animation.Animator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.animation.doOnEnd
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bib.ems.Constants
import com.bib.ems.R
import com.bib.ems.adapter.ExpandableListAdapter
import com.bib.ems.fragments.NonScrollExpandableListView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.navigation_drawer.*

class Home : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        toolbar.setTitle("")
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        leave_card.setOnClickListener{goToOtherActivity(this,LeaveHistory::class.java)}
        wfh_card.setOnClickListener{goToOtherActivity(this,LeaveHistory::class.java)}
        overtime_card.setOnClickListener{goToOtherActivity(this,LeaveHistory::class.java)}
        address_change_card.setOnClickListener{goToOtherActivity(this,LeaveHistory::class.java)}

        setSubMenu(nav_expandable_list1)
        setSubMenu(nav_expandable_list2)
        setSubMenu(nav_expandable_list3)

        overtime_btn.setOnClickListener(this)
        leave_btn.setOnClickListener (this)
        wfh_btn.setOnClickListener (this)
        address_change_btn.setOnClickListener (this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.leave_btn->setRippleEffectAnimation(v,this,LeaveHistory::class.java)
            R.id.overtime_btn->setRippleEffectAnimation(v,this,LeaveHistory::class.java)
            R.id.wfh_btn-> setRippleEffectAnimation(v,this,LeaveHistory::class.java)
            R.id.address_change_btn->setRippleEffectAnimation(v,this,LeaveHistory::class.java)
        }
    }

    fun setSubMenu(view: NonScrollExpandableListView){
        when(view?.id){
            R.id.nav_expandable_list1->addTitleToSubMenu(view,Constants.leaveReportItem)
            R.id.nav_expandable_list2->addTitleToSubMenu(view,Constants.addressItem)
            R.id.nav_expandable_list3->addTitleToSubMenu(view,Constants.profileItem)
        }

    }

    fun addTitleToSubMenu(expand_view: NonScrollExpandableListView,list_data:LinkedHashMap<ExpandableList,List<ExpandableList>>){
        val titleList = ArrayList(list_data.keys)
        val adapter =ExpandableListAdapter(this, titleList as ArrayList<ExpandableList>, list_data)
        expand_view.setAdapter(adapter)
        expand_view.setOnGroupClickListener { parent, v, groupPosition, id ->
            v.isEnabled=false
            return@setOnGroupClickListener false
        }
    }


    fun setRippleEffectAnimation(v:View,activity:Activity,className:Class<*>){
        Log.d("Onclick","Card on click evt reached")
        val cx=v.left
        val cy=v.bottom
        val radius=Math.max(v.width,v.height)
        val rippleEffect:Animator=ViewAnimationUtils.createCircularReveal(v,cx,cy,0f,radius.toFloat())
        rippleEffect.setDuration(400)
        rippleEffect.start()
        rippleEffect.doOnEnd {
            val intent= Intent(activity,className)
            startActivity(intent)
        }
    }

    fun goToOtherActivity(activity:Activity,className:Class<*>){
        Log.d("Onclick","Card on click evt reached")
        val intent= Intent(activity,className)
        startActivity(intent)
    }
}

class ExpandableList(var menu_title: String, var menu_icon: Int) {}
package com.example.sambo.onBoard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class OnBoardAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private  var list = arrayListOf<Fragment>()

    fun update(data : ArrayList<Fragment>){
        this.list = data
        notifyDataSetChanged()
    }
    override fun getCount() = list.size

    override fun getItem(position: Int) = list[position]
}
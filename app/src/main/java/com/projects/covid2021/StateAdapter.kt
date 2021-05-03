package com.projects.covid2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_list.view.*

class StateAdapter(val list: List<StatewiseItem>): BaseAdapter() {
    override fun getCount() = list.size

    override fun getItem(position: Int) = list[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_list, parent, false)
        val item = list[position]
        view.cnfrmdTv.text = SpannableDelta("${item.confirmed}\n ↑${item.deltaconfirmed?:0}","#DC143C", item.confirmed?.length?:0)
        view.rcvdtv.text = SpannableDelta("${item.recovered}\n ↑${item.deltarecovered?:0}","#00FF00", item.recovered?.length?:0)
        view.dedTV.text = item.deaths
        view.actvTV.text = item.active
        view.stteTv.text = item.state
        return view
    }
}
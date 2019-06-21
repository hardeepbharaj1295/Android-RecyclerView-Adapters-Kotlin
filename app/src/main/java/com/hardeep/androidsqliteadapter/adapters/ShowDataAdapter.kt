package com.hardeep.androidsqliteadapter.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hardeep.androidsqliteadapter.R

import com.hardeep.androidsqliteadapter.model.ShowDataContent.ShowContentItem

import kotlinx.android.synthetic.main.fragment_showdata.view.*


class ShowDataAdapter(
    private val mValues: List<ShowContentItem>
) : RecyclerView.Adapter<ShowDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_showdata, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.name
        holder.mContentView.text = item.email
        holder.mPassword.text = item.password

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val mPassword: TextView = mView.password

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}

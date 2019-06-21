package com.hardeep.androidsqliteadapter.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardeep.androidsqliteadapter.R
import com.hardeep.androidsqliteadapter.adapters.ShowDataAdapter

import com.hardeep.androidsqliteadapter.model.ShowDataContent
import com.hardeep.androidsqliteadapter.model.ShowDataContent.ShowContentItem
import com.hardeep.demoinsertion.database.DatabaseColumns
import com.hardeep.kotlinandroidinsertion.database.DatabaseQueries


class ShowDataFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_showdata_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                val db = DatabaseQueries(activity!!.baseContext)
                val cursor = db.getUsers()
                if(cursor.moveToFirst())
                {
                    ShowDataContent.ITEMS.clear()
                    do{
                        val item = ShowContentItem(cursor.getString(cursor.getColumnIndex(DatabaseColumns.USER_NAME)),
                            cursor.getString(cursor.getColumnIndex(DatabaseColumns.USER_EMAIL)),
                            cursor.getString(cursor.getColumnIndex(DatabaseColumns.USER_PASS)))

                        ShowDataContent.ITEMS.add(item)
                    }
                    while (cursor.moveToNext())
                }
                adapter = ShowDataAdapter(ShowDataContent.ITEMS)
            }
        }
        return view
    }

}

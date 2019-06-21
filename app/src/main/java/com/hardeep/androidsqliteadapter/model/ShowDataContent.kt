package com.hardeep.androidsqliteadapter.model

import java.util.ArrayList

object ShowDataContent {

    val ITEMS: ArrayList<ShowContentItem> = ArrayList()

    data class ShowContentItem(val name: String, val email: String, val password: String) {
        override fun toString(): String = email
    }
}

package com.hardeep.kotlinandroidinsertion.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.hardeep.demoinsertion.database.DatabaseColumns
import com.hardeep.demoinsertion.database.DatabaseCreation

class DatabaseQueries {

    var sql : DatabaseCreation?= null

    constructor(context: Context)
    {
        sql = DatabaseCreation(context)
    }

    /**
     * addUser Method for user registration
     */
    fun addUser(name:String,email:String,password:String):Long
    {
        val db = sql!!.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseColumns.USER_NAME,name)
        cv.put(DatabaseColumns.USER_EMAIL,email)
        cv.put(DatabaseColumns.USER_PASS,password)
        return db.insert(DatabaseColumns.TABLE_NAME,null,cv)
    }

    fun userLogin(email: String,password: String): Cursor
    {
        val db = sql!!.readableDatabase
        return db.query(
            DatabaseColumns.TABLE_NAME,null,DatabaseColumns.USER_EMAIL+"=? AND "+DatabaseColumns.USER_PASS+"=?",
            arrayOf(email,password),null, null,null)

    }

    /*
    * Fetch all users data
     */
    fun getUsers():Cursor{
        val db = sql!!.readableDatabase
        return db.query(DatabaseColumns.TABLE_NAME,null,null,null,null,null,null)
    }

}
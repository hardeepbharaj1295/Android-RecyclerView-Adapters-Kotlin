package com.hardeep.androidsqliteadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.hardeep.kotlinandroidinsertion.database.DatabaseQueries

class LoginActivity : AppCompatActivity() {

    lateinit var email : EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.password)

    }

    fun login(v: View) {
        val db = DatabaseQueries(this)
        val res = db.userLogin(email.text.toString(), pass.text.toString())
        if (res.moveToFirst())
        {
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Message")
                .setMessage("Login Successfully")
                .setPositiveButton("ok", null)
                .show()
        } else {
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Alert")
                .setMessage("Wrong Username/ Password")
                .setPositiveButton("ok", null)
                .show()
        }
    }

    fun home(v:View)
    {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)

    }
}

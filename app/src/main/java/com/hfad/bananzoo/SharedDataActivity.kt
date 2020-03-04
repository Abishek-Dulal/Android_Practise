package com.hfad.bananzoo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_data.*

class SharedDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_data)
        val pref=getPreferences(Context.MODE_PRIVATE)
        btnsave.setOnClickListener {
            val editor=pref.edit()
            editor.putString("lastname",txtlastname.text.toString())
            editor.putString("firstname",txtfirstname.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved data", Toast.LENGTH_LONG).show()
        }
        btnload.setOnClickListener{
            val mlastname = pref.getString("lastname", "")
            val mfirstname = pref.getString("firstname", "")
            val moutput = "$mfirstname $mlastname"
            txtoutput.text = moutput
        }

    }

    override fun onResume() {
        super.onResume()
        txtfirstname.setText("")
        txtlastname.setText("")
        txtfirstname.setHint("first name")
        txtlastname.setHint("last name")
        txtoutput.setText("")
    }


}

package com.hfad.bananzoo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bordcast_check.*
import java.lang.IllegalArgumentException
import java.util.logging.Logger

class BordcastCheck : AppCompatActivity() {

    lateinit var receiver:MyReceiver
    val Log = Logger.getLogger(javaClass.name)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bordcast_check)
        button.setOnClickListener {
            val intent = Intent("com.workingdev.DOSOMETHING")
            sendBroadcast(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter("com.workingdev.DOSOMETHING")
        registerReceiver(receiver, filter)
        Log.info("Registered receiver")
    }

    override fun onPause() {
        super.onPause()
        try{
         unregisterReceiver(receiver)
        }catch (iae:IllegalArgumentException){
            Log.warning(iae.toString())
        }
    }

}

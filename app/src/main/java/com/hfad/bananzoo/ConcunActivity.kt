package com.hfad.bananzoo

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_concun.*
import kotlin.coroutines.coroutineContext

class ConcunActivity : AppCompatActivity() {

    lateinit var worker:Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concun)

      }


       class Worker : AsyncTask<Void,String,Boolean>(){
          override fun doInBackground(vararg p0: Void?): Boolean {
              return true;
          }

      }




    }





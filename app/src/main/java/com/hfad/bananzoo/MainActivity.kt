package com.hfad.bananzoo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val SECOND_ACTIVITY=1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input_weight.setHint("weight (lbs)")
        input_height.setHint("height (inches)")

        btn_send_data.setOnClickListener {
          val m_intent =Intent(this@MainActivity,SecondActivity::class.java)
          val m_bundle=Bundle()
          m_bundle.putFloat("weight", input_weight.text.toString().toFloat())
          m_bundle.putFloat("height", input_height.text.toString().toFloat())
          m_intent.putExtra("main_activity_data", m_bundle)

          startActivityForResult(m_intent,SECOND_ACTIVITY)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == SECOND_ACTIVITY) and (resultCode == Activity.RESULT_OK)){
            val bmi = data!!.getFloatExtra("second_activity_data", 1.0F)
            val bmiString = "%.2f".format(bmi)
            input_height.setText("")
            input_weight.setText("")
            txt_bmi.setText("BMI : $bmiString ${getBmi(bmi)}")
        }
    }

    private fun getBmi(bmi:Float):String{
        return when(bmi){
            in 1.0..18.5 ->"UnderWeight"
            in 18.6..24.9->"Normal weight"
            in 25.0..29.9->"Overweight"
            else->"obese"
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun clearInputs(){
        input_weight.setText("")
        input_height.setText("")
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.menuFile->{
                showMessage("File Menu")
                return true
            }
            R.id.menuEdit->{
                showMessage("menu Edit")
                return true
            }
            R.id.menuHelp->{
                startActivity(Intent(this@MainActivity,ConcunActivity::class.java))
                return true
            }
            R.id.menuExit->{
                var intent = Intent(this@MainActivity,FragmentCheck::class.java);
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMessage(msg:String) {
        Snackbar.make(root_layout, msg, Snackbar.LENGTH_LONG).show()
    }


}

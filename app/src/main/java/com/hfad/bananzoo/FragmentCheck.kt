package com.hfad.bananzoo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fragment_check.*

class FragmentCheck : AppCompatActivity(),Coordinator {

    lateinit var fragBookDescription:BookDescription;
    lateinit var fragBookTitle:BookTitles;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_check)
        fragBookDescription= BookDescription();
        fragBookTitle= BookTitles();
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.add(R.id.fragtop,fragBookTitle)
        beginTransaction.add(R.id.fragbottom,fragBookDescription)
        beginTransaction.commit()
    }

    override fun onBookChanged(index: Int) {
        fragBookDescription.changeDescription(index)
    }
}

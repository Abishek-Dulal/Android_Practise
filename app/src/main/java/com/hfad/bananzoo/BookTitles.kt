package com.hfad.bananzoo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.fragment_book_titles.*

class BookTitles : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v=inflater.inflate(R.layout.fragment_book_titles, container, false)
        return v;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      rlas3.setOnClickListener(this)
      rlas3kotlin.setOnClickListener(this)
      rminandroid.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
      var index=0;
        when(view?.id){
            R.id.rlas3->{
                index=0
            }
            R.id.rlas3kotlin->{
                index=1
            }
            R.id.rminandroid->{
                index=2
            }
        }
         val activity=getActivity();
        if(activity is Coordinator){
            activity.onBookChanged(index)
        }

    }

}



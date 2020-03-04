package com.hfad.bananzoo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_book_description.*


/**
 * A simple [Fragment] subclass.
 *
 */
class BookDescription : Fragment() {

    lateinit var arrawbookdesc:Array<String>
    var bookindex=0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.fragment_book_description, container, false)
        arrawbookdesc=resources.getStringArray(R.array.bookdescriptions)
        bookindex = if(savedInstanceState?.getInt("bookindex")==null) 0 else savedInstanceState.getInt("bookindex")
        return v;
    }

    fun changeDescription(index:Int):Unit{
        bookindex=index
        txtdescription?.setText(arrawbookdesc[bookindex])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookindex)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bookindex",bookindex);
    }

}
package com.my.numbers.fragment


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.numbers.R
import kotlinx.android.synthetic.main.fragment_number.*


class NumberFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            val number = bundle.getInt(KEY_NUMBER, 0)
            val color = bundle.getInt(KEY_COLOR, Color.RED)

            textNumber?.text = number.toString()
            textNumber?.setTextColor(color)
        }
    }

    companion object {
        const val KEY_NUMBER = "number"
        const val KEY_COLOR = "color"
    }
}

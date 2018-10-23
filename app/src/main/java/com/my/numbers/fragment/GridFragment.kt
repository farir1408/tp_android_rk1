package com.my.numbers.fragment


import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.numbers.adapter.GridAdapter
import com.my.numbers.R
import kotlinx.android.synthetic.main.fragment_grid.*

class GridFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val orientation = resources.configuration.orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            grid?.layoutManager = GridLayoutManager(context, LANDSCAPE_SPAN_COUNT)
        } else {
            grid?.layoutManager = GridLayoutManager(context, PORTRAIT_SPAN_COUNT)
        }

        grid?.adapter = GridAdapter(listNumbers, context!!)

    }

    companion object {
        private const val LIST_SIZE = 1000
        private const val PORTRAIT_SPAN_COUNT = 3
        private const val LANDSCAPE_SPAN_COUNT = 4
        private val listNumbers = (1..LIST_SIZE).toList().toIntArray()
    }
}

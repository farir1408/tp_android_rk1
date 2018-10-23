package com.my.numbers.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.my.numbers.fragment.GridFragment
import com.my.numbers.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(GridFragment(), null, false)
        }
    }

    fun replaceFragment(fragment: Fragment, bundle: Bundle?, back: Boolean) {
        if (bundle != null) {
            fragment.arguments = bundle
        }
        if (back) {
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).addToBackStack(null).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        }
    }
}

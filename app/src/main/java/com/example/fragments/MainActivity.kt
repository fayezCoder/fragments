package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private var buttonFrag1:Button?=null
    private var buttonFrag2:Button?=null
    private var fragmentContainer:FrameLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        openFragment1()
        openFragment2()
    }
    private fun connectViews(){

        buttonFrag1 = findViewById(R.id.btnOpenFragment1)
        buttonFrag2 = findViewById(R.id.btnOpenFragment2)
        fragmentContainer = findViewById(R.id.fcontainer)
    }
    private fun openFragment1(){

        buttonFrag1?.setOnClickListener {
            // prepare code to open fragment1

            val fragmentTransaction:FragmentTransaction =supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fcontainer,FirstFragment(),"FIRST_FRAGMENT")
            fragmentTransaction.addToBackStack("FIRST_FRAGMENT")//Optional  تاثيرات
           fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)//Optional تاثيرات

            fragmentTransaction.commit()
        }
    }
    private fun openFragment2(){

        buttonFrag2?.setOnClickListener {
         // prepare code to open fragment2

            val fragmentTransaction:FragmentTransaction =supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fcontainer,SecondFragment(),"SECOND_FRAGMENT")
            fragmentTransaction.addToBackStack("FIRST_FRAGMENT")//Optional  تاثيرات
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)//Optional تاثيرات
            fragmentTransaction.commit()// تضع addToBackstack علشان ترجه للصفحه الي قبلهااذا شلتها راح يخرج من التطبيق
        }
    }
}
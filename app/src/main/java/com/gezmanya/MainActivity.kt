package com.gezmanya

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.gezmanya.ui.base.BaseActivity
import com.gezmanya.ui.login.LoginFragment

class MainActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val myFragment = LoginFragment()
        fragmentTransaction.add(R.id.frameContainer, myFragment).commit()
    }
}
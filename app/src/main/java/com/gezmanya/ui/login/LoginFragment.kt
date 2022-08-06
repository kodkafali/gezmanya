package com.gezmanya.ui.login

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gezmanya.R
import com.gezmanya.databinding.FragmentLoginBinding
import com.gezmanya.ui.base.BaseActivity
import com.gezmanya.ui.base.BaseFragment

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private lateinit var viewModel: LoginViewModel

    override fun initBinding(binding: ViewDataBinding) {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.init(binding, activity as BaseActivity)

        (binding as FragmentLoginBinding).loginViewModel = viewModel

        observerData()
    }

    private fun observerData(){
        viewModel.getLoginResult().observe(activity as BaseActivity, Observer { loginResult ->
            if(loginResult != null) {
                Log.e("Token: ", loginResult.token)
            }
        })
    }


}
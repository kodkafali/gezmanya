package com.gezmanya.ui.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gezmanya.MyApp
import com.gezmanya.databinding.FragmentLoginBinding
import com.gezmanya.model.LoginResult
import com.gezmanya.ui.base.BaseActivity
import com.gezmanya.ui.base.BaseViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : BaseViewModel(){

    @SuppressLint("StaticFieldLeak")
    private var activity : BaseActivity? = null
    private var loginResultlive : MutableLiveData<LoginResult>? = null
    private lateinit var binding : FragmentLoginBinding

    fun init(binding: ViewDataBinding, activity: BaseActivity){
        this.activity = activity
        this.binding = binding as FragmentLoginBinding
        setViewDataBinding(binding)
    }

    fun getLoginResult() : LiveData<LoginResult>{
        if (loginResultlive == null)
            loginResultlive = MutableLiveData<LoginResult>()

        return loginResultlive as LiveData<LoginResult>
    }


    fun onLoginClicked(email : String, pass : String){
        Firebase.auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            val status = it.isSuccessful
            val token = if(it.isSuccessful)
                it.result.user?.uid
            else
                ""

            val result = LoginResult(status = status, token = token.toString())
            loginResultlive?.postValue(result)
        }
    }

    override fun onCleared() {
        super.onCleared()
        activity?.let { loginResultlive?.removeObservers(it) }
    }

}
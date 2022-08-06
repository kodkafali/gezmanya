package com.gezmanya

import android.app.Application
import com.google.firebase.auth.ActionCodeSettings
import com.google.firebase.auth.ktx.actionCodeSettings

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApp
            private set
    }

    fun getFirebaseSetting() : ActionCodeSettings{

        val actionCodeSettings = actionCodeSettings {
            url = "https://www.example.com/finishSignUp?cartId=1234"
            handleCodeInApp = true
            //setIOSBundleId("com.example.ios")
            setAndroidPackageName(
                "com.gezmanya",
                true, /* installIfNotAvailable */
                "12" /* minimumVersion */)
        }

        return actionCodeSettings
    }

}
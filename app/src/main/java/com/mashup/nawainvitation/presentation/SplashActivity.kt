package com.mashup.nawainvitation.presentation

import android.os.Bundle
import com.mashup.nawainvitation.R
import com.mashup.nawainvitation.base.BaseActivity
import com.mashup.nawainvitation.data.base.BaseResponse
import com.mashup.nawainvitation.data.injection.Injection
import com.mashup.nawainvitation.databinding.ActivitySplashBinding
import com.mashup.nawainvitation.presentation.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    private val userRepository by lazy {
        Injection.provideUserRepository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userRepository.getUsers(object : BaseResponse<Any> {
            override fun onSuccess(data: Any) {
                MainActivity.startMainActivity(this@SplashActivity)
                finish()
            }

            override fun onFail(description: String) {
            }

            override fun onError(throwable: Throwable) {
            }

            override fun onLoading() {
            }

            override fun onLoaded() {
            }
        })
    }
}
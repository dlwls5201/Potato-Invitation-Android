package com.mashup.patatoinvitation

import android.app.Application
import com.mashup.patatoinvitation.utils.PreferenceUtils

class PotatoInvitationApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initPref()
    }

    private fun initPref() {
        PreferenceUtils.setInstance(this)
    }
}
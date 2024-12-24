package com.example.ucp2pam_079

import android.app.Application
import com.example.ucp2pam_079.data.dependenciesInjection.ContainerApp

class MainApp : Application() {

    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()

        containerApp = ContainerApp(this)
    }
}
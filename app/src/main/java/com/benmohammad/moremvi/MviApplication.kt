package com.benmohammad.moremvi

import android.app.Application
import com.benmohammad.moremvi.presentation.di.component.ApplicationComponent
import com.benmohammad.moremvi.presentation.di.component.DaggerApplicationComponent

class MviApplication: Application() {

    companion object {
        lateinit var appComponents: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDI()
    }

    private fun initDI(): ApplicationComponent =
            DaggerApplicationComponent.builder().application(this).build()
}
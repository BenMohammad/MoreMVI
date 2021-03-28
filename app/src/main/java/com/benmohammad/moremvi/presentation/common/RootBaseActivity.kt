package com.benmohammad.moremvi.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.moremvi.MviApplication
import com.benmohammad.moremvi.presentation.di.common.AppRouter
import com.benmohammad.moremvi.presentation.di.component.ActivityComponent
import com.benmohammad.moremvi.presentation.di.component.DaggerActivityComponent
import com.benmohammad.moremvi.presentation.di.module.ActivityModule
import com.benmohammad.moremvi.presentation.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

open class RootBaseActivity: AppCompatActivity() {

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this))
                .applicationComponent(MviApplication.appComponents).build()
    }

    @Inject
    lateinit var appRouter: AppRouter

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

}
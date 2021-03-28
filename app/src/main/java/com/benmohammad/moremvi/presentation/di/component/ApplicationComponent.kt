package com.benmohammad.moremvi.presentation.di.component

import com.benmohammad.moremvi.MviApplication
import com.benmohammad.moremvi.presentation.di.module.ApplicationModule
import com.benmohammad.moremvi.presentation.di.module.NetworkModule
import com.benmohammad.moremvi.presentation.di.viewmodels.DaggerViewModelFactory
import com.benmohammad.moremvi.presentation.di.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class])
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(app: MviApplication): Builder
    }

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory
}
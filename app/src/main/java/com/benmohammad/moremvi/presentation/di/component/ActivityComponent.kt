package com.benmohammad.moremvi.presentation.di.component

import com.benmohammad.moremvi.presentation.common.RootBaseActivity
import com.benmohammad.moremvi.presentation.di.annotations.ActivityScope
import com.benmohammad.moremvi.presentation.di.common.AppRouter
import com.benmohammad.moremvi.presentation.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(baseActivity: RootBaseActivity)
    fun appRouter(): AppRouter
}
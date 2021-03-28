package com.benmohammad.moremvi.presentation.di.module

import android.content.Context
import com.benmohammad.moremvi.data.managers.CharactersManager
import com.benmohammad.moremvi.data.managers.CharactersManagerImpl
import com.benmohammad.moremvi.data.services.ApiService
import com.benmohammad.moremvi.presentation.common.RootBaseActivity
import com.benmohammad.moremvi.presentation.di.common.AppRouter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val activity: RootBaseActivity) {

    @Provides
    fun providesActivityContext(): Context = activity.application

    @Provides
    fun providesActivity(): RootBaseActivity {return activity}

    @Provides
    fun providesRouterComponent(): AppRouter = AppRouter(activity)

    @Provides
    fun providesCharactersManager(apiService: ApiService): CharactersManager {
        return CharactersManagerImpl(apiService)
    }
}
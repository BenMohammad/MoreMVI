package com.benmohammad.moremvi.presentation.di.module

import android.app.Application
import android.content.Context
import com.benmohammad.moremvi.MviApplication
import com.benmohammad.moremvi.data.managers.CharactersManager
import com.benmohammad.moremvi.data.managers.CharactersManagerImpl
import com.benmohammad.moremvi.data.services.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext(application: MviApplication): Context = application.applicationContext


    @Provides
    @Singleton
    fun provideDataManagerAccessor(apiService: ApiService): CharactersManager {
        return CharactersManagerImpl(apiService)
    }
}
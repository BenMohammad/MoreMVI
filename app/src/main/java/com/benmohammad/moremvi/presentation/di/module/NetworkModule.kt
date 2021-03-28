package com.benmohammad.moremvi.presentation.di.module

import android.content.Context
import androidx.core.view.ViewCompat
import com.benmohammad.moremvi.data.services.ApiService
import com.facebook.stetho.okhttp3.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okio.Timeout
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpCache(context: Context): Cache {
        return Cache(context.cacheDir,  1024)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(6, TimeUnit.SECONDS)
                .writeTimeout(6, TimeUnit.SECONDS)
                .readTimeout(6, TimeUnit.SECONDS)
                .cache(cache)
                .addNetworkInterceptor(StethoInterceptor())
        return client.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val gsonBuilder = GsonBuilder()
        return Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory((GsonConverterFactory.create(gsonBuilder.create())))
                .client(okHttpClient)
                .build()
    }


    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
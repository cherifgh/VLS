package com.jcdecaux.gcif.vls.di

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jcdecaux.gcif.vls.BuildConfig
import com.jcdecaux.gcif.vls.R
import com.jcdecaux.gcif.vls.data.remote.ApiInterceptor
import com.jcdecaux.gcif.vls.data.remote.ContractApi
import com.jcdecaux.gcif.vls.data.remote.StationApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author cherif
 * @since 03/11/17.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(ApiInterceptor())
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    @Provides
    @Singleton
    fun retrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun stationApi(retrofit: Retrofit): StationApi {
        return retrofit.create(StationApi::class.java)
    }

    @Provides
    @Singleton
    fun contractApi(retrofit: Retrofit): ContractApi {
        return retrofit.create(ContractApi::class.java)
    }
}
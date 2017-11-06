package com.jcdecaux.gcif.vls

import android.app.Activity
import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.jcdecaux.gcif.vls.di.ApiModule
import com.jcdecaux.gcif.vls.di.AppComponent
import com.jcdecaux.gcif.vls.di.AppModule
import com.jcdecaux.gcif.vls.di.DaggerAppComponent

/**
 * @author cherif
 * @since 03/11/17.
 */
class VLSApplication : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
    }
}

fun Activity.app() = application.app()
fun Application.app() = this as VLSApplication
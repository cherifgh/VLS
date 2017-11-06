package com.jcdecaux.gcif.vls.di

import android.content.Context
import com.jcdecaux.gcif.vls.AppBehavior
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author cherif
 * @since 03/11/17.
 */
@Module
class AppModule(
        private val context: Context
) {
    @Provides
    @Singleton
    fun context() = context

    @Provides
    @Singleton
    fun behavior() = AppBehavior()
}
package com.jcdecaux.gcif.vls.di

import com.jcdecaux.gcif.vls.app.main.MainActivity
import com.jcdecaux.gcif.vls.app.contract.ContractActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author cherif
 * @since 03/11/17.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class))
interface AppComponent {
    fun inject(injected: MainActivity)

    fun inject(injected: ContractActivity)
}
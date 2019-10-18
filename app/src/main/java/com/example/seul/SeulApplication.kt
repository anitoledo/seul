package com.example.seul

import com.example.seul.di.component.DaggerSeulComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class SeulApplication : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerSeulComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        startLogger()
    }

    private fun startLogger(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }

}

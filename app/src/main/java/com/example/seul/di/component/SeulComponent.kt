package com.example.seul.di.component

import android.app.Application
import com.example.seul.SeulApplication
import com.example.seul.di.modules.ActivityModule
import com.example.seul.di.modules.RetrofitModule
import com.example.seul.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        RetrofitModule::class
    ]
)
interface SeulComponent : AndroidInjector<SeulApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): SeulComponent
    }

}

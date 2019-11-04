package com.example.seul.di.modules

import com.example.seul.views.CreateRestaurantActivity
import com.example.seul.views.LoginActivity
import com.example.seul.views.MainActivity
import com.example.seul.views.RestaurantDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeCreateRestaurantActivity(): CreateRestaurantActivity

    @ContributesAndroidInjector
    abstract fun contributeRestaurantDetailActivity(): RestaurantDetailActivity
}

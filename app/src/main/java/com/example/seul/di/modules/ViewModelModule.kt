package com.example.seul.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.seul.di.ViewModelFactory
import com.example.seul.di.annotations.ViewModelKey
import com.example.seul.viewmodels.CreateRestaurantViewModel
import com.example.seul.viewmodels.MainViewModel
import com.example.seul.viewmodels.RestaurantDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateRestaurantViewModel::class)
    abstract fun bindCreateRestaurantViewModel(createRestaurantViewModel: CreateRestaurantViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantDetailViewModel::class)
    abstract fun bindRestaurantDetailViewModel(restaurantDetailViewModel: RestaurantDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

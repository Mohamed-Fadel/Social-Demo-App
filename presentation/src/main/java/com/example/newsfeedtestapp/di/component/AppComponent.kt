package com.example.newsfeedtestapp.di.component

import com.example.newsfeedtestapp.MainApplication
import com.example.newsfeedtestapp.di.module.ActivityBindingModule
import com.example.newsfeedtestapp.di.module.AppModule
import com.example.newsfeedtestapp.di.module.NetworkModule
import com.example.newsfeedtestapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Mohamed Fadel
 * Date: 10/27/2019.
 * email: mohamedfadel91@gmail.com.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MainApplication): AppComponent
    }
}
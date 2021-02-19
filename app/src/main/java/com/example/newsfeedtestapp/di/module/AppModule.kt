package com.example.newsfeedtestapp.di.module

import android.content.Context
import com.example.newsfeedtestapp.MainApplication
import dagger.Module
import dagger.Provides

/**
 * Created by Mohamed Fadel
 * Date: 10/27/2019.
 * email: mohamedfadel91@gmail.com.
 */
@Module
class AppModule {
    @Provides
    fun provideContext(application: MainApplication): Context {
        return application.applicationContext
    }
}
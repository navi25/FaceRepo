package io.navendra.facerepo.dagger

import android.app.Application
import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app : Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app
}


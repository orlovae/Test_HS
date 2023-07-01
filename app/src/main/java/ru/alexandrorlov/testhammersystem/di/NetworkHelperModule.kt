package ru.alexandrorlov.testhammersystem.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.alexandrorlov.testhammersystem.util.NetworkHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkHelperModule {

    @Provides
    @Singleton
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)

}
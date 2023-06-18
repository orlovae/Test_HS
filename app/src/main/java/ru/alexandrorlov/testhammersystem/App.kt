package ru.alexandrorlov.testhammersystem

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.alexandrorlov.testhammersystem.base.ReleaseTree
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogging()
    }

    private fun initLogging() {
        Timber.plant(if (BuildConfig.DEBUG) Timber.DebugTree() else ReleaseTree)
    }
}
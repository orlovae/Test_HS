package ru.alexandrorlov.testhammersystem

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.alexandrorlov.testhammersystem.base.ReleaseTree
import ru.alexandrorlov.testhammersystem.ui.model.ui.FoodCategory
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

    companion object {
        val cityList = listOf(
            "Москва",
            "Санкт-Петербург",
            "Тверь",
            "Краснодар",
            "Екатеринбург",
            "Томск",
            "Красноярск",
            "Владивосток",
        )

        val foodCategory = listOf(
            FoodCategory("Пицца"),
            FoodCategory("Комбо"),
            FoodCategory("Десерты"),
            FoodCategory("Напитки"),
            FoodCategory("Соусы"),
            FoodCategory("Десерты"),
        )

        val bannerList = listOf(
            R.drawable.rectangle_38,
            R.drawable.rectangle_38,
        )
    }
}
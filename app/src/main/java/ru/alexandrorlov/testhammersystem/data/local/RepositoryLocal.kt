package ru.alexandrorlov.testhammersystem.data.local

import ru.alexandrorlov.testhammersystem.base.fromApiToListMealEntity
import ru.alexandrorlov.testhammersystem.base.toMealEntity
import ru.alexandrorlov.testhammersystem.ui.model.Meal
import ru.alexandrorlov.testhammersystem.ui.model.MealEntity
import javax.inject.Inject

class RepositoryLocal @Inject constructor(
    private val dataBase: LocalDataBase
) {
    suspend fun getAllMealEntity(): List<MealEntity> {
        return dataBase.MealDao().getAll()
    }

    suspend fun insertAllMealApi(mealApi: List<Meal>) {
        dataBase.MealDao().insertAll(
            mealApi.fromApiToListMealEntity()
        )
    }

    suspend fun updateMeal(meal: Meal) {
        dataBase.MealDao().update(
            meal.toMealEntity()
        )
    }

    suspend fun deleteAll() {
        dataBase.MealDao().deleteAll()
    }
}
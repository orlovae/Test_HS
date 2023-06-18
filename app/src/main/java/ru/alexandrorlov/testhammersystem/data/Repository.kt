package ru.alexandrorlov.testhammersystem.data

import ru.alexandrorlov.testhammersystem.base.Result
import ru.alexandrorlov.testhammersystem.base.toEntityMeal
import ru.alexandrorlov.testhammersystem.data.remote.DataSource
import ru.alexandrorlov.testhammersystem.ui.model.EntityMeal
import ru.alexandrorlov.testhammersystem.ui.model.Meals
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val remote: DataSource
) {

    //Получение из базы данных
    suspend fun getMeals(): Result<Any> {
        val apiMealList = mutableListOf<EntityMeal>()
        repeat(10) {
            val result = remote.getResultFromNetwork()
            if (result is Result.Success) {
                apiMealList.add(
                    (result.data as Meals).toEntityMeal()
                )
            } else {
                return result
            }
        }
        return Result.Success(apiMealList)

    }

    suspend fun fetchMeals() {
        val mealApi = remote.getResultFromNetwork()
        //удаляем из БД все данные
        //вставляем в БД новые данные
    }
}
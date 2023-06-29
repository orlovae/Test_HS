package ru.alexandrorlov.testhammersystem.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.alexandrorlov.testhammersystem.config.DataLocal
import ru.alexandrorlov.testhammersystem.ui.model.MealEntity

@Dao
interface MealDao {

    @Query("SELECT * FROM ${DataLocal.Meal.TABLE_NAME}")
    suspend fun getAll(): List<MealEntity>

    @Update
    suspend fun update(mealEntity: MealEntity)

    @Insert
    suspend fun insertAll(mealEntityList: List<MealEntity>  )

    @Query("DELETE FROM ${DataLocal.Meal.TABLE_NAME}")
    suspend fun deleteAll()
}
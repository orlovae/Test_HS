package ru.alexandrorlov.testhammersystem.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.alexandrorlov.testhammersystem.config.DataLocalConfig

@Entity(tableName = DataLocalConfig.Meal.TABLE_NAME)
data class MealEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_ID)
    val id: Int,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_TITLE)
    val title: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_DRINK_ALTERNATIVE)
    val drinkAlternate: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_CATEGORY)
    val category: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_AREA)
    val area: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_DESCRIPTION)
    val description: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_URL_THUMB)
    val urlThumb: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_TAGS)
    val tags: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_URL_YOUTUBE)
    val urlYoutube: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT1)
    val ingredient1: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT2)
    val ingredient2: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT3)
    val ingredient3: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT4)
    val ingredient4: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT5)
    val ingredient5: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT6)
    val ingredient6: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT7)
    val ingredient7: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT8)
    val ingredient8: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT9)
    val ingredient9: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT10)
    val ingredient10: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT11)
    val ingredient11: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT12)
    val ingredient12: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT13)
    val ingredient13: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT14)
    val ingredient14: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT15)
    val ingredient15: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT16)
    val ingredient16: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT17)
    val ingredient17: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT18)
    val ingredient18: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT19)
    val ingredient19: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_INGREDIENT20)
    val ingredient20: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE1)
    val measure1: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE2)
    val measure2: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE3)
    val measure3: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE4)
    val measure4: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE5)
    val measure5: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE6)
    val measure6: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE7)
    val measure7: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE8)
    val measure8: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE9)
    val measure9: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE10)
    val measure10: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE11)
    val measure11: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE12)
    val measure12: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE13)
    val measure13: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE14)
    val measure14: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE15)
    val measure15: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE16)
    val measure16: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE17)
    val measure17: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE18)
    val measure18: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE19)
    val measure19: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_MEASURE20)
    val measure20: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_SOURCE)
    val source: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_IMAGE_SOURCE)
    val imageSource: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_CREATIVE_COMMONS_CONFIRMED)
    val creativeCommonsConfirmed: String,
    @ColumnInfo(name = DataLocalConfig.Meal.COLUMN_DATE_MODIFIED)
    val dateModified: String,
)

package ru.alexandrorlov.testhammersystem.ui.main.state

import androidx.annotation.StringRes
import ru.alexandrorlov.testhammersystem.base.UiState
import ru.alexandrorlov.testhammersystem.ui.model.EntityMeal

sealed class MealState : UiState {
    object Loading : MealState()

    data class Data(val mealList: List<EntityMeal>? = null) : MealState()

    val data: Data?
        get() = this as? Data

    data class Error(@StringRes val idMessage: Int) : MealState()
}

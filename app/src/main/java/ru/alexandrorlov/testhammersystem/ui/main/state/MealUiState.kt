package ru.alexandrorlov.testhammersystem.ui.main.state

import ru.alexandrorlov.testhammersystem.base.UiState

data class MealUiState(
    val mealState: MealState = MealState.Loading
) : UiState
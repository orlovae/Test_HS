package ru.alexandrorlov.testhammersystem.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.ui.components.state.StateEmpty
import ru.alexandrorlov.testhammersystem.ui.main.state.MealUiState

@Composable
fun StateData(
    uiState: MealUiState
) {
    val mealUiList = (uiState.mealState.data)?.mealList

    if (mealUiList?.isNotEmpty() == true) {
        StateNotEmpty(
            mealUiList = mealUiList
        )
    } else {
        StateEmpty(message = stringResource(id = R.string.exception_Exception))
    }
}
package ru.alexandrorlov.testhammersystem.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import ru.alexandrorlov.testhammersystem.ui.components.StateData
import ru.alexandrorlov.testhammersystem.ui.components.state.StateError
import ru.alexandrorlov.testhammersystem.ui.components.state.StateLoading
import ru.alexandrorlov.testhammersystem.ui.main.state.MealState

@Composable
fun MenuScreen(
    viewModel: ViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState.mealState) {
        is MealState.Loading -> {
            StateLoading()
        }
        is MealState.Data -> {
            StateData(
                uiState = uiState
            )
        }
        is MealState.Error -> {
            val message = uiState.mealState as MealState.Error
            StateError(message = stringResource(id = message.idMessage))
        }
    }
}
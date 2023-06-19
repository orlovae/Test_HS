package ru.alexandrorlov.testhammersystem.ui.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.base.BaseViewModel
import ru.alexandrorlov.testhammersystem.base.Result
import ru.alexandrorlov.testhammersystem.ui.main.state.MealState
import ru.alexandrorlov.testhammersystem.ui.main.state.MealUiState
import ru.alexandrorlov.testhammersystem.ui.model.MealUi
import ru.alexandrorlov.testhammersystem.use_case.UseCase
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val useCase: UseCase
) :
    BaseViewModel<MealUiState>(MealUiState(MealState.Loading)) {

    private val _uiState = MutableStateFlow(MealUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchMeal()
    }

    private fun fetchMeal() {
        viewModelScope.launch {
            try {
                val result = useCase.execute()
                if (result is Result.Success) {
                    _uiState.update {
                        it.copy(
                            mealState = MealState.Data(result.data as List<MealUi>)
                        )
                    }
                }
                if (result is Result.Error) {
                    _uiState.update {
                        it.copy(
                            mealState = MealState.Error(result.idMessage)
                        )
                    }
                }
            } catch (exception: Exception) {
                errorHandling(exception)
            }
        }
    }

    private fun errorHandling(exception: Exception) {
        val idMessage = when (exception) {
            is UnknownHostException ->
                R.string.exception_unknownHostException
            else ->
                R.string.exception_Exception
        }
        _uiState.update {
            it.copy(
                mealState = MealState.Error(idMessage)
            )
        }
    }
}
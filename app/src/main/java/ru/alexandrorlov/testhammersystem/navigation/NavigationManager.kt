package ru.alexandrorlov.testhammersystem.navigation

import androidx.navigation.NamedNavArgument
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

internal class NavigationManager @Inject constructor() {
    private val _sharedFlow =
        MutableSharedFlow<UiNavCommand>(extraBufferCapacity = 1)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(uiNavCommand: UiNavCommand) {
        _sharedFlow.tryEmit(uiNavCommand)
    }

    fun navigateBack() {
        _sharedFlow.tryEmit(object : UiNavCommand {
            override val arguments: List<NamedNavArgument> = listOf()
            override val destination: String = "OnBack"
        })
    }
}
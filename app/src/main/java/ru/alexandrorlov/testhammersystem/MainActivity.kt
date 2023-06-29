package ru.alexandrorlov.testhammersystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.debounce
import ru.alexandrorlov.testhammersystem.navigation.NavigationManager
import ru.alexandrorlov.testhammersystem.ui.main.MainScreen
import ru.alexandrorlov.testhammersystem.ui.theme.HSTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    internal lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            LaunchedEffect(key1 = Unit) {
                navigationManager.sharedFlow.debounce { 100L }.collect {
                    if (it.destination == "OnBack") {
                        navController.popBackStack()
                    } else {
                        navController.navigate(it.destination)
                    }
                }
            }

            HSTheme {
                Scaffold() { paddingValues ->
                    MainScreen(
                        navController = navController,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }
}
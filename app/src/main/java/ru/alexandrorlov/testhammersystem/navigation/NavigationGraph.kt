package ru.alexandrorlov.testhammersystem.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.alexandrorlov.testhammersystem.ui.components.bottom_bar.BottomNavItem
import ru.alexandrorlov.testhammersystem.ui.main.MenuScreen
import ru.alexandrorlov.testhammersystem.ui.main.fake_screen.FakeScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Menu.screenRoot
    ) {
        composable(
            route = BottomNavItem.Menu.screenRoot,
        ) {
            MenuScreen(
                viewModel = hiltViewModel()
            )
        }
        composable(
            route = BottomNavItem.Profile.screenRoot,
        ) {
            FakeScreen(
                screenTitleId = BottomNavItem.Profile.titleId
            )
        }
        composable(
            route = BottomNavItem.Basket.screenRoot,
        ) {
            FakeScreen(
                screenTitleId = BottomNavItem.Basket.titleId
            )
        }
    }
}
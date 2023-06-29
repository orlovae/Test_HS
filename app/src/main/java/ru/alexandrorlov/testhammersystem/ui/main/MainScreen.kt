package ru.alexandrorlov.testhammersystem.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.alexandrorlov.testhammersystem.App
import ru.alexandrorlov.testhammersystem.navigation.NavigationGraph
import ru.alexandrorlov.testhammersystem.ui.components.bottom_bar.BottomNavItem
import ru.alexandrorlov.testhammersystem.ui.components.bottom_bar.BottomNavigationBar
import ru.alexandrorlov.testhammersystem.ui.components.chip.ChipList
import ru.alexandrorlov.testhammersystem.ui.components.top_bar.CustomToolbar
import ru.alexandrorlov.testhammersystem.ui.components.top_bar.TopRowToolBar
import ru.alexandrorlov.testhammersystem.ui.components.top_bar.model.CollapsingBannerContent
import ru.alexandrorlov.testhammersystem.ui.components.top_bar.rememberToolbarScrollBehavior

@Composable
fun MainScreen(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val scrollBehavior = rememberToolbarScrollBehavior()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomToolbar(
                collapsingBannerContent = CollapsingBannerContent(
                    bannerList = App.bannerList
                ),
                topRowToolBar = {
                    TopRowToolBar(
                        cityList = App.cityList
                    )
                },
                chipContent = {
                    ChipList(
                        foodCategoryList = App.foodCategory,
                        onSelected = {}
                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomBar(
                navBackStackEntry = navBackStackEntry,
                navController = navController
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            NavigationGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(
    navBackStackEntry: NavBackStackEntry?,
    navController: NavHostController
) {
    navBackStackEntry?.destination?.route
    if (navBackStackEntry?.destination?.route == BottomNavItem.Menu.screenRoot
        || navBackStackEntry?.destination?.route == BottomNavItem.Profile.screenRoot
        || navBackStackEntry?.destination?.route == BottomNavItem.Basket.screenRoot
    ) {
        BottomNavigationBar(navController = navController)
    }
}
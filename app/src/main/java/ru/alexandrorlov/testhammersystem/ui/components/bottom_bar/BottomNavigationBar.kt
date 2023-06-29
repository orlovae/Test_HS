package ru.alexandrorlov.testhammersystem.ui.components.bottom_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography
import ru.alexandrorlov.testhammersystem.ui.theme.backgroundBottomBar
import ru.alexandrorlov.testhammersystem.ui.theme.selectedContentColor
import ru.alexandrorlov.testhammersystem.ui.theme.unSelectedContentColor
import timber.log.Timber

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Menu,
        BottomNavItem.Profile,
        BottomNavItem.Basket
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = backgroundBottomBar,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
                NavigationBarItem(
                    modifier = Modifier,
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = stringResource(id = item.titleId)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = item.titleId),
                            style = HSTypography.labelLarge,
                        )
                    },
                    selected = currentRoute == item.screenRoot,
                    onClick = {
                        navController.navigate(item.screenRoot) {
                            navController.graph.startDestinationRoute?.let { screenRoot ->
                                popUpTo(screenRoot) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        Timber.tag("OAE").d("OnClick in BottomBar")
                    },
                    colors = NavigationBarItemDefaults
                        .colors(
                            selectedIconColor = selectedContentColor,
                            unselectedIconColor = unSelectedContentColor,
                            selectedTextColor = selectedContentColor,
                            unselectedTextColor = unSelectedContentColor,
                            indicatorColor = backgroundBottomBar
                        ),
                    alwaysShowLabel = true
                )
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        0.0f, 0.0f, 0.0f, 0.0f)
}
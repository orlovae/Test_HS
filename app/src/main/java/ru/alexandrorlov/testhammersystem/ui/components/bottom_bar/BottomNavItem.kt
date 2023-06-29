package ru.alexandrorlov.testhammersystem.ui.components.bottom_bar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.config.UI.MENU
import ru.alexandrorlov.testhammersystem.config.UI.PROFILE
import ru.alexandrorlov.testhammersystem.config.UI.BASKET

sealed class BottomNavItem(
    val screenRoot: String,
    @DrawableRes val icon: Int,
    @StringRes val titleId: Int
) {
    object Menu : BottomNavItem(
        screenRoot = MENU,
        icon = R.drawable.baseline_fastfood_24,
        titleId = R.string.bottom_menu_menu
    )

    object Profile : BottomNavItem(
        screenRoot = PROFILE,
        icon = R.drawable.baseline_person_24,
        titleId = R.string.bottom_menu_profile
    )

    object Basket : BottomNavItem(
        screenRoot = BASKET,
        icon = R.drawable.baseline_shopping_basket_24,
        titleId = R.string.bottom_menu_basket
    )
}

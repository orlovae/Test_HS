package ru.alexandrorlov.testhammersystem.ui.components.main_screen.card_item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.testhammersystem.ui.model.ui.MealUi

@Composable
fun AllItem(
    mealUiFirst: MealUi,
    mealUiSecond: MealUi?
) {
    Row {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            CardItem(mealUi = mealUiFirst)
        }
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            mealUiSecond?.let {
                CardItem(mealUi = mealUiSecond)
            }
        }
    }
}
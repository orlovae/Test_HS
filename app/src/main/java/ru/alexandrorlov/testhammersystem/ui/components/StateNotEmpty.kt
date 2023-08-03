package ru.alexandrorlov.testhammersystem.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import ru.alexandrorlov.testhammersystem.ui.components.main_screen.card_item.AllItem
import ru.alexandrorlov.testhammersystem.ui.components.main_screen.card_item.FirstItem
import ru.alexandrorlov.testhammersystem.ui.model.ui.MealUi

@Composable
fun StateNotEmpty(
    mealUiList: List<MealUi>
) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        item {
            FirstItem(mealUi = mealUiList.first())
        }
        val listWithoutFirst = mealUiList.drop(1)

        itemsIndexed(listWithoutFirst) { index, _ ->
            AllItem(
                mealUiFirst = listWithoutFirst[index],
                mealUiSecond = if (index < listWithoutFirst.lastIndex) {
                    listWithoutFirst[index + 1]
                } else {
                    null
                }
            )
        }
    }
}
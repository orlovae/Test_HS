package ru.alexandrorlov.testhammersystem.ui.components.chip

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.testhammersystem.ui.model.ui.FoodCategory
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal

@Composable
fun ChipList(
    foodCategoryList: List<FoodCategory>,
    onSelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .padding(
                start = padding_normal
            )
    ) {
        items(foodCategoryList) { foodCategory ->
            Chip(
                food = foodCategory.food,
                onSelected = { onSelected(foodCategory.food) }
            )
        }
    }
}
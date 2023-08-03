package ru.alexandrorlov.testhammersystem.ui.components.main_screen.card_item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import ru.alexandrorlov.testhammersystem.ui.components.main_screen.DescriptionFood
import ru.alexandrorlov.testhammersystem.ui.model.ui.MealUi
import ru.alexandrorlov.testhammersystem.ui.theme.padding_medium
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal

@Composable
fun FirstItem(
    mealUi: MealUi
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
        ) {
            SubcomposeAsyncImage(
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxWidth(0.43f)
                    .padding(
                        start = padding_normal,
                        end = padding_medium,
                        top = padding_normal,
                        bottom = padding_normal
                    ),
                alignment = Alignment.Center,
                model = mealUi.urlThumb,
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier.size(10.dp),
                        strokeWidth = 4.dp
                    )
                },
                contentDescription = null,
            )
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.TopStart
            ) {
                DescriptionFood(
                    title = mealUi.title ?: "",
                    description = mealUi.description ?: "",
                    maxLine = 4,
                    price = 345
                )
            }
        }
    }
}
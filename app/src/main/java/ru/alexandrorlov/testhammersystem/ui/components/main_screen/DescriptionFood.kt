package ru.alexandrorlov.testhammersystem.ui.components.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography
import ru.alexandrorlov.testhammersystem.ui.theme.padding_medium
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal

@Composable
fun DescriptionFood(
    title: String,
    description: String,
    maxLine: Int,
    price: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = padding_normal,
                end = padding_medium,
                top = padding_normal,
                bottom = padding_normal
            ),
    ) {
        Text(
            text = title,
            style = HSTypography.titleLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(
                    bottom = padding_medium
                )
        )
        Text(
            text = description,
            style = HSTypography.bodyMedium,
            maxLines = maxLine,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(
                    bottom = padding_medium
                )
        )
        Price(
            price = price
        )
    }
}
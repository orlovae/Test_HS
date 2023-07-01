package ru.alexandrorlov.testhammersystem.ui.components.top_bar.spinner

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography
import ru.alexandrorlov.testhammersystem.ui.theme.padding_small
import ru.alexandrorlov.testhammersystem.ui.theme.selectedContentColor

@Composable
fun MenuItem(
    onClick: (Boolean, String) -> Unit,
    isSelected: Boolean,
    cityItem: String
) {
    DropdownMenuItem(
        onClick = {
            onClick(false, cityItem)
        },
        text = {
            val style = if (isSelected) {
                HSTypography.titleMedium.copy(
                    color = selectedContentColor
                )
            } else {
                HSTypography.titleMedium
            }
            Text(
                text = cityItem,
                style = style,
                modifier = Modifier
                    .padding(padding_small)
            )
        }
    )
}
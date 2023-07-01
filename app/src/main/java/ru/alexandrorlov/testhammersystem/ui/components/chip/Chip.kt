package ru.alexandrorlov.testhammersystem.ui.components.chip

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.testhammersystem.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    food: String,
    onSelected: (Boolean) -> Unit
) {
    var selected by rememberSaveable() {
        mutableStateOf(false)
    }

    FilterChip(
        selected = selected,
        onClick = {
            selected = !selected
            onSelected(selected)
        },
        enabled = true,
        modifier = Modifier
            .padding(
                end = padding_medium
            ),
        shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 30)),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            disabledContainerColor = MaterialTheme.colorScheme.onTertiary,
            selectedContainerColor = selectedContentColor.copy(0.2f),
            disabledSelectedContainerColor = unSelectedContentColor,
        ),
        border = InputChipDefaults.inputChipBorder(
            borderColor = Color.Transparent,
            selectedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            disabledSelectedBorderColor = Color.Transparent
        ),
        elevation = FilterChipDefaults.elevatedFilterChipElevation(
            elevation = 20.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,

            ),
        label = {
            val style = if (selected) {
                HSTypography.labelMedium
            } else {
                HSTypography.labelSmall
            }
            Text(
                text = food,
                style = style
            )
        }
    )
}
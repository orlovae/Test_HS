package ru.alexandrorlov.testhammersystem.ui.components.main_screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal
import ru.alexandrorlov.testhammersystem.ui.theme.selectedContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Price(
    price: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 25)),
            border = BorderStroke(
                width = 1.dp,
                color = selectedContentColor,
            ),
        ) {
            Row(
                modifier = Modifier
                    .defaultMinSize(
                        minHeight = FilterChipDefaults.Height,
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = CenterVertically,
            ) {
                Spacer(
                    modifier = Modifier
                        .width(padding_normal)
                )
                Text(
                    text = "${stringResource(id = R.string.menu_menu_price_from)} " +
                            "$price " +
                            stringResource(id = R.string.menu_menu_price_rub),
                    style = HSTypography.bodySmall,
                )
                Spacer(
                    modifier = Modifier
                        .width(padding_normal)
                )
            }
        }
    }
}
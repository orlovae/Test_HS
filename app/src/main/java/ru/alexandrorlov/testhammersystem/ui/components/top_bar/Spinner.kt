package ru.alexandrorlov.testhammersystem.ui.components.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.testhammersystem.R
import ru.alexandrorlov.testhammersystem.config.UI
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal
import ru.alexandrorlov.testhammersystem.ui.theme.selectedContentColor
import timber.log.Timber

@Composable
fun Spinner(
    cityList: List<String>,
) {
    var cityName: String by remember {
        mutableStateOf(
            cityList.first {
                it == UI.CITY_DEFAULT
            }
        )
    }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .clickable { expanded = !expanded }
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .padding(start = padding_normal),
            text = cityName,
            style = HSTypography.titleMedium
        )
        IconButton(
            onClick = { expanded = true },
        ) {
            Icon(
                painterResource(id = R.drawable.baseline_expand_more_24),
                contentDescription = stringResource(R.string.top_bar_select_country)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            cityList.forEach { city ->
                DropdownMenuItem(
                    modifier = Modifier
                        .pointerInput(Unit) {
                            awaitEachGesture {
                                while (true) {
                                    val event = awaitPointerEvent()
                                    Timber.tag("OAE")
                                        .d("event = ${event.changes.firstOrNull()?.isConsumed}")
                                }
                            }
                        },
                    onClick = {
                        expanded = false
                        cityName = city
                    },
                    text = {
                        val isSelected = city == cityName
                        val style = if (isSelected) {
                            HSTypography.titleMedium.copy(
                                color = selectedContentColor
                            )
                        } else {
                            HSTypography.titleMedium
                        }
                        Text(
                            text = city,
                            style = style,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                )
            }
        }
    }
}
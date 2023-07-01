package ru.alexandrorlov.testhammersystem.ui.components.top_bar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.alexandrorlov.testhammersystem.ui.components.top_bar.spinner.Spinner

@Composable
fun TopRowToolBar(
    cityList: List<String>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spinner(
            cityList = cityList
        )

        Spacer(
            modifier = Modifier.weight(1f, true)
        )

        QrCode()
    }
}
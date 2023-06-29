package ru.alexandrorlov.testhammersystem.ui.components.top_bar

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import timber.log.Timber

@Composable
fun TopRowToolBar(
    cityList: List<String>
) {
    Row(
        modifier = Modifier.pointerInput(Unit){
            awaitEachGesture {
                while (true) {
                    val event = awaitPointerEvent()
                    Timber.tag("OAE").d("event TopRowToolBar = ${event.changes.firstOrNull()?.isConsumed}")
                }
            }
        },
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
package ru.alexandrorlov.testhammersystem.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import timber.log.Timber

@Composable
//fun BannerList(
//    switchClick: Boolean,
//    content: List<Int>
//) {
//    LazyRow(
//        horizontalArrangement = Arrangement.spacedBy(padding_normal.unaryMinus())
//    ) {
//        items(content) { idBanner ->
//            Image(
//                modifier = Modifier
////                    .apply {
////                        if (switchClick) this.then(clickable {
//////                            Timber.tag("OAE").d("onClick in BannerList")
////                        })
////                    }
//                    .height(112.dp)
//                    .width(300.dp)
//                    .pointerInput(Unit) {
//                        awaitEachGesture {
//                            while (true) {
//                                val event = awaitPointerEvent()
//                                Timber
//                                    .tag("OAE")
//                                    .d("event BannerList = ${event.changes.firstOrNull()?.isConsumed}")
//                            }
//                        }
//                    },
//                painter = painterResource(id = idBanner),
//                contentScale = ContentScale.FillWidth,
//                contentDescription = null
//            )
//        }
//    }
//}

fun BannerList(
    switchClick: Boolean,
    content: List<Int>
) {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .height(112.dp)
            .width(300.dp)
            .pointerInput(Unit) {
                awaitEachGesture {
                    while (true) {
                        val event = awaitPointerEvent()
                        Timber
                            .tag("OAE")
                            .d("event BannerList = ${event.changes.firstOrNull()?.isConsumed}")
                    }
                }
            },
    )
}
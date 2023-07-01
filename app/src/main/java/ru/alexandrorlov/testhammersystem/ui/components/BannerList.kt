package ru.alexandrorlov.testhammersystem.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal

@Composable
fun BannerList(
    content: List<Int>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(padding_normal.unaryMinus())
    ) {
        items(content) { idBanner ->
            Image(
                modifier = Modifier
                    .height(112.dp)
                    .width(300.dp),
                painter = painterResource(id = idBanner),
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )
        }
    }
}
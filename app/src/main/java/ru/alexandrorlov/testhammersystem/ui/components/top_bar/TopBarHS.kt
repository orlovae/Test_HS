package ru.alexandrorlov.testhammersystem.ui.components.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.testhammersystem.App
import ru.alexandrorlov.testhammersystem.ui.components.BannerList
import ru.alexandrorlov.testhammersystem.ui.components.chip.ChipList

@Composable
fun TopBarHS(

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopRowToolBar(
            cityList = App.cityList
        )
        BannerList(
            switchClick = false,
            content = App.bannerList
        )
        ChipList(
            foodCategoryList = App.foodCategory,
            onSelected = {}
        )
    }
}
package ru.alexandrorlov.testhammersystem.ui.components.top_bar


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.testhammersystem.config.UI.BANNER_CONTENT_ID
import ru.alexandrorlov.testhammersystem.config.UI.CHIPS_CONTENT_ID
import ru.alexandrorlov.testhammersystem.config.UI.TOP_ROW_CONTENT_ID
import ru.alexandrorlov.testhammersystem.ui.components.BannerList
import ru.alexandrorlov.testhammersystem.ui.components.top_bar.model.CollapsingBannerContent
import kotlin.math.roundToInt

@Composable
fun CustomToolbar(
    modifier: Modifier = Modifier,
    collapsingBannerContent: CollapsingBannerContent? = null,
    topRowToolBar: (@Composable () -> Unit)? = null,
    chipContent: (@Composable () -> Unit)? = null,
    scrollBehavior: CustomToolbarScrollBehavior? = null,
) {
    val collapsedFraction = when {
        scrollBehavior != null -> scrollBehavior.state.collapsedFraction
        else -> 1f
    }

    Layout(
        modifier = modifier.then(Modifier.heightIn(min = MinCollapsedHeight)),
        content = {
            if (collapsingBannerContent != null) {
                Box(
                    modifier = Modifier
                        .layoutId(BANNER_CONTENT_ID)
                ) {
                    BannerList(
                        content = collapsingBannerContent.bannerList
                    )
                }
            }

            if (topRowToolBar != null) {
                Box(
                    modifier = Modifier
                        .layoutId(TOP_ROW_CONTENT_ID)
                ) {
                    topRowToolBar()
                }
            }

            if (chipContent != null) {
                Box(
                    modifier = Modifier
                        .layoutId(CHIPS_CONTENT_ID)
                ) {
                    chipContent()
                }
            }
        },
        measurePolicy = { measurables, constraints ->
            val horizontalPadding = HorizontalPadding.toPx().roundToInt()
            val verticalPadding = VerticalPadding.toPx().roundToInt()
            val expandedBannerContentBottomPaddingPx = ExpandedBannerContentBottomPadding.toPx()
            val minCollapsedHeightPx = MinCollapsedHeight.toPx()

            //measure child component
            val topRowToolBarPlaceable =
                measurables.firstOrNull { it.layoutId == TOP_ROW_CONTENT_ID }
                    ?.measure(constraints)

            val bannerContentPlaceable =
                measurables.firstOrNull { it.layoutId == BANNER_CONTENT_ID }
                    ?.measure(constraints)

            val chipContentPlaceable =
                measurables.firstOrNull { it.layoutId == CHIPS_CONTENT_ID }
                    ?.measure(constraints)

            val heightOffsetLimitPx =
                (bannerContentPlaceable?.height ?: 0) + expandedBannerContentBottomPaddingPx
            scrollBehavior?.state?.heightOffsetLimit = heightOffsetLimitPx.unaryMinus()

            val fullyExpandedHeightPx = minCollapsedHeightPx + heightOffsetLimitPx

            //get coordinate child component

            val fullyExpandedBannerContentY =
                fullyExpandedHeightPx - (bannerContentPlaceable?.height
                    ?: 0) - expandedBannerContentBottomPaddingPx
            val fullyCollapsingBannerContentY = 0f

            layout(
                width = constraints.maxWidth,
                height = getToolbarHeightPx(
                    bannerContentHeight = bannerContentPlaceable?.height ?: 0,
                    expandedBannerContentBottomPaddingPx = expandedBannerContentBottomPaddingPx,
                    minCollapsedHeightPx = minCollapsedHeightPx,
                    collapsedFraction = collapsedFraction,
                    chipContentHeight = chipContentPlaceable?.height ?: 0
                )
            ) {
                topRowToolBarPlaceable?.placeRelative(
                    x = horizontalPadding,
                    y = verticalPadding
                )

                bannerContentPlaceable?.placeRelativeWithLayer(
                    x = horizontalPadding,
                    y = lerp(
                        fullyExpandedBannerContentY,
                        fullyCollapsingBannerContentY,
                        collapsedFraction
                    ).roundToInt(),
                    layerBlock = {
                        alpha = 1 - collapsedFraction
                        translationY = (topRowToolBarPlaceable?.height ?: 0) * collapsedFraction
                        if (collapsedFraction == 1f) {
                            scaleY = 0f
                        }
                    }
                )

                chipContentPlaceable?.placeRelative(
                    x = horizontalPadding,
                    y = lerp(
                        fullyExpandedHeightPx,
                        minCollapsedHeightPx,
                        collapsedFraction
                    ).roundToInt()
                )
            }
        }
    )
}

private fun lerp(a: Float, b: Float, fraction: Float): Float {
    return a + fraction * (b - a)
}


private fun getToolbarHeightPx(
    bannerContentHeight: Int,
    expandedBannerContentBottomPaddingPx: Float,
    minCollapsedHeightPx: Float,
    collapsedFraction: Float,
    chipContentHeight: Int,
): Int {
    val heightOffsetLimitPx =
        bannerContentHeight + expandedBannerContentBottomPaddingPx

    val fullyExpandedHeightPx = minCollapsedHeightPx + heightOffsetLimitPx

    val layoutHeightPx =
        lerp(
            fullyExpandedHeightPx,
            minCollapsedHeightPx,
            collapsedFraction
        )
    return layoutHeightPx.roundToInt() + chipContentHeight
}

private
val HorizontalPadding = 0.dp

private
val VerticalPadding = 16.dp

private
val MinCollapsedHeight = 56.dp

private
val ExpandedBannerContentBottomPadding = 8.dp
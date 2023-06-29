package ru.alexandrorlov.testhammersystem.ui.components.top_bar


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.testhammersystem.config.UI.CHIPS_CONTENT_ID
import ru.alexandrorlov.testhammersystem.config.UI.EXPANDED_BANNER_CONTENT_ID
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

    val fullyCollapsingBannerContentScale = when {
        collapsingBannerContent != null -> 0f
        else -> 1f
    }

    val collapsingBannerContentScale =
        lerp(1f, fullyCollapsingBannerContentScale, collapsedFraction)

//    Timber.tag("OAE").d("collapsingBannerContentScale = $collapsingBannerContentScale")

//    Surface(
//        modifier = modifier
//    ) {
    Layout(
        content = {
            if (collapsingBannerContent != null) {
                Box(
                    modifier = Modifier
//                            .zIndex(0f)
                        .layoutId(EXPANDED_BANNER_CONTENT_ID)
                        .graphicsLayer(
//                                scaleX = collapsingBannerContentScale,
//                                scaleY = collapsingBannerContentScale,
//                                transformOrigin = TransformOrigin(0.5f, 0.5f)
                            translationY = collapsingBannerContentScale
                        )
                ) {
                    BannerList(
                        switchClick = collapsingBannerContentScale <= 0.2f,
                        content = collapsingBannerContent.bannerList
                    )
                }
            }

            if (topRowToolBar != null) {
                Box(
                    modifier = Modifier
//                            .zIndex(
//                                if (collapsingBannerContentScale == 0f) {
//                                    1f
//                                } else {
//                                    0f
//                                }
//                            )
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
        modifier = modifier.then(Modifier.heightIn(min = MinCollapsedHeight)),
        measurePolicy = { measurables, constraints ->
            val horizontalPaddingPx = HorizontalPadding.toPx()
            val verticalPaddingPx = VerticalPadding.toPx()
            val expandedBannerContentBottomPaddingPx = ExpandedBannerContentBottomPadding.toPx()

            val topRowToolBarPlaceable =
                measurables.firstOrNull { it.layoutId == TOP_ROW_CONTENT_ID }
                    ?.measure(constraints)

            val expandedBannerContentPlaceable =
                measurables.firstOrNull { it.layoutId == EXPANDED_BANNER_CONTENT_ID }?.measure(
                    constraints
                )

            val chipContentPlaceable =
                measurables.firstOrNull { it.layoutId == CHIPS_CONTENT_ID }
                    ?.measure(constraints)

            val collapsedHeightPx = MinCollapsedHeight.toPx()
            var layoutHeightPx = collapsedHeightPx

            val topRowToolBarX = horizontalPaddingPx.roundToInt()
            val topRowToolBarY = verticalPaddingPx.roundToInt()

            var collapsingBannerContentX = horizontalPaddingPx.roundToInt()
            var collapsingBannerContentY =
                topRowToolBarY + (topRowToolBarPlaceable?.height ?: 0)


            if (expandedBannerContentPlaceable != null) {
                val heightOffsetLimitPx =
                    expandedBannerContentPlaceable.height + expandedBannerContentBottomPaddingPx

                scrollBehavior?.state?.heightOffsetLimit = heightOffsetLimitPx.unaryMinus()


                val fullyExpandedHeightPx = MinCollapsedHeight.toPx() + heightOffsetLimitPx

                val fullyExpandedBannerContentX = horizontalPaddingPx
                val fullyExpandedBannerContentY =
                    fullyExpandedHeightPx - expandedBannerContentPlaceable.height - expandedBannerContentBottomPaddingPx

                val fullyCollapsingBannerContentX = horizontalPaddingPx
                val fullyCollapsingBannerContentY = 0f

                layoutHeightPx =
                    lerp(fullyExpandedHeightPx, collapsedHeightPx, collapsedFraction)

                collapsingBannerContentX = lerp(
                    fullyExpandedBannerContentX,
                    fullyCollapsingBannerContentX,
                    collapsedFraction
                ).roundToInt()
                collapsingBannerContentY = lerp(
                    fullyExpandedBannerContentY,
                    fullyCollapsingBannerContentY,
                    collapsedFraction
                ).roundToInt()
            } else {
                scrollBehavior?.state?.heightOffsetLimit = -1f
            }

            val toolbarHeightPx =
                layoutHeightPx.roundToInt() + (chipContentPlaceable?.height ?: 0)

            layout(
                width = constraints.maxWidth,
                height = toolbarHeightPx
            ) {
                topRowToolBarPlaceable?.placeRelative(
                    x = topRowToolBarX,
                    y = topRowToolBarY
                )

                expandedBannerContentPlaceable?.placeRelativeWithLayer(
                    x = collapsingBannerContentX,
                    y = collapsingBannerContentY,
                    layerBlock = { alpha = 1 - collapsedFraction }
                )

                chipContentPlaceable?.placeRelative(
                    x = horizontalPaddingPx.roundToInt(),
                    y = layoutHeightPx.roundToInt()
                )
            }
        }
    )
}
//}

private fun lerp(a: Float, b: Float, fraction: Float): Float {
    return a + fraction * (b - a)
}

private val HorizontalPadding = 0.dp
private val VerticalPadding = 16.dp
private val MinCollapsedHeight = 56.dp
private val ExpandedBannerContentBottomPadding = 8.dp
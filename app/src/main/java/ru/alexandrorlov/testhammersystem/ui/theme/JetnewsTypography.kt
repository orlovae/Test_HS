package ru.alexandrorlov.testhammersystem.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val HSTypography = Typography(
    //Card Title
    titleLarge = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 19.sp,
        color = colorFontCardTitle
    ),
    //Spinner
    titleMedium = TextStyle(
        fontFamily = robotoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 19.sp,
        color = colorFontSpinner,
    ),
    //Bottom bar
    labelLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    //Chip select
    labelMedium = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = colorFontChipFontSelect,
    ),
    //Chip unselect
    labelSmall = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = colorFontChipUnselect,
    ),
    //Card body
    bodyMedium = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 17.sp,
        color = colorFontCardBody,
    ),
    //Card price
    bodySmall = TextStyle(
        fontFamily = sfUiDisplayFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        color = colorFontCardPrice,
    ),
    //State
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        color = colorFontState,
    ),
)
package ru.alexandrorlov.testhammersystem.ui.components.top_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.alexandrorlov.testhammersystem.R

@Composable
fun QrCode(

) {
    IconButton(
        onClick = { },
    ) {
        Icon(
            painterResource(id = R.drawable.qr_code),
            contentDescription = stringResource(R.string.top_bar_QR_Code)
        )
    }
}
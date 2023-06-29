package ru.alexandrorlov.testhammersystem.ui.components.state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography
import ru.alexandrorlov.testhammersystem.ui.theme.padding_normal

@Composable
fun StateEmpty(
    message: String
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = message,
            textAlign = TextAlign.Center,
            style = HSTypography.bodyLarge,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(padding_normal)
        )
    }
}
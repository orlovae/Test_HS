package ru.alexandrorlov.testhammersystem.ui.components.state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ru.alexandrorlov.testhammersystem.ui.theme.HSTypography

@Composable
fun StateError(
    message: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = message,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            style = HSTypography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}
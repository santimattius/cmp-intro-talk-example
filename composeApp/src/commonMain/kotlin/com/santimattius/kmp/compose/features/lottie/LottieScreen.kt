package com.santimattius.kmp.compose.features.lottie

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santimattius.kmp.compose.core.ui.components.LottieLoader

@Composable
fun LottieScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        LottieLoader(
            resource = "files/avocado.json",
            contentDescription = "Avocado Loading"
        )
    }
}
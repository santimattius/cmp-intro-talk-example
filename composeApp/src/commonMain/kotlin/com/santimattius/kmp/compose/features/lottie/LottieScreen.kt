package com.santimattius.kmp.compose.features.lottie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santimattius.kmp.compose.core.ui.components.AppBar
import com.santimattius.kmp.compose.core.ui.components.BackIcon
import com.santimattius.kmp.compose.core.ui.components.LottieLoader

@Composable
fun LottieScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Compose Skeleton",
                navigationIcon = {
                    BackIcon(onClick = onBack)
                }
            )
        },
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LottieLoader(
                resource = "files/avocado.json",
                contentDescription = "Avocado Loading"
            )
        }
    }
}
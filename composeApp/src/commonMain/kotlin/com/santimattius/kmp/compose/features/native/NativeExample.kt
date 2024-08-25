package com.santimattius.kmp.compose.features.native

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NativeExample(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        WebView(url = "https://www.google.com")
    }
}

@Composable
expect fun WebView(modifier: Modifier = Modifier, url: String)
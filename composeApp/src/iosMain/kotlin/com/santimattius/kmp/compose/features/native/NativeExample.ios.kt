package com.santimattius.kmp.compose.features.native

import LocalNativeViewFactory
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun WebView(modifier: Modifier, url: String) {

    val nativeViewFactory = LocalNativeViewFactory.current

    UIKitViewController(
        modifier = Modifier
            .fillMaxSize(),
        factory = { nativeViewFactory.createWebView(url) },
        update = {}
    )
}
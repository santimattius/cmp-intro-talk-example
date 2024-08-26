package com.santimattius.kmp.compose.features.native

import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView as AndroidWebView

@Composable
actual fun WebView(modifier: Modifier, url: String) {

    AndroidView(factory = {
        AndroidWebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            loadUrl(url)
            webViewClient = CustomWebViewClient()
        }
    }, update = {
//        it.loadUrl(url)
    })
}

class CustomWebViewClient : WebViewClient() {
    @Deprecated(
        "Deprecated in Java",
        ReplaceWith("url != null && url.startsWith(\"https://google.com\")")
    )
    override fun shouldOverrideUrlLoading(view: AndroidWebView?, url: String?): Boolean {
        return url != null && url.startsWith("https://google.com")
    }
}
package com.santimattius.kmp.compose.features.menu

enum class MenuOptions(
    val title: String,
    val route: String
) {
    Flutter("Flutter Counter", "/flutter"),
    Random("Network Image", "/random"),
    Lottie("Lottie Animation", "/lottie"),
}
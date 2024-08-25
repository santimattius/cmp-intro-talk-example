package com.santimattius.kmp.compose.features.menu

enum class MenuOptions(
    val title: String,
    val route: String,
    val order: Int = 99
) {
    AnimatedVisibility("Animated Visibility", "/animated"),
    Flutter("Flutter Counter", "/flutter"),
    Random("Network Image", "/random"),
    Lottie("Lottie Animation", "/lottie"),
    Permissions("Permissions", ""),
    Example1("1: Composable", "/example1", order = 1),
    Example2("2: State Management", "/example2", order = 2),
    Example3("3: Compose Layout", "/example3", order = 3),
    NativeSupport("Native Components", "/native", order = 4),
    ;

    companion object {
        fun options(): List<MenuOptions> = entries.sortedBy { it.order }
    }
}
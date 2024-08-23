package com.santimattius.kmp.compose.features.menu

enum class MenuOptions(
    val title: String,
    val route: String,
    val order: Int = 99
) {
    Flutter("Flutter Counter", "/flutter"),
    Random("Network Image", "/random"),
    Lottie("Lottie Animation", "/lottie"),
    Permissions("Permissions", ""),
    Example1("Example 1", "/example1", order = 1),
    Example2("Example 2", "/example2", order = 2),
    Example3("Example 2", "/example2", order = 3),
    ;

    companion object {
        fun options(): List<MenuOptions> = entries.sortedBy { it.order }
    }
}
package com.santimattius.kmp.compose


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.santimattius.kmp.compose.navigation.Menu
import com.santimattius.kmp.compose.navigation.Splash
import kotlinx.coroutines.CoroutineScope
import kotlin.reflect.KClass

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState = remember(navController, coroutineScope) {
    AppState(navController, coroutineScope)
}

class AppState(
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope,
) {

    companion object {
        val HOME_ROUTES = listOf(
            Menu::class.qualifiedName.orEmpty(),
        )
    }

    private val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route.orEmpty()

    val isFullScreen: Boolean
        @Composable get() = !currentRoute.notContainsRoute(Splash::class)


    val showUpNavigation: Boolean
        @Composable get() = !HOME_ROUTES.contains(currentRoute)

    val showTopAppBar: Boolean
        @Composable get() = currentRoute.notContainsRoute(Splash::class)


    fun onUpClick() {
        navController.popBackStack()
    }

    private fun <T : Any> String.notContainsRoute(clazz: KClass<T>): Boolean {
        return if (isBlank()) {
            false
        } else {
            !contains(clazz.qualifiedName.orEmpty())
        }
    }
}
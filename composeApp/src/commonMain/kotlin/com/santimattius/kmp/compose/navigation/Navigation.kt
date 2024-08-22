package com.santimattius.kmp.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santimattius.kmp.compose.features.counter.CounterScreen
import com.santimattius.kmp.compose.features.lottie.LottieScreen
import com.santimattius.kmp.compose.features.menu.MenuOptions
import com.santimattius.kmp.compose.features.menu.MenuScreen
import com.santimattius.kmp.compose.features.random.RandomImageScreen
import com.santimattius.kmp.compose.features.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen {
                with(navController) {
                    popBackStack()
                    navigate(Menu)
                }
            }
        }

        composable<Menu> {
            MenuScreen {
                navController.navigate(it.route)
            }
        }

        composable(
            route = MenuOptions.Random.route
        ) {
            RandomImageScreen {
                navController.popBackStack()
            }
        }

        composable(
            route = MenuOptions.Flutter.route
        ) {
            CounterScreen { navController.popBackStack() }
        }

        composable(
            route = MenuOptions.Lottie.route
        ) {
            LottieScreen { navController.popBackStack() }
        }
    }
}
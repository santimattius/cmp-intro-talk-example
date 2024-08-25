package com.santimattius.kmp.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santimattius.kmp.compose.features.counter.CounterScreen
import com.santimattius.kmp.compose.features.examples.Example1
import com.santimattius.kmp.compose.features.examples.Example2
import com.santimattius.kmp.compose.features.examples.Example3
import com.santimattius.kmp.compose.features.examples.ExampleAnimatedVisibility
import com.santimattius.kmp.compose.features.lottie.LottieScreen
import com.santimattius.kmp.compose.features.menu.MenuOptions
import com.santimattius.kmp.compose.features.menu.MenuScreen
import com.santimattius.kmp.compose.features.native.NativeExample
import com.santimattius.kmp.compose.features.random.RandomImageScreen
import com.santimattius.kmp.compose.features.splash.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController, startDestination = Splash
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
                if (it.route.isNotBlank()) {
                    navController.navigate(it.route)
                }
            }
        }

        composable(
            route = MenuOptions.Random.route
        ) {
            RandomImageScreen()
        }

        composable(
            route = MenuOptions.Flutter.route
        ) {
            CounterScreen()
        }

        composable(
            route = MenuOptions.Lottie.route
        ) {
            LottieScreen()
        }

        composable(
            route = MenuOptions.Example1.route,
        ) {
            Example1()
        }
        composable(
            route = MenuOptions.Example2.route,
        ) {
            Example2()
        }

        composable(
            route = MenuOptions.Example3.route,
        ) {
            Example3()
        }

        composable(
            route = MenuOptions.AnimatedVisibility.route
        ) {
            ExampleAnimatedVisibility()
        }

        composable(
            route = MenuOptions.NativeSupport.route
        ) {
            NativeExample()
        }
    }
}
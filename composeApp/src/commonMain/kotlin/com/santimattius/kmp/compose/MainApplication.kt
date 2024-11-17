package com.santimattius.kmp.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santimattius.kmp.compose.core.ui.components.AppBar
import com.santimattius.kmp.compose.core.ui.components.ArrowBackIcon
import com.santimattius.kmp.compose.di.applicationModules
import com.santimattius.kmp.compose.navigation.AppNavigation
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

fun koinConfiguration(): KoinAppDeclaration = {
    // your configuration & modules here
    modules(applicationModules())
}

@Composable
fun MainApplication() {
    KoinApplication(application = koinConfiguration()) {
        RootContainer()
    }
}

@Composable
fun RootContainer(
    appState: AppState = rememberAppState(),
) {
    val upNavigation: @Composable () -> Unit = {
        ArrowBackIcon {
            appState.onUpClick()
        }
    }

    val empty: @Composable () -> Unit = {}

    Scaffold(
        topBar = {
            val showUpNavigation = appState.showUpNavigation
            val navigation = if (showUpNavigation) upNavigation else empty
            if (appState.showTopAppBar) {
                AppBar(
                    title = if (showUpNavigation) "" else "Compose Multiplaform",
                    navigationIcon = navigation
                )
            }
        },
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(it)) {
            AppNavigation(appState.navController)
        }
    }
}

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

@Composable
fun MainApplication() {
    KoinApplication(application = {
        modules(applicationModules())
    }) {
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
            val navigation = if (appState.showUpNavigation) upNavigation else empty
            if (appState.showTopAppBar) {
                AppBar(
                    title = "Intro to Compose Multiplatform",
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

package com.santimattius.kmp.compose.features.permissions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory

@Composable
fun PermissionExample(modifier: Modifier = Modifier) {
    val permission = Permission.GALLERY
    var isPermissionGranted: Boolean by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Permission is ${if (isPermissionGranted) "granted" else "not granted"}",
            style = MaterialTheme.typography.titleLarge
        )
    }
    LaunchPermissionRequest(permission) { isGranted ->
        isPermissionGranted = isGranted
    }
}

@Composable
fun LaunchPermissionRequest(permission: Permission, onResult: (Boolean) -> Unit) {
    val factory: PermissionsControllerFactory = rememberPermissionsControllerFactory()
    val controller: PermissionsController =
        remember(factory) { factory.createPermissionsController() }
    BindEffect(controller)
    LaunchedEffect(controller) {
        try {
            controller.providePermission(permission)
            onResult(controller.isPermissionGranted(permission))
        } catch (ex: DeniedException) {
            onResult(false)
        } catch (ex: DeniedAlwaysException) {
            onResult(false)
        }
    }
}
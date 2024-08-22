package com.santimattius.kmp.compose.features.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.santimattius.kmp.compose.core.ui.components.AppBar
import com.santimattius.kmp.compose.core.ui.components.BackIcon

@Composable
fun CounterScreen(
    onBack: () -> Unit
) {
    var incrementCounter by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            AppBar(
                title = "Compose Demo Home Page",
                navigationIcon = { BackIcon(onBack) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    incrementCounter += 1
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Increment"
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "You have pushed the button this many times")
            Text(
                text = "$incrementCounter",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}

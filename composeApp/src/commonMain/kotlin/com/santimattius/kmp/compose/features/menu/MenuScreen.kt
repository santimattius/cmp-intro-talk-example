package com.santimattius.kmp.compose.features.menu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.santimattius.kmp.compose.core.ui.components.AppBar
import com.santimattius.kmp.compose.core.ui.components.PrimaryButton

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    onOptionSelected: (MenuOptions) -> Unit,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Demo Compose",
            )
        }
    ) { padding ->
        Box(
            modifier = modifier.fillMaxSize().padding(padding)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
            ) {
                items(items = MenuOptions.entries.toTypedArray()) { option ->
                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = option.title,
                        onClick = { onOptionSelected(option) }
                    )
                }
            }
        }
    }
}
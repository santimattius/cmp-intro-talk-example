package com.santimattius.kmp.compose.core.data

import kotlinx.serialization.json.Json

val json = Json { allowStructuredMapKeys = true }

inline fun <reified T : Any> decodeFromString(jsonStr: String): T {
    return json.decodeFromString<T>(jsonStr)
}
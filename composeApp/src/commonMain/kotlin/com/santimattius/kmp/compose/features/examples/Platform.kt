package com.santimattius.kmp.compose.features.examples

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.santimattius.kmp.compose.di

import com.santimattius.kmp.compose.core.data.PictureRepository
import com.santimattius.kmp.compose.core.data.sources.KtorPictureNetworkDataSource
import com.santimattius.kmp.compose.core.data.sources.MockNetworkDataSource
import com.santimattius.kmp.compose.core.data.sources.PictureNetworkDataSource
import com.santimattius.kmp.compose.core.network.ktorHttpClient
import com.santimattius.kmp.compose.features.random.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val sharedModules = module {
    single(qualifier(AppQualifiers.BaseUrl)) { "https://api-picture.onrender.com" }
    single(qualifier(AppQualifiers.Client)) {
        ktorHttpClient(
            baseUrl = get(
                qualifier = qualifier(
                    AppQualifiers.BaseUrl
                )
            )
        )
    }

    single<PictureNetworkDataSource>(qualifier(Network.Real)) {
        KtorPictureNetworkDataSource(get(qualifier(AppQualifiers.Client)))
    }

    single<PictureNetworkDataSource>(qualifier(Network.Mock)) {
        MockNetworkDataSource()
    }

    single { PictureRepository(get(qualifier(Network.Mock))) }
}

val homeModule = module {
    viewModelOf(::HomeViewModel)
}


fun applicationModules() = listOf(sharedModules, homeModule)
package com.santimattius.kmp.compose.core.data.sources

import cmp_intro_talk_example.composeapp.generated.resources.Res
import com.santimattius.kmp.compose.core.data.Picture
import com.santimattius.kmp.compose.core.data.decodeFromString
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi

interface PictureNetworkDataSource {
    suspend fun random(): Result<Picture>
}

class KtorPictureNetworkDataSource(
    private val client: HttpClient,
) : PictureNetworkDataSource {
    override suspend fun random(): Result<Picture> = runCatching {
        client.get("/random").body<Picture>()
    }
}

@OptIn(ExperimentalResourceApi::class)
class MockNetworkDataSource : PictureNetworkDataSource {

    override suspend fun random(): Result<Picture> = runCatching {
        delay(1000L)
        val jsonStr = Res.readBytes("files/pictures.json").decodeToString()
        val pictures = decodeFromString<List<Picture>>(jsonStr)
        pictures.random()
    }
}
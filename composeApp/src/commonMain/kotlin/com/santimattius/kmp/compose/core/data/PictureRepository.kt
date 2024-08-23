package com.santimattius.kmp.compose.core.data

import com.santimattius.kmp.compose.core.data.sources.PictureNetworkDataSource
import com.santimattius.kmp.compose.core.domain.Picture as DomainPicture

private fun Picture.asDomain(): DomainPicture {
    return DomainPicture(this.id, this.author, this.downloadURL)
}

class PictureRepository(
    private val networkDataSource: PictureNetworkDataSource,
) {
    suspend fun random() = networkDataSource.random().fold(
        onSuccess = { Result.success(it.asDomain()) },
        onFailure = { Result.failure(it) }
    )
}


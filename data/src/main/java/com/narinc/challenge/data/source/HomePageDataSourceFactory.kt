package com.narinc.challenge.data.source

import com.narinc.challenge.data.repository.HomePageCache
import javax.inject.Inject

open class HomePageDataSourceFactory @Inject constructor(
    private val cache: HomePageCache,
    private val cacheDataSource: HomePageCacheDataSource,
    private val remoteDataSource: HomePageRemoteDataSource
) {

    open suspend fun getDataStore(isCached: Boolean) =
        if (isCached && !cache.isExpired()) {
            getCacheDataSource()
        } else remoteDataSource

    fun getCacheDataSource() = cacheDataSource
}

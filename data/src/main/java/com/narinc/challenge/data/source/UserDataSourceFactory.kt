package com.narinc.challenge.data.source

import com.narinc.challenge.data.repository.UserDataSource
import javax.inject.Inject

open class UserDataSourceFactory @Inject constructor(
    private val cacheDataSource: UserCacheDataSource
) {

    open suspend fun getDataStore(): UserDataSource {
        return cacheDataSource
    }
}

package com.narinc.challenge.data.source

import javax.inject.Inject

open class HomePageDataSourceFactory @Inject constructor(
    private val remoteDataSource: HomePageRemoteDataSource
) {

    open suspend fun getDataStore() = remoteDataSource
}

package com.narinc.challenge.data.source

import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.data.repository.HomePageDataSource
import com.narinc.challenge.data.repository.HomePageRemote
import javax.inject.Inject

class HomePageRemoteDataSource @Inject constructor(
    private val remote: HomePageRemote
) : HomePageDataSource {

    override suspend fun getHomePageEntities() = remote.getHomePageEntities()

    override suspend fun saveHomePageEntities(entities: List<HomePageEntity>) {
        throw UnsupportedOperationException("save HomePageEntities is not supported for RemoteDataSource.")
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }
}

package com.narinc.challenge.data.source

import com.narinc.challenge.data.repository.HomePageDataSource
import com.narinc.challenge.data.repository.HomePageRemote
import javax.inject.Inject

class HomePageRemoteDataSource @Inject constructor(
    private val remote: HomePageRemote
) : HomePageDataSource {

    override suspend fun getHomePageEntities() = remote.getHomePageEntities()
}

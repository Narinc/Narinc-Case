package com.narinc.challenge.data.source

import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.data.repository.HomePageCache
import com.narinc.challenge.data.repository.HomePageDataSource
import javax.inject.Inject

class HomePageCacheDataSource @Inject constructor(
    private val cache: HomePageCache
) : HomePageDataSource {

    override suspend fun getHomePageEntities(): List<HomePageEntity> = cache.getHomePage()

    override suspend fun saveHomePageEntities(entities: List<HomePageEntity>) {
        cache.saveHomePage(entities)
        cache.setLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun isCached(): Boolean {
        return cache.isCached()
    }
}

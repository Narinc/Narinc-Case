package com.narinc.challenge

import com.narinc.challenge.cache.dao.HomePageDao
import com.narinc.challenge.cache.mapper.HomePageCacheMapper
import com.narinc.challenge.cache.utils.CachePreferencesHelper
import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.data.repository.HomePageCache
import javax.inject.Inject

class HomePageCacheImpl @Inject constructor(
    private val dao: HomePageDao,
    private val mapper: HomePageCacheMapper,
    private val preferencesHelper: CachePreferencesHelper
) : HomePageCache {

    override suspend fun getHomePage(): List<HomePageEntity> {
        return mapper.mapFromCached(dao.getHomePage())
    }

    override suspend fun saveHomePage(entities: List<HomePageEntity>) {
        dao.saveHomePage(data = mapper.mapToCached(entities).toTypedArray())
    }

    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    override suspend fun isCached(): Boolean {
        return dao.getHomePage().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

    companion object {
        /**
         * Expiration time set to 5 minutes
         */
        const val EXPIRATION_TIME = (60 * 5 * 1000).toLong()
    }
}

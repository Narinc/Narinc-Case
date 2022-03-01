package com.narinc.challenge.data.repository

import com.narinc.challenge.data.models.HomePageEntity

interface HomePageCache {
    suspend fun getHomePage(): List<HomePageEntity>
    suspend fun saveHomePage(entities: List<HomePageEntity>)
    suspend fun isExpired(): Boolean
    suspend fun isCached(): Boolean
    suspend fun setLastCacheTime(lastCache: Long)
}

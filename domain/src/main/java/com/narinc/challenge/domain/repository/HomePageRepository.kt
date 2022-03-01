package com.narinc.challenge.domain.repository

import com.narinc.challenge.domain.models.HomePageData
import kotlinx.coroutines.flow.Flow

interface HomePageRepository {
    suspend fun getHomePageData(): Flow<List<HomePageData>>
}

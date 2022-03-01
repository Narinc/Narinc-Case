package com.narinc.challenge.data.repository

import com.narinc.challenge.data.models.HomePageEntity

interface HomePageDataSource {

    suspend fun getHomePageEntities(): List<HomePageEntity>
}

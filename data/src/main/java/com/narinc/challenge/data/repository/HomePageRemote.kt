package com.narinc.challenge.data.repository

import com.narinc.challenge.data.models.HomePageEntity

interface HomePageRemote {
    suspend fun getHomePageEntities(): List<HomePageEntity>
}

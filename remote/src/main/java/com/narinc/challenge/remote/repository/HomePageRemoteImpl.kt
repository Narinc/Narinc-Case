package com.narinc.challenge.remote.repository

import com.narinc.challenge.data.repository.HomePageRemote
import com.narinc.challenge.remote.api.AppService
import com.narinc.challenge.remote.mappers.HomePageEntityMapper
import javax.inject.Inject

class HomePageRemoteImpl @Inject constructor(
    private val service: AppService,
    private val mapper: HomePageEntityMapper
) : HomePageRemote {

    override suspend fun getHomePageEntities() = mapper.mapFromModel(service.getData())
}

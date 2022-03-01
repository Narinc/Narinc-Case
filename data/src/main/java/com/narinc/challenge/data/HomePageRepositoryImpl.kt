package com.narinc.challenge.data

import com.narinc.challenge.data.mapper.HomePageDataMapper
import com.narinc.challenge.data.source.HomePageDataSourceFactory
import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.domain.repository.HomePageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomePageRepositoryImpl @Inject constructor(
    private val dataSourceFactory: HomePageDataSourceFactory,
    private val mapper: HomePageDataMapper
) : HomePageRepository {

    override suspend fun getHomePageData(): Flow<List<HomePageData>> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isCached()
        val list = dataSourceFactory.getDataStore(isCached).getHomePageEntities().map {
            mapper.mapFromEntity(it)
        }
        saveHomePage(list)
        emit(list)
    }

    private suspend fun saveHomePage(list: List<HomePageData>) {
        dataSourceFactory.getCacheDataSource().saveHomePageEntities(
            list.map {
                mapper.mapToEntity(it)
            }
        )
    }
}

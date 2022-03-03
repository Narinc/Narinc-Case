package com.narinc.challenge.remote.repository

import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.data.repository.HomePageRemote
import com.narinc.challenge.remote.api.AppService
import com.narinc.challenge.remote.mappers.MeditationMapper
import com.narinc.challenge.remote.mappers.StoryMapper
import javax.inject.Inject

class HomePageRemoteImpl @Inject constructor(
    private val service: AppService,
    private val meditationMapper: MeditationMapper,
    private val storyMapper: StoryMapper
) : HomePageRemote {

    override suspend fun getHomePageEntities(): List<HomePageEntity> {
        val response = service.getData()
        val homePageMeditationEntity = HomePageEntity(
            HomePageEntity.Type.MEDITATION,
            response.meditations?.map {
                meditationMapper.mapFromModel(it)
            }
        )
        val homePageStoryEntity = HomePageEntity(
            HomePageEntity.Type.STORY,
            response.stories?.map {
                storyMapper.mapFromModel(it)
            }
        )
        val homePageCardEntity = HomePageEntity(
            HomePageEntity.Type.CARD
        )
        return listOf(
            homePageMeditationEntity,
            homePageCardEntity,
            homePageStoryEntity
        )
    }
}

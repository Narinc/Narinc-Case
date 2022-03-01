package com.narinc.challenge.remote.mappers

import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.remote.models.response.HomePageResponse
import javax.inject.Inject

class HomePageEntityMapper @Inject constructor(
    private val meditationEntityMapper: MeditationToHomePageItemEntityMapper,
    private val storyEntityMapper: StoryToHomePageItemEntityMapper
) : EntityMapper<HomePageResponse, List<HomePageEntity>> {

    override fun mapFromModel(model: HomePageResponse): List<HomePageEntity> {
        return listOf(
            HomePageEntity(
                type = HomePageEntity.Type.MEDITATION,
                items = model.meditations?.map {
                    meditationEntityMapper.mapFromModel(it)
                }
            ),
            HomePageEntity(
                type = HomePageEntity.Type.CARD
            ),
            HomePageEntity(
                type = HomePageEntity.Type.STORY,
                items = model.stories?.map {
                    storyEntityMapper.mapFromModel(it)
                }
            )
        )
    }
}

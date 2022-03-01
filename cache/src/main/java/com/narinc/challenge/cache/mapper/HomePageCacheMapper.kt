package com.narinc.challenge.cache.mapper

import com.narinc.challenge.cache.models.HomePageDataCacheEntity
import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.data.models.ImageEntity
import javax.inject.Inject

class HomePageCacheMapper @Inject constructor() :
    CacheMapper<List<HomePageDataCacheEntity>, List<HomePageEntity>> {
    override fun mapFromCached(type: List<HomePageDataCacheEntity>): List<HomePageEntity> {
        val meditationItems = mutableListOf<HomePageItemEntity>()
        val cardMessages = mutableListOf<HomePageItemEntity>()
        val storyItems = mutableListOf<HomePageItemEntity>()
        type.map {
            when (HomePageEntity.Type.values()[it.type]) {
                HomePageEntity.Type.MEDITATION -> {
                    meditationItems.add(provide(it))
                }
                HomePageEntity.Type.CARD -> {
                    cardMessages.add(provide(it))
                }
                HomePageEntity.Type.STORY -> {
                    storyItems.add(provide(it))
                }
            }
        }
        return listOf(
            HomePageEntity(type = HomePageEntity.Type.MEDITATION, items = meditationItems),
            HomePageEntity(type = HomePageEntity.Type.CARD, items = cardMessages),
            HomePageEntity(type = HomePageEntity.Type.STORY, items = storyItems)
        )
    }

    private fun provide(entity: HomePageDataCacheEntity) = HomePageItemEntity(
        title = entity.title,
        subtitle = entity.subtitle,
        image = ImageEntity(entity.smallImage, entity.largeImage),
        date = entity.date,
        content = entity.content
    )

    override fun mapToCached(type: List<HomePageEntity>): List<HomePageDataCacheEntity> {
        val cacheEntities = mutableListOf<HomePageDataCacheEntity>()
        type.map { page ->
            page.items?.map { item ->
                cacheEntities.add(
                    HomePageDataCacheEntity(
                        type = page.type.value,
                        title = item.title,
                        subtitle = item.subtitle,
                        smallImage = item.image?.small,
                        largeImage = item.image?.large,
                        date = item.date,
                        content = item.content
                    )
                )
            }
        }
        return cacheEntities
    }
}

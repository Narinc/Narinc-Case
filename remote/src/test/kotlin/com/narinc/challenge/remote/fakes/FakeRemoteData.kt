package com.narinc.challenge.remote.fakes

import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.data.models.ImageEntity
import com.narinc.challenge.remote.fakes.FakeValueFactory.randomString
import com.narinc.challenge.remote.models.Image
import com.narinc.challenge.remote.models.Meditation
import com.narinc.challenge.remote.models.Story
import com.narinc.challenge.remote.models.response.HomePageResponse

object FakeRemoteData {

    fun provideHomePageResponse(
        isBannerEnable: Boolean = true,
        storiesSize: Int = 20,
        meditationsSize: Int = 10
    ): HomePageResponse = HomePageResponse(
        isBannerEnable = isBannerEnable,
        meditations = provideMeditationList(meditationsSize),
        stories = provideStoryList(storiesSize)
    )

    private fun provideMeditationList(size: Int): List<Meditation> {
        val meditations = mutableListOf<Meditation>()
        repeat(size) {
            meditations.add(provideMeditationModel())
        }
        return meditations
    }

    fun provideMeditationModel() = Meditation(
        title = randomString(),
        subtitle = randomString(),
        releaseDate = randomString(),
        content = randomString(),
        image = provideImage()
    )

    private fun provideStoryList(size: Int): List<Story> {
        val stories = mutableListOf<Story>()
        repeat(size) {
            stories.add(provideStoryModel())
        }
        return stories
    }

    fun provideStoryModel(): Story {
        return Story(
            name = randomString(),
            category = randomString(),
            date = randomString(),
            text = randomString(),
            image = provideImage()
        )
    }

    private fun provideImage() = Image(
        small = randomString(),
        large = randomString()
    )

    fun provideHomePageItemEntityList(size: Int): List<HomePageItemEntity> {
        val meditations = mutableListOf<HomePageItemEntity>()
        repeat(size) {
            meditations.add(provideHomePageItemEntity())
        }
        return meditations
    }

    private fun provideHomePageItemEntity() = HomePageItemEntity(
        title = randomString(),
        subtitle = randomString(),
        image = provideImageEntity(),
        date = randomString(),
        content = randomString()
    )

    private fun provideImageEntity() = ImageEntity(
        small = randomString(),
        large = randomString()
    )
}

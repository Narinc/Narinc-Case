package com.narinc.challenge.domain.fakes

import com.narinc.challenge.domain.fakes.FakeValueFactory.randomString
import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.domain.models.HomePageItem
import com.narinc.challenge.domain.models.ItemImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object HomePageFakeData {
    fun provideHomePageDataList(
        meditationsSize: Int = 20,
        isBannerEnable: Boolean = true,
        storiesSize: Int = 40,
    ): Flow<List<HomePageData>> = flow {
        val data = mutableListOf<HomePageData>()
        data.add(provideHomePageData(HomePageData.Type.MEDITATION, meditationsSize))
        if (isBannerEnable) {
            data.add(provideHomePageData(HomePageData.Type.CARD, size = 0))
        }
        data.add(provideHomePageData(HomePageData.Type.STORY, storiesSize))
        emit(data)
    }

    private fun provideHomePageData(
        type: HomePageData.Type,
        size: Int = 20
    ) = HomePageData(
        type = type,
        provideHomePageItemList(size)
    )

    private fun provideHomePageItemList(size: Int): List<HomePageItem> {
        val items = mutableListOf<HomePageItem>()
        repeat(size) {
            items.add(provideHomePageItem())
        }
        return items
    }

    private fun provideHomePageItem() = HomePageItem(
        title = randomString(),
        subtitle = randomString(),
        image = ItemImage(randomString(), randomString()),
        date = randomString(),
        content = randomString()
    )
}

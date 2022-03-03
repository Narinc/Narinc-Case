package com.narinc.challenge.data.mapper

import com.narinc.challenge.data.models.HomePageEntity
import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.data.models.ImageEntity
import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.domain.models.HomePageItem
import com.narinc.challenge.domain.models.ItemImage
import javax.inject.Inject

class HomePageDataMapper @Inject constructor() : Mapper<HomePageEntity, HomePageData> {

    override fun mapFromEntity(type: HomePageEntity): HomePageData {
        return HomePageData(
            type = HomePageData.Type.values()[type.type.value],
            items = type.items?.map {
                HomePageItem(
                    title = it.title,
                    subtitle = it.subtitle,
                    image = ItemImage(it.image?.small, it.image?.large),
                    date = it.date,
                    content = it.content
                )
            }
        )
    }

    override fun mapToEntity(type: HomePageData): HomePageEntity {
        return HomePageEntity(
            type = HomePageEntity.Type.values()[type.type.value],
            items = type.items?.map {
                HomePageItemEntity(
                    title = it.title,
                    subtitle = it.subtitle,
                    image = ImageEntity(it.image?.small, it.image?.large),
                    date = it.date,
                    content = it.content
                )
            }
        )
    }
}
